package org.example;

import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.plugin.plugintype.GraphCharacteristic;

import java.util.*;

public class ChromaticNumber implements GraphCharacteristic {
    @Override
    public Integer execute(Graph graph) {

        if (graph.getVertexCount() == 0)
            return 0;

        Map<UUID, Map<UUID,Integer>> matrix = new HashMap<>();
        List<Vertex> markedVertexes = new ArrayList<>();
        List<Vertex> vertexes = makeList(graph);
        int chromaticNumber = 0;


        for (Vertex vertex : vertexes) {
            Map<UUID,Integer> line = new HashMap<>();
            line.put(vertex.getId(), 1);

            for (Vertex vertex2: vertexes) {
                if (!vertex.equals(vertex2)) {
                    line.put(vertex2.getId(), 0);
                }
            }

            matrix.put(vertex.getId(), line);
        }

        for (Edge edge: graph.getEdges()) {
            Map<UUID,Integer> line = matrix.get(edge.getFromV());
            line.put(edge.getToV(), 1);
            matrix.replace(edge.getFromV(), line);

            line = matrix.get(edge.getToV());
            line.put(edge.getFromV(), 1);
            matrix.replace(edge.getToV(), line);
        }

        for (Vertex vertex: vertexes) {
            Map<UUID,Integer> line = matrix.get(vertex.getId());

            if (!markedVertexes.contains(vertex)) {
                markedVertexes.add(vertex);

               while (line.containsValue(0)) {
                   for (Vertex vertex2 : vertexes) {
                       if (line.get(vertex2.getId()) == 0) {
                           if (!markedVertexes.contains(vertex2)) {
                               Map<UUID, Integer> line2 = matrix.get(vertex2.getId());
                               Map<UUID, Integer> line3 = new HashMap<>();

                               for (Vertex vertex3 : vertexes) {
                                   int value;
                                   value = line.get(vertex3.getId()) + line2.get(vertex3.getId());

                                   if (value == 2)
                                       value = 1;

                                   line3.put(vertex3.getId(), value);
                               }

                               matrix.replace(vertex.getId(), line3);
                               line = matrix.get(vertex.getId());
                               markedVertexes.add(vertex2);

                           } else {
                               line.replace(vertex2.getId(), 1);
                           }
                       }
                   }
               }

                chromaticNumber += 1;
            }
        }

        return chromaticNumber;
    }

    private List<Vertex> makeList(Graph graph) {
        List<Vertex> vertexes = new ArrayList<>();
        List<Vertex> notSortedList = new ArrayList<>(graph.getVertices().values());
        Vertex vertex = notSortedList.get(0);
        vertexes.add(vertex);

        while (vertexes.size() != notSortedList.size()) {
            boolean notFound = true;

            for (Edge edge:graph.getEdges()) {
                if (edge.getToV().equals(vertex.getId())) {
                    if (!vertexes.contains(graph.getVertices().get(edge.getFromV()))) {
                        vertex = graph.getVertices().get(edge.getFromV());
                        vertexes.add(vertex);
                        notFound = false;
                    }
                } else {
                    if (edge.getFromV().equals(vertex.getId())) {
                        if (!vertexes.contains(graph.getVertices().get(edge.getToV()))) {
                            vertex = graph.getVertices().get(edge.getToV());
                            vertexes.add(vertex);
                            notFound = false;
                        }
                    }
                }
            }

            if (notFound) {
                for (Vertex vertex2: notSortedList) {
                    if (!vertexes.contains(vertex2) && notFound) {
                        vertex = vertex2;
                        vertexes.add(vertex);
                        notFound = false;
                    }
                }
            }
        }

        return vertexes;
    }
}
