package org.example;

import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class IsTheGraphAForest implements GraphProperty {

    private final Map<UUID, ArrayList<UUID>> adjacency_dict = new HashMap<>();
    private final Map<UUID, Integer> inclusion_dict = new HashMap<>();
    private final Map<UUID, Integer> visited_dict = new HashMap<>();

    private boolean is_cycle = false;

    @Override
    public boolean execute(Graph abstractGraph) {
        if (abstractGraph.getVertexCount() == 0)
            return false;
        if (abstractGraph.getDirectType() == GraphType.DIRECTED) {
            return directedIsForest(abstractGraph);
        } else {
            return undirectedIsForest(abstractGraph);
        }
    }

    public boolean directedIsForest(Graph abstractGraph) {
        for (Map.Entry<UUID, Vertex> pair : abstractGraph.getVertices().entrySet()) {
            this.visited_dict.put(pair.getKey(), 0);
            this.inclusion_dict.put(pair.getKey(), 0);
        }

        for (Map.Entry<UUID, Vertex> pair : abstractGraph.getVertices().entrySet()) {
            ArrayList<UUID> adjacency = new ArrayList<>();

            for (int j = 0; j < abstractGraph.getEdgeCount(); j++) {
                if (abstractGraph.getEdges().get(j).getFromV().equals(pair.getKey()))
                    adjacency.add(abstractGraph.getEdges().get(j).getToV());

                if (abstractGraph.getEdges().get(j).getToV().equals(pair.getKey()))
                    this.inclusion_dict.put(pair.getKey(), inclusion_dict.get(pair.getKey()) + 1);
            }
            this.adjacency_dict.put(pair.getKey(), adjacency);
        }

        for (Map.Entry<UUID, Integer> pair : inclusion_dict.entrySet())
            if (pair.getValue() > 1)
                return false;

        for (Map.Entry<UUID, Integer> pair : inclusion_dict.entrySet()) {
            if (pair.getValue() == 0)
                DFSForDirectedGraph(pair.getKey());
            if (is_cycle)
                return false;
        }

        for (Map.Entry<UUID, Integer> pair : visited_dict.entrySet())
            if (pair.getValue() == 0)
                return false;

        return true;
    }

    private void DFSForDirectedGraph(UUID vertex) {
        visited_dict.put(vertex, -1);
        for (UUID vert : adjacency_dict.get(vertex)) {
            if (visited_dict.get(vert) == 0)
                DFSForDirectedGraph(vert);

            if (visited_dict.get(vert) == -1)
                is_cycle = true;
        }
        visited_dict.put(vertex, 1);
    }

    public boolean undirectedIsForest(Graph abstractGraph) {
        for (Map.Entry<UUID, Vertex> pair : abstractGraph.getVertices().entrySet())
            this.visited_dict.put(pair.getKey(), 0);

        for (Map.Entry<UUID, Vertex> pair : abstractGraph.getVertices().entrySet()) {
            ArrayList<UUID> adjacency = new ArrayList<>();

            for (int j = 0; j < abstractGraph.getEdgeCount(); j++) {
                if (abstractGraph.getEdges().get(j).getToV().equals(pair.getKey()))
                    adjacency.add(abstractGraph.getEdges().get(j).getFromV());

                if (abstractGraph.getEdges().get(j).getFromV().equals(pair.getKey()) && !(abstractGraph.getEdges()
                        .get(j).getFromV().equals(abstractGraph.getEdges().get(j).getToV())))
                    adjacency.add(abstractGraph.getEdges().get(j).getToV());
            }

            this.adjacency_dict.put((pair.getKey()), adjacency);
        }

        for (Map.Entry<UUID, Integer> pair : visited_dict.entrySet()) {
            if (pair.getValue() == 0)
                DFSForUndirectedGraph(pair.getKey(), new UUID(0L, 0L));
            if (is_cycle)
                return false;
        }
        return true;
    }

    private void DFSForUndirectedGraph(UUID vertex, UUID prev_vertex) {
        visited_dict.put(vertex, -1);
        for (UUID vert : adjacency_dict.get(vertex)) {
            if (!vert.equals(prev_vertex)) {
                if (visited_dict.get(vert) == 0)
                    DFSForUndirectedGraph(vert, vertex);
                if (visited_dict.get(vert) == -1)
                    is_cycle = true;
            }
        }
        visited_dict.put(vertex, 1);
    }
}