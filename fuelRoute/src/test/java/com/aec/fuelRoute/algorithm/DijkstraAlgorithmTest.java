package com.aec.fuelRoute.algorithm;

import com.aec.fuelRoute.model.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DijkstraAlgorithmTest {

    @Autowired
    private DijkstraAlgorithm dijkstra;

    @Test
    void testEmptyGraph() {
        List<Station> result = dijkstra.findShortestPath(null, null, Collections.emptyList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testSingleNode() {
        Station s = new Station("S");
        List<Station> result = dijkstra.findShortestPath(s, s, Collections.singletonList(s));
        assertEquals(Collections.singletonList(s), result);
    }

    @Test
    void testSameOriginAndDestination() {
        Station s = new Station("S");
        Station a = new Station("A");
        s.addRoute(a, 1.0);
        List<Station> result = dijkstra.findShortestPath(s, s, Arrays.asList(s, a));
        assertEquals(Collections.singletonList(s), result);
    }

    @Test
    void testNoPath() {
        Station s = new Station("S");
        Station t = new Station("T");
        List<Station> result = dijkstra.findShortestPath(s, t, Arrays.asList(s, t));
        assertTrue(result.isEmpty());
    }

    @Test
    void testMultipleEqualPaths() {
        Station s = new Station("S");
        Station a = new Station("A");
        Station b = new Station("B");
        Station t = new Station("T");
        s.addRoute(a, 1.0);
        s.addRoute(b, 1.0);
        a.addRoute(t, 1.0);
        b.addRoute(t, 1.0);
        List<Station> result = dijkstra.findShortestPath(s, t, Arrays.asList(s, a, b, t));
        assertEquals(3, result.size());
        assertEquals(s, result.get(0));
        assertEquals(t, result.get(2));
        assertTrue(result.get(1).getName().equals("A") || result.get(1).getName().equals("B"));
    }

    @Test
    void testGraphWithCycle() {
        Station s = new Station("S");
        Station a = new Station("A");
        Station b = new Station("B");
        Station t = new Station("T");
        s.addRoute(a, 1.0);
        a.addRoute(b, 1.0);
        b.addRoute(a, 1.0);
        b.addRoute(t, 1.0);
        List<Station> result = dijkstra.findShortestPath(s, t, Arrays.asList(s, a, b, t));
        assertEquals(Arrays.asList(s, a, b, t), result);
    }

    @Test
    void testNegativeEdge() {
        Station s = new Station("S");
        Station a = new Station("A");
        Station t = new Station("T");
        s.addRoute(a, -1.0);
        a.addRoute(t, 1.0);
        assertThrows(IllegalArgumentException.class, () ->
                dijkstra.findShortestPath(s, t, Arrays.asList(s, a, t))
        );
    }
}
