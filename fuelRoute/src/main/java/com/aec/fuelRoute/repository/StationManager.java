package com.aec.fuelRoute.repository;

import com.aec.fuelRoute.model.Station;

public interface StationManager {
    void addStation(Station station);
    Station getStation(String name);
    boolean stationExists(String name);
}