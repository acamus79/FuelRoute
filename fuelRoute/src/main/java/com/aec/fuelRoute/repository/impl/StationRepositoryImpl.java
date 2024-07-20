package com.aec.fuelRoute.repository.impl;

import com.aec.fuelRoute.model.Station;
import com.aec.fuelRoute.repository.StationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StationRepositoryImpl implements StationRepository {
    private Map<String, Station> stations = new HashMap<>();

    @Override
    public void addStation(Station station) {
        stations.put(station.getName(), station);
    }

    @Override
    public Station getStation(String name) {
        return stations.get(name);
    }

    @Override
    public boolean stationExists(String name) {
        return stations.containsKey(name);
    }

    @Override
    public void addRoute(Station origin, Station destination, double cost) {
        origin.addRoute(destination, cost);
        destination.addRoute(origin, cost);
    }

    @Override
    public List<Station> getAllStations() {
        return new ArrayList<>(stations.values());
    }
}
