package com.aec.fuelRoute.algorithm;

import com.aec.fuelRoute.model.Station;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DijkstraAlgorithm {

    public List<Station> findShortestPath(Station start, Station end, List<Station> allStations) {
        // Manejo de casos borde
        if (start == null || end == null || allStations == null || allStations.isEmpty()) {
            return Collections.emptyList();
        }

        if (start.equals(end)) {
            return Collections.singletonList(start);
        }

        Map<Station, Double> distances = new HashMap<>();
        Map<Station, Station> previousStations = new HashMap<>();
        PriorityQueue<Station> queue = new PriorityQueue<>(
                Comparator.comparingDouble(distances::get));

        // Inicialización
        for (Station station : allStations) {
            distances.put(station, Double.MAX_VALUE);
            previousStations.put(station, null);
        }
        distances.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Station current = queue.poll();
            if (current.equals(end)) {
                break;
            }

            for (Map.Entry<Station, Double> neighborEntry : current.getRoutes().entrySet()) {
                Station neighbor = neighborEntry.getKey();
                double cost = neighborEntry.getValue();

                // Manejo de costos negativos
                if (cost < 0) {
                    throw new IllegalArgumentException("El grafo contiene costos negativos");
                }

                double newDist = distances.get(current) + cost;
                if (newDist < distances.get(neighbor)) {
                    queue.remove(neighbor);
                    distances.put(neighbor, newDist);
                    previousStations.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        // Reconstrucción del camino
        return reconstructPath(previousStations, end);
    }

    private List<Station> reconstructPath(Map<Station, Station> previousStations, Station end) {
        List<Station> path = new ArrayList<>();
        for (Station station = end; station != null; station = previousStations.get(station)) {
            path.add(station);
        }
        Collections.reverse(path);

        // Si el camino no llega al inicio, significa que no hay ruta
        if (path.size() <= 1) {
            return Collections.emptyList();
        }

        return path;
    }
}
