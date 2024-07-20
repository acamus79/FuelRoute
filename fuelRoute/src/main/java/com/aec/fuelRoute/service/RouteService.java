package com.aec.fuelRoute.service;

import com.aec.fuelRoute.algorithm.DijkstraAlgorithm;
import com.aec.fuelRoute.model.Station;
import com.aec.fuelRoute.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private final StationRepository repository;
    private final DijkstraAlgorithm algorithm;

    @Autowired
    public RouteService(StationRepository repository, DijkstraAlgorithm algorithm) {
        this.repository = repository;
        this.algorithm = algorithm;
    }

    public List<Station> findOptimalRoute(String originName, String destinationName) {
        Station origin = repository.getStation(originName);
        Station destination = repository.getStation(destinationName);

        if (origin == null || destination == null) {
            throw new IllegalArgumentException("Estación de origen o destino no encontrada");
        }

        return algorithm.findShortestPath(origin, destination, repository.getAllStations());
    }
}