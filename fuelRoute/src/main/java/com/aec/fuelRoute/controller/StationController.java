package com.aec.fuelRoute.controller;

import com.aec.fuelRoute.model.Station;
import com.aec.fuelRoute.repository.StationRepository;
import com.aec.fuelRoute.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StationController {
    private final RouteService routeService;
    private final StationRepository repository;

    @Autowired
    public StationController(RouteService routeService, StationRepository repository) {
        this.routeService = routeService;
        this.repository = repository;
    }

    @PostMapping("/stations")
    public ResponseEntity<Void> addStation(@RequestParam String name) {
        repository.addStation(new Station(name));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/routes")
    public ResponseEntity<Void> addRoute(@RequestParam String origin,
                                         @RequestParam String destination,
                                         @RequestParam double cost) {
        Station originStation = repository.getStation(origin);
        Station destinationStation = repository.getStation(destination);
        if (originStation == null || destinationStation == null) {
            return ResponseEntity.badRequest().build();
        }
        repository.addRoute(originStation, destinationStation, cost);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/optimal-route")
    public ResponseEntity<List<String>> getOptimalRoute(@RequestParam String origin,
                                                        @RequestParam String destination) {
        List<Station> optimalRoute = routeService.findOptimalRoute(origin, destination);
        List<String> routeNames = optimalRoute.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
        return ResponseEntity.ok(routeNames);
    }
}