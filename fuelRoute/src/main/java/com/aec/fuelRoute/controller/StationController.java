package com.aec.fuelRoute.controller;

import com.aec.fuelRoute.model.Station;
import com.aec.fuelRoute.repository.StationRepository;
import com.aec.fuelRoute.service.RouteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Add a new station")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Station added successfully", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    @PostMapping("/stations")
    public ResponseEntity<Void> addStation(@RequestParam String name) {
        repository.addStation(new Station(name));
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Add a new route")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Route added successfully", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid input or stations not found", content = @Content)
    })
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

    @Operation(summary = "Get the optimal route between two stations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Optimal route found", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input or stations not found", content = @Content)
    })
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