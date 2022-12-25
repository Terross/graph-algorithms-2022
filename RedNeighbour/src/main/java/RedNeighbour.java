import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.plugin.plugintype.GraphCharacteristic;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class RedNeighbour implements GraphCharacteristic {
    @Override
    public Integer execute(Graph graph){

        if (graph.getVertexCount() < 3) //EdgeCount()
            return -1;

        Map<UUID, Map<UUID, Integer>> adjacencyMatrix = new HashMap<>();

        createMatrix(graph, adjacencyMatrix);

        int check = 0;
        int min_red = 999999;


        floyd(graph, adjacencyMatrix);

        for (UUID vertex1 : graph.getVertices().keySet()){
            for (UUID vertex2 : graph.getVertices().keySet()) {
                if (adjacencyMatrix.get(vertex1).get(vertex2)>2){
                    return -1;
                }
            }
        }

        for (UUID vertex1 : graph.getVertices().keySet()){
            if (IsRed(graph, vertex1)){
                for (UUID vertex2 : graph.getVertices().keySet()){
                    int cur_red = 0;
                    if (vertex2 != vertex1){
                        if (IsRed(graph, vertex2)){
                            if (adjacencyMatrix.get(vertex1).get(vertex2) != 1){
                                for (UUID vertex3 : graph.getVertices().keySet()){
                                    if (adjacencyMatrix.get(vertex1).get(vertex3) == 1 && adjacencyMatrix.get(vertex2).get(vertex3) == 1){
                                        cur_red++;
                                    }
                                }
                                if (cur_red != min_red){
                                    if (check == 1){
                                        return -2;
                                    }
                                    check = 1;
                                    min_red = cur_red;
                                }
                            }
                            else{
                                return -2;
                            }
                        }
                    }
                }
            }
        }
        if (min_red == 999999){
            return -2;
        }
        return min_red;
    }

    private void createMatrix(Graph graph, Map<UUID, Map<UUID, Integer>> adjacencyMatrix){
        for (UUID vertex1: graph.getVertices().keySet()){
            Map<UUID, Integer> vertexes = new HashMap<>();

            for (UUID vertex2: graph.getVertices().keySet()){
                vertexes.put(vertex2,3);
            }
            adjacencyMatrix.put(vertex1, vertexes);


        }

        for (Edge edge : graph.getEdges()) {
            UUID vertex1 = edge.getFromV();
            UUID vertex2 = edge.getToV();

            adjacencyMatrix.get(vertex1).put(vertex2, 1);
            adjacencyMatrix.get(vertex2).put(vertex1, 1);
        }
    }

    public boolean IsRed(Graph graph, UUID id) {
        for (Map.Entry <UUID, Vertex> vertex : graph.getVertices().entrySet())
            if (vertex.getKey().equals(id))
                if (vertex.getValue().getColor().equals(Color.red))
                    return true;
        return false;
    }
    private void floyd(Graph graph, Map<UUID, Map<UUID, Integer>> adjacencyMatrix) {
        for (UUID vertex1 : graph.getVertices().keySet()){
            for (UUID vertex2 : graph.getVertices().keySet()){
                for (UUID vertex3 : graph.getVertices().keySet()){
                    adjacencyMatrix.get(vertex2).put(vertex3, Math.min(adjacencyMatrix.get(vertex2).get(vertex3), adjacencyMatrix.get(vertex2).get(vertex1)+adjacencyMatrix.get(vertex1).get(vertex3)));
                }
            }
        }
    }
}
