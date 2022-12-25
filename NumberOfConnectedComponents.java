package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class NumberOfConnectedComponents implements GraphCharacteristic {
    @Override
    public int execute(AbstractGraph abstractGraph) {
        int[] positions = {0, 1};
        for (int position : positions) {
            removeVertex(position);
        }
        Graph g = new Graph(abstractGraph.vertexCount - positions.length);

        prepareForCount(g);

        g.DFS();

        return g.ConnecetedComponents();
    }

    void removeVertex(int position) {
        abstractGraph.vertices[position].name = "delete";

        for (Vertex vertex : abstractGraph.vertices) {
            for (AbstractEdge edge : vertex.edgeList) {
                if (edge.other(vertex).name == "delete") {
                    vertex.edgeList.remove(edge);
                }
            }
        }
        abstractGraph.vertices.remove(position);
    }

    void prepareForCount(Graph g) {
        List<Vertex> vertices = abstractGraph.vertices;
        for (Vertex vertex : vertices) {
            for (AbstractEdge edge : vertex.edgeList) {
                if (edge.label != "added") {
                    g.addEdge(vertices.indexOf(vertex), vertices.indexOf(edge.other(vertex)));
                    edge.label = "added";
                }

            }
        }
    }

    class Graph {
        private int V; // No. of vertices in graph.

        private LinkedList<Integer>[] adj; // Adjacency List
        // representation

        ArrayList<ArrayList<Integer>> components
                = new ArrayList<>();

        @SuppressWarnings("unchecked")
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];

            for (int i = 0; i < v; i++)
                adj[i] = new LinkedList();
        }

        void addEdge(int u, int w) {
            adj[u].add(w);
            adj[w].add(u); // Undirected Graph.
        }

        void DFSUtil(int v, boolean[] visited,
                     ArrayList<Integer> al) {
            visited[v] = true;
            al.add(v);
            //System.out.print(v + " ");
            Iterator<Integer> it = adj[v].iterator();

            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n])
                    DFSUtil(n, visited, al);
            }
        }

        void DFS() {
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {
                ArrayList<Integer> al = new ArrayList<>();
                if (!visited[i]) {
                    DFSUtil(i, visited, al);
                    components.add(al);
                }
            }
        }

        int ConnecetedComponents() {return components.size();}
    }
}