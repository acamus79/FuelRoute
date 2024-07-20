package com.aec.fuelRoute.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Station {
    private String name;
    private Map<Station, Double> routes;

    public Station(String name) {
        this.name = name;
        this.routes = new HashMap<>();
    }

    /**
     * Añade una ruta desde esta estación a otra estación.
     *
     * @param destination La estación de destino.
     * @param cost El costo de la ruta.
     */
    public void addRoute(Station destination, double cost) {
        routes.put(destination, cost);
    }


    public Map<Station, Double> getRoutes() {
        return new HashMap<>(routes);
    }

    /**
     * Verifica si existe una ruta directa a una estación específica.
     *
     * @param destination La estación de destino a verificar.
     * @return true si existe una ruta directa, false en caso contrario.
     */
    public boolean hasRouteTo(Station destination) {
        return routes.containsKey(destination);
    }

    /**
     * Obtiene el costo de la ruta a una estación específica.
     *
     * @param destination La estación de destino.
     * @return El costo de la ruta, o null si no existe una ruta directa.
     */
    public Double getRouteCost(Station destination) {
        return routes.get(destination);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                '}';
    }
}
