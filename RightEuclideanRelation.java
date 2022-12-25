package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class RightEuclideanRelation implements GraphProperty {
    @Override
    public boolean execute(Graph abstractGraph) {
        Map<UUID, Map<UUID, Integer>> adjacencyMatrix = new HashMap<>();

        createDistanceMatrix(abstractGraph, adjacencyMatrix);

        return getResult(abstractGraph, adjacencyMatrix);
    }

    private void createDistanceMatrix(Graph graph, Map<UUID, Map<UUID, Integer>> adjacencyMatrix) {
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

    private boolean getResult(Graph graph, Map<UUID, Map<UUID, Integer>> adjacencyMatrix) {
        for (UUID vertex1 : graph.getVertices().keySet()) {
            for (UUID vertex2 : graph.getVertices().keySet()) {
                if (adjacencyMatrix.get(vertex1).get(vertex2) == 1) {
                    for (UUID vertex3 : graph.getVertices().keySet()) {
                        if (adjacencyMatrix.get(vertex1).get(vertex3) == 1 && vertex3 != vertex2) {
                            if (adjacencyMatrix.get(vertex2).get(vertex3) != 1 ||
                                    adjacencyMatrix.get(vertex3).get(vertex2) != 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
