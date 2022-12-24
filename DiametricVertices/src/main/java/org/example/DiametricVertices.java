package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class DiametricVertices implements GraphProperty {
    @Override
    public boolean execute(Graph abstractGraph) {
        Map<UUID, Map<UUID, Integer>> distanceMatrix = new HashMap<>();
        List<UUID> markedVertexes = new ArrayList<>();

        for (Map.Entry<UUID, Vertex> entry: abstractGraph.getVertices().entrySet()) {
            if (entry.getValue().getColor() != Color.gray) {
                markedVertexes.add(entry.getKey());
            }
        }

        if (markedVertexes.size() < 2) {
            return false;
        }

        createDistanceMatrix(abstractGraph, distanceMatrix);
        runFloydWarshallAlgorithm(abstractGraph, distanceMatrix);

        return isDiametricalVertices(abstractGraph, distanceMatrix, markedVertexes);
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

    private boolean isDiametricalVertices(Graph graph, Map<UUID, Map<UUID, Integer>> distanceMatrix, List<UUID> markedVertexes){
        int diameter = 0;

        for (UUID startVertex : graph.getVertices().keySet()) {
            for (UUID endVertex : graph.getVertices().keySet()) {
                diameter = Math.max(diameter, distanceMatrix.get(startVertex).get(endVertex));
            }
        }

        for (UUID startVertex : markedVertexes) {
            for (UUID endVertex : markedVertexes) {
                boolean is_non_diametric = !startVertex.equals(endVertex) &&
                        (distanceMatrix.get(startVertex).get(endVertex) != diameter);
                if (is_non_diametric) {
                    return false;
                }
            }
        }

        return true;
    }
}
