package com.aec.fuelRoute.repository;

import com.aec.fuelRoute.model.Station;

import java.util.List;

public interface StationRepository extends StationManager, RouteManager {
    List<Station> getAllStations();
}
