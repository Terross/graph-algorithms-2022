package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class Eccentricity implements GraphProperty {
    @Override
    public boolean execute(Graph abstractGraph) {
        Map<UUID, Map<UUID, Integer>> distanceMatrix = new HashMap<>();

        createDistanceMatrix(abstractGraph, distanceMatrix);
        runFloydWarshallAlgorithm(abstractGraph, distanceMatrix);

        return check(abstractGraph, distanceMatrix);
    }

    private void createDistanceMatrix(Graph graph, Map<UUID, Map<UUID, Integer>> distanceMatrix) {
        int infinity = 999999;

        for (UUID vertex1 : graph.getVertices().keySet()) {
            Map<UUID, Integer> vertexes = new HashMap<>();

            for (UUID vertex2 : graph.getVertices().keySet()) {
                int distance = (vertex1.equals(vertex2)) ? 0 : infinity;
                vertexes.put(vertex2, distance);
            }

            distanceMatrix.put(vertex1, vertexes);
        }

        for (Edge edge : graph.getEdges()) {
            UUID vertex1 = edge.getFromV();
            UUID vertex2 = edge.getToV();
            int weight = (edge.getWeight() != null) ? Math.abs(edge.getWeight()) : 1;

            distanceMatrix.get(vertex1).put(vertex2, weight);
            if (graph.getDirectType() == GraphType.UNDIRECTED) {
                distanceMatrix.get(vertex2).put(vertex1, weight);
            }
        }
    }

    private void runFloydWarshallAlgorithm(Graph graph, Map<UUID, Map<UUID, Integer>> distanceMatrix) {
        for (UUID vertex1 : graph.getVertices().keySet()) {
            for (UUID vertex2 : graph.getVertices().keySet()) {
                for (UUID vertex3 : graph.getVertices().keySet()) {
                    int distance = Math.min(
                            distanceMatrix.get(vertex2).get(vertex3),
                            distanceMatrix.get(vertex2).get(vertex1) + distanceMatrix.get(vertex1).get(vertex3));
                    distanceMatrix.get(vertex2).put(vertex3, distance);
                }
            }
        }
    }

    private boolean check(Graph graph, Map<UUID, Map<UUID, Integer>> distanceMatrix) {
        boolean flag = true;
        int infinity = 999999;
        for (Map.Entry<UUID, Vertex> entry: graph.getVertices().entrySet()){
            UUID startVertex = entry.getKey();
            Vertex first = entry.getValue();
            int distance = 0, inf = 0;
            for (UUID endVertex: graph.getVertices().keySet()) {
                if (distanceMatrix.get(startVertex).get(endVertex) != infinity) {
                    distance = Math.max(distance, distanceMatrix.get(startVertex).get(endVertex));
                }
                if (distanceMatrix.get(startVertex).get(endVertex) == infinity) {
                    inf += 1;
                }
            }
            if (inf == (graph.getVertexCount() -1 )) {
                distance = 0;
            }
            if (distance != first.getWeight()) {
                flag = false;
            }
        }
        return flag;
    }
}