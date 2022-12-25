package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;

import java.util.*;
import java.util.List;

public class K33Graph {

    public Color invertColor(Color color) {
        if (color == Color.green) return Color.pink;
        else return Color.green;
    }

    public boolean dfs_bipartite(Graph graph, Vertex vertex, Color color) {
        vertex.setColor(color);
        List<Vertex> neighbors = getNeighbors(graph, vertex);
        for (Vertex neighbor : neighbors) {
            if (neighbor.getColor() == Color.blue) dfs_bipartite(graph, neighbor, invertColor(color));
            else if (neighbor.getColor() == color) return false;
        }
        return true;
    }

    public boolean checkBipartite(Graph graph) {
        for (var i : graph.getVertices().keySet()) {
            if (graph.getVertices().get(i).getColor() == Color.blue) {
                if (!dfs_bipartite(graph, graph.getVertices().get(i), Color.green)) return false;
            }
        }
        return true;
    }

    public boolean checkK33Graph(Graph graph) {
        Map<UUID, Vertex> vertexes = new HashMap<>();
        for (var i : graph.getVertices().keySet()) {
            if (graph.getVertices().get(i).getColor() == Color.blue) {
                vertexes.put(graph.getVertices().get(i).getId(), graph.getVertices().get(i));
            }
        }
        List<Edge> edges = new ArrayList<>();
        for (Edge edge : graph.getEdges()) {
            if (graph.getVertices().get(edge.getFromV()).getColor() == Color.blue &&
                    graph.getVertices().get(edge.getToV()).getColor() == Color.blue) edges.add(edge);
        }
        if (vertexes.size() == 6 && edges.size() == 9) {
            Graph k33 = new Graph(graph.getDirectType(), graph.getVertexCount(), graph.getEdgeCount(), vertexes, edges);
            return checkBipartite(k33);

        }
        return false;
    }

    public List<Vertex> getNeighbors(Graph graph, Vertex vertex) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge edge : graph.getEdges()) {
            if (edge.getFromV().equals(vertex.getId())) {
                neighbors.add(graph.getVertices().get(edge.getToV()));
            }
            if (edge.getToV().equals(vertex.getId())) {
                neighbors.add(graph.getVertices().get(edge.getFromV()));
            }
        }
        return neighbors;
    }

    public boolean dfs_cycles(Graph graph, Vertex vertex) {
        if (vertex.getColor() == Color.brown) vertex.setColor(Color.red);
        else {
            if (vertex.getColor() != Color.yellow) {
                if (vertex.getColor() == Color.red) {
                    vertex.setColor(Color.blue);
                    return checkK33Graph(graph);
                }
                return false;
            }
            vertex.setColor(Color.blue);
        }
        List<Vertex> neighbors = getNeighbors(graph, vertex);
        for (Vertex neighbor : neighbors) {
            if (dfs_cycles(graph, neighbor)) return true;
        }
        vertex.setColor(Color.yellow);
        return false;
    }

    public boolean hasK33Subgraph(Graph graph) {
        for (var i : graph.getVertices().keySet()) {
            for (var j : graph.getVertices().keySet()) graph.getVertices().get(j).setColor(Color.yellow);
            graph.getVertices().get(i).setColor(Color.brown);
            if (dfs_cycles(graph, graph.getVertices().get(i))) return true;
        }
        return false;
    }
}
