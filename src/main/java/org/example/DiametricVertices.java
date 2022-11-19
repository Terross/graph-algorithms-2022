package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class DiametricVertices implements GraphProperty {
    @Override
    public boolean execute(Graph abstractGraph){
        Map<UUID, Map<UUID, Integer>> distanceMatrix = new HashMap<>();
        List<UUID> markedVertexes = new ArrayList<>();

        for(Map.Entry<UUID, Vertex> entry: abstractGraph.getVertices().entrySet()) {
            if(entry.getValue().getColor() != Color.gray){
                markedVertexes.add(entry.getKey());
            }
        }

        createDistanceMatrix(abstractGraph, distanceMatrix);
        runFloydWarshallAlgorithm(abstractGraph, distanceMatrix);

        return isDiametricalVertices(abstractGraph, distanceMatrix, markedVertexes);
    }
    public void createDistanceMatrix(Graph graph, Map<UUID, Map<UUID, Integer>> distanceMatrix) {
        for (UUID vertex1 : graph.getVertices().keySet()) {
            Map<UUID, Integer> vertexes = new HashMap<>();

            for (UUID vertex2 : graph.getVertices().keySet()) {
                int distance = (vertex1 == vertex2) ? 0 : 99999;
                vertexes.put(vertex2, distance);
            }

            distanceMatrix.put(vertex1, vertexes);
        }

        for (Edge edge : graph.getEdges()) {
            UUID vertex1 = edge.getFromV();
            UUID vertex2 = edge.getToV();
            int weight = (edge.getWeight() != null) ? edge.getWeight() : 1;

            distanceMatrix.get(vertex1).put(vertex2, weight);
            distanceMatrix.get(vertex2).put(vertex1, weight);
        }
    }

    public void runFloydWarshallAlgorithm(Graph graph, Map<UUID, Map<UUID, Integer>> distanceMatrix){
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

    public boolean isDiametricalVertices(Graph graph, Map<UUID, Map<UUID, Integer>> distanceMatrix, List<UUID> markedVertexes){
        int diameter = 0;

        if (markedVertexes.size() < 2){
            return false;
        }

        for (UUID startVertex : graph.getVertices().keySet()) {
            for (UUID endVertex : graph.getVertices().keySet()) {
                diameter = Math.max(diameter, distanceMatrix.get(startVertex).get(endVertex));
            }
        }

        for (UUID startVertex : markedVertexes) {
            for (UUID endVertex : markedVertexes) {
                if ((startVertex != endVertex) && (distanceMatrix.get(startVertex).get(endVertex) != diameter)){
                    return false;
                }
            }
        }

        return true;
    }

    public String getSomeString1() {
        return "Some string 1";
    }

    public String getSomeString2() {
        return "Some string 2";
    }

    public int getNumber1() {
        return 17;
    }

    public int getNumber2() {
        return 20;
    }

    public int getDifference() {
        getNumber1();

        return getNumber2() - getNumber1();
    }
}
