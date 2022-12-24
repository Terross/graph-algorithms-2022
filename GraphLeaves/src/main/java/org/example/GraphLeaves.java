package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphCharacteristic;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GraphLeaves implements GraphCharacteristic {
    @Override
    public Integer execute(Graph abstractGraph) {

        Map<UUID, Map<UUID, Integer>> adjacencyMatrix = new HashMap<>();
        createAdjacencyMatrix(abstractGraph, adjacencyMatrix);

        return countLeaves(abstractGraph, adjacencyMatrix);
    }

    private void createAdjacencyMatrix(Graph graph, Map<UUID, Map<UUID, Integer>> adjacencyMatrix) {

        for (UUID vertex1 : graph.getVertices().keySet()) {
            Map<UUID, Integer> vertexes = new HashMap<>();

            for (UUID vertex2 : graph.getVertices().keySet()) {
                vertexes.put(vertex2, 0);
            }

            adjacencyMatrix.put(vertex1, vertexes);
        }

        for (Edge edge : graph.getEdges()) {
            UUID vertex1 = edge.getFromV();
            UUID vertex2 = edge.getToV();

            adjacencyMatrix.get(vertex1).put(vertex2, 1);
            if (graph.getDirectType() == GraphType.UNDIRECTED) {
                adjacencyMatrix.get(vertex2).put(vertex1, 1);
            }
        }
    }

    private int countLeaves(Graph graph, Map<UUID, Map<UUID, Integer>> adjacencyMatrix) {
        int counterLeaves = 0;

        if (graph.getDirectType() == GraphType.UNDIRECTED) {
            for (UUID vertex1 : graph.getVertices().keySet()) {
                int horizontalSum = 0;
                for (UUID vertex2 : graph.getVertices().keySet()) {
                    horizontalSum += adjacencyMatrix.get(vertex1).get(vertex2);
                }

                if (horizontalSum == 1 && adjacencyMatrix.get(vertex1).get(vertex1) == 0) {
                    counterLeaves ++;
                }
            }
        } else {
            for (UUID vertex1 : graph.getVertices().keySet()) {
                int horizontalSum = 0;
                int verticalSum = 0;
                for (UUID vertex2 : graph.getVertices().keySet()) {
                    horizontalSum += adjacencyMatrix.get(vertex1).get(vertex2);
                    verticalSum += adjacencyMatrix.get(vertex2).get(vertex1);
                }

                if (horizontalSum == 0 && verticalSum == 1) {
                    counterLeaves ++;
                }
            }
        }

        return counterLeaves;
    }
}