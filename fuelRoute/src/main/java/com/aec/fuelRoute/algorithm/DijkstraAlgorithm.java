package com.aec.fuelRoute.algorithm;

import com.aec.fuelRoute.model.Station;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DijkstraAlgorithm {
    public List<Station> findShortestPath(Station start, Station end, List<Station> allStations) {
        Map<Station, Double> distances = new HashMap<>();
        Map<Station, Station> previousStations = new HashMap<>();
        PriorityQueue<Station> queue = new PriorityQueue<>(
                Comparator.comparingDouble(distances::get));

        for (Station station : allStations) {
            distances.put(station, Double.MAX_VALUE);
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
                double newDist = distances.get(current) + neighborEntry.getValue();
                if (newDist < distances.get(neighbor)) {
                    queue.remove(neighbor);
                    distances.put(neighbor, newDist);
                    previousStations.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return reconstructPath(previousStations, end);
    }

    private List<Station> reconstructPath(Map<Station, Station> previousStations, Station end) {
        List<Station> path = new ArrayList<>();
        for (Station station = end; station != null; station = previousStations.get(station)) {
            path.add(station);
        }
        Collections.reverse(path);
        return path;
    }
}
