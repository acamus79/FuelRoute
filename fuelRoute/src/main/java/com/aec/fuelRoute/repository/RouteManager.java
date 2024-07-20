package com.aec.fuelRoute.repository;

import com.aec.fuelRoute.model.Station;

public interface RouteManager {
    void addRoute(Station origin, Station destination, double cost);
}
