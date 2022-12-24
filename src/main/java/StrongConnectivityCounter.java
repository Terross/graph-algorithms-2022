import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphCharacteristic;

import java.util.*;

public class StrongConnectivityCounter implements GraphCharacteristic {
    @Override
    public Integer execute(Graph graph) {
        Map<UUID, Map<UUID, Boolean>> adjacencyMatrix = new HashMap<>();
        Map<UUID, Boolean> visited = new HashMap<>();
        List<UUID> stack = new ArrayList<>();

        for (UUID vertex : graph.getVertices().keySet()) {
            visited.put(vertex, false);
        }

        createMatrix(graph, adjacencyMatrix);

        return findStrongConnectivityComponents(adjacencyMatrix, visited, stack);
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

            if (graph.getVertices().get(vertex1).getColor() == Color.gray &&
                    graph.getVertices().get(vertex2).getColor() == Color.gray) {

                adjacencyMatrix.get(vertex1).put(vertex2, true);
                if (graph.getDirectType() == GraphType.UNDIRECTED) {
                    adjacencyMatrix.get(vertex2).put(vertex1, true);
                }
            }
        }
    }

    int findStrongConnectivityComponents(Map<UUID, Map<UUID, Boolean>> adjacencyMatrix, Map<UUID, Boolean> visited, List<UUID> stack) {
        int currentComponent = 0;

        for (Map.Entry<UUID, Map<UUID, Boolean>> vertex : adjacencyMatrix.entrySet()) {
            if (!visited.get(vertex.getKey())) {
                DFS1(vertex.getKey(), adjacencyMatrix, visited, stack);
            }
        }

        for (Map.Entry<UUID, Map<UUID, Boolean>> vertex : adjacencyMatrix.entrySet()) {
            visited.put(vertex.getKey(), false);
        }

        while (!stack.isEmpty()) {
            UUID vertex = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            if (!visited.get(vertex)) {
                currentComponent++;
                DFS2(vertex, adjacencyMatrix, visited);
            }
        }

        return currentComponent;
    }

    private void DFS1(UUID vertex, Map<UUID, Map<UUID, Boolean>> adjacencyMatrix, Map<UUID, Boolean> visited, List<UUID> stack) {
        visited.put(vertex, true);
        for (Map.Entry<UUID, Map<UUID, Boolean>> neighbour : adjacencyMatrix.entrySet()) {
            if (adjacencyMatrix.get(vertex).get(neighbour.getKey()) && !visited.get(neighbour.getKey())) {
                DFS1(neighbour.getKey(), adjacencyMatrix, visited, stack);
            }
        }
        stack.add(vertex);
    }

    private void DFS2(UUID vertex, Map<UUID, Map<UUID, Boolean>> adjacencyMatrix, Map<UUID, Boolean> visited) {
        visited.put(vertex, true);
        for (Map.Entry<UUID, Map<UUID, Boolean>> neighbour : adjacencyMatrix.entrySet()) {
            if (adjacencyMatrix.get(neighbour.getKey()).get(vertex) && !visited.get(neighbour.getKey())) {
                DFS2(neighbour.getKey(), adjacencyMatrix, visited);
            }
        }
    }
}
