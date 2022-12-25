
package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphCharacteristic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.lang.model.type.NullType;
import java.util.*;

public class DeficiteByTattBerge implements GraphCharacteristic {
    @Override
    public Integer execute(Graph graph) {

        List<Edge> M = new ArrayList<>();

        Map<UUID, Vertex> map = graph.getVertices();

        List<Edge> array = graph.getEdges();
        for (Edge edge : array) {
            map.get(edge.getToV()).setWeight(0);
            map.get(edge.getToV()).setColor(Color.gray);
            map.get(edge.getFromV()).setWeight(0);
            map.get(edge.getFromV()).setColor(Color.gray);
        }

        for (Edge edge : array) {
            map.get(edge.getToV()).setWeight(map.get(edge.getToV()).getWeight() + 1);
            map.get(edge.getToV()).setWeight(map.get(edge.getFromV()).getWeight() + 1);
        }


        boolean sorted = false;
        Edge temp;
        Set<List<UUID>> set = new HashSet<>();
        List<UUID> keys = new ArrayList<>(map.keySet());
        UUID[] arr = new UUID[graph.getVertexCount()];
        for(int i = 0; i < keys.size(); i++) {
            arr[i] = keys.get(i);
        }
        Arrays.sort(arr);
        int N = (int)Math.pow(2, arr.length);
        for (int i = 0; i < N; i++)
        {
            List<UUID> subset = new ArrayList<>();

            // проверить каждый бит `i`
            for (int j = 0; j < arr.length; j++)
            {
                // если установлен j-й бит `i`, добавляем `S[j]` к подмножеству
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }

            // вставляем подмножество в множество
            set.add(subset);
        }
        int def = -graph.getVertexCount();
        for (List<UUID> list : set) {
            // количество компонент связности при удалении данного множества вершин
            int k = FindCountOfConnectivityComponents(
                    new Graph(graph.getDirectType(),
                            graph.getVertexCount(),
                            graph.getEdgeCount(),
                            graph.getVertices(),
                            graph.getEdges()), list);
            if (k!=-1) {
                def = Math.max(def, k- list.size());
            }
        }
        return def;
    }
    public int FindCountOfConnectivityComponents(Graph graph, List<UUID> set) {
        Map<UUID, Vertex> oldMap= graph.getVertices();
        List<Edge> edgeList = graph.getEdges();
        List<Edge> newEdges = new ArrayList<>();
        Map<UUID,Vertex> newMap = new HashMap<>();
        boolean flag;
        for (Edge edge : edgeList) {
            flag=true;
            for (UUID uuid: set) {
                if (uuid==edge.getToV() || uuid==edge.getFromV()) {
                    flag=false;
                    break;
                }
            }
            if (flag) {
                newEdges.add(edge);
            }
        }
        for (UUID uuid: oldMap.keySet()) {
            flag=true;
            for (UUID v : set) {
                if(v==uuid) {
                    flag=false;
                    break;
                }
            }
            if (flag) {
                newMap.put(uuid, oldMap.get(uuid));
            }
        }
        Graph newGraph = new Graph(graph.getDirectType(), newMap.size(), newEdges.size(), newMap, newEdges);
        if (newGraph.getVertexCount()%2==0) {
            return -1;
        }
        Map<UUID, Map<UUID, Boolean>> adjacencyMatrix = new HashMap<>();
        Map<UUID, Boolean> visited = new HashMap<>();
        List<UUID> stack = new ArrayList<>();

        for (UUID vertex : newGraph.getVertices().keySet()) {
            visited.put(vertex, false);
        }

        createMatrix(newGraph, adjacencyMatrix);
        int currentComponent = 0;

        for (Map.Entry<UUID, Map<UUID, Boolean>> vertex : adjacencyMatrix.entrySet()) {
            if (!visited.get(vertex.getKey())) {
                currentComponent++;
                DFS(newGraph, vertex.getKey(), adjacencyMatrix, visited, stack);
            }
        }
        return currentComponent;
    }
    private void DFS(Graph graph, UUID vertex, Map<UUID, Map<UUID, Boolean>> adjacencyMatrix, Map<UUID, Boolean> visited, List<UUID> stack) {
        visited.put(vertex, true);
        for (Map.Entry<UUID, Map<UUID, Boolean>> neighbour : adjacencyMatrix.entrySet()) {
            if (!visited.get(neighbour.getKey())) {
                DFS(graph, neighbour.getKey(), adjacencyMatrix, visited, stack);
            }
        }
        stack.add(vertex);
    }
    private void createMatrix(Graph graph, Map<UUID, Map<UUID, Boolean>> adjacencyMatrix) {
        for (UUID vertex1 : graph.getVertices().keySet()) {
            if (graph.getVertices().get(vertex1).getColor() == Color.gray) {
                Map<UUID, Boolean> vertexes = new HashMap<>();

                for (UUID vertex2 : graph.getVertices().keySet()) {
                    if (graph.getVertices().get(vertex2).getColor() == Color.gray) {
                        vertexes.put(vertex2, false);
                    }
                }

                adjacencyMatrix.put(vertex1, vertexes);
            }
        }

        for (Edge edge : graph.getEdges()) {
            UUID vertex1 = edge.getFromV();
            UUID vertex2 = edge.getToV();
            if (graph.getVertices().get(vertex1) != null &&
                    graph.getVertices().get(vertex2) != null) {
                if (graph.getVertices().get(vertex1).getColor() == Color.gray &&
                        graph.getVertices().get(vertex2).getColor() == Color.gray) {
                    adjacencyMatrix.get(vertex1).put(vertex2, true);
                    if (graph.getDirectType() == GraphType.UNDIRECTED) {
                        adjacencyMatrix.get(vertex2).put(vertex1, true);
                    }
                }
            }
        }
    }
}
