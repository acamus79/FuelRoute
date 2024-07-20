package com.aec.fuelRoute.service;

import com.aec.fuelRoute.algorithm.DijkstraAlgorithm;
import com.aec.fuelRoute.model.Station;
import com.aec.fuelRoute.repository.StationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RouteServiceTest {

    @Mock
    private StationRepository repository;

    @InjectMocks
    private RouteService routeService;

    private DijkstraAlgorithm algorithm;

    private Station origin;
    private Station destination;
    private Station intermediate;

    @BeforeEach
    void setUp() {
        algorithm = new DijkstraAlgorithm();
        routeService = new RouteService(repository, algorithm);

        origin = new Station("Origin");
        destination = new Station("Destination");
        intermediate = new Station("Intermediate");

        origin.addRoute(intermediate, 10.0);
        intermediate.addRoute(destination, 15.0);
    }

    @Test
    void findOptimalRoute_ValidStations_ReturnsCorrectPath() {
        // Arrange
        List<Station> allStations = Arrays.asList(origin, intermediate, destination);

        when(repository.getStation("Origin")).thenReturn(origin);
        when(repository.getStation("Destination")).thenReturn(destination);
        when(repository.getAllStations()).thenReturn(allStations);

        // Act
        List<Station> result = routeService.findOptimalRoute("Origin", "Destination");

        // Assert
        assertEquals(Arrays.asList(origin, intermediate, destination), result);
        verify(repository).getStation("Origin");
        verify(repository).getStation("Destination");
        verify(repository).getAllStations();
    }

    @Test
    void findOptimalRoute_OriginStationNotFound_ThrowsIllegalArgumentException() {
        // Arrange
        when(repository.getStation("NonExistentOrigin")).thenReturn(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                routeService.findOptimalRoute("NonExistentOrigin", "Destination")
        );
    }

    @Test
    void findOptimalRoute_DestinationStationNotFound_ThrowsIllegalArgumentException() {
        // Arrange
        when(repository.getStation("Origin")).thenReturn(origin);
        when(repository.getStation("NonExistentDestination")).thenReturn(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                routeService.findOptimalRoute("Origin", "NonExistentDestination")
        );
    }

    @Test
    void findOptimalRoute_SameOriginAndDestination_ReturnsSingleStationList() {
        // Arrange
        when(repository.getStation("Origin")).thenReturn(origin);
        when(repository.getAllStations()).thenReturn(Collections.singletonList(origin));

        // Act
        List<Station> result = routeService.findOptimalRoute("Origin", "Origin");

        // Assert
        assertEquals(Collections.singletonList(origin), result);
    }
}