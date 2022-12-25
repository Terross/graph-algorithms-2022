import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NormalTree implements GraphProperty {
    @Override
    public boolean execute(Graph abstractGraph) {
        List<Edge> notInSubgraph = new ArrayList<>(); // ребра не в подграфе
        List<Edge> inSubgraph = new ArrayList<>(); // ребра в подграфе
        UUID root = new UUID( 0 , 0 ); // стартовая вершина
        for (Vertex vertex : abstractGraph.getVertices().values()) {
            if (vertex.getColor() == Color.red) {
                root = vertex.getId();
            }
        }
        for (Edge edge : abstractGraph.getEdges()) {
            if (edge.getColor() == Color.gray) {
                notInSubgraph.add(edge);
            }
        }
        for (Edge edge : abstractGraph.getEdges()) {
            if (edge.getColor() != Color.gray) {
                inSubgraph.add(edge);
            }
        }
        for (Edge edge_check : abstractGraph.getEdges()) {
            if (notInSubgraph.contains(edge_check)) {
                UUID vertex1 = edge_check.getFromV(); // 1 вершина ребра не из подграфа
                UUID vertex2 = edge_check.getToV(); // 2 вершина ребра не из подграфа
                for (Edge edge : inSubgraph) {
                    List<UUID> visited_1 = new ArrayList<>(); // посещенные вершины при обходе в глубину до 1 вершины
                    visited_1.add(root);
                    List<UUID> visited_2 = new ArrayList<>(); // посещенные вершины при обходе в глубину до 2 вершины
                    visited_2.add(root);
                    if (edge.getToV() == root) {
                        abstractGraph.getVertices().get(edge.getFromV()).setColor(Color.green); // красим первые после корня вершины в зеленый
                        DFS(root, vertex1, edge, visited_1, inSubgraph);
                    }
                    if (edge.getFromV() == root) {
                        abstractGraph.getVertices().get(edge.getToV()).setColor(Color.green);
                        DFS(root, vertex1, edge, visited_1, inSubgraph);
                    }
                    if (edge.getToV() == root) {
                        abstractGraph.getVertices().get(edge.getFromV()).setColor(Color.green);
                        DFS(root, vertex2, edge, visited_2, inSubgraph);
                    }
                    if (edge.getFromV() == root) {
                        abstractGraph.getVertices().get(edge.getToV()).setColor(Color.green);
                        DFS(root, vertex2, edge, visited_2, inSubgraph);
                    }
                    if(edge.getToV() == root){
                        if(!(visited_1.subList(visited_1.lastIndexOf(edge.getFromV()),visited_1.indexOf(vertex1))).contains(vertex2) && !(visited_2.subList(visited_2.lastIndexOf(edge.getFromV()),visited_2.indexOf(vertex2))).contains(vertex1)){
                            return false;
                        }
                    }
                    if(edge.getFromV() == root){
                        if(!(visited_1.subList(visited_1.lastIndexOf(edge.getToV()),visited_1.indexOf(vertex1))).contains(vertex2) && !(visited_2.subList(visited_2.lastIndexOf(edge.getToV()),visited_2.indexOf(vertex2))).contains(vertex1)){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    // функция обхода в глубину
    private void DFS(UUID root, UUID vertex_to_find, Edge edge, List<UUID> visited, List<Edge> inSubgraph) {
        if(!visited.contains(vertex_to_find)){
            if (edge.getToV() == root) {
                if(vertex_to_find != root){
                    visited.add(edge.getFromV());
                    if(vertex_to_find != edge.getFromV()) {
                        for (Edge new_edge : inSubgraph) {
                            if (new_edge != edge && edge.getFromV() == new_edge.getToV() && !visited.contains(edge.getFromV())) {
                                visited.add(new_edge.getFromV());
                                if (vertex_to_find != new_edge.getFromV()) {
                                    DFS(new_edge.getToV(), vertex_to_find, new_edge, visited, inSubgraph);
                                }
                            }
                            if (new_edge != edge && edge.getFromV() == new_edge.getFromV() && !visited.contains(edge.getFromV())) {
                                visited.add(new_edge.getToV());
                                if (vertex_to_find != new_edge.getToV()) {
                                    DFS(new_edge.getFromV(), vertex_to_find, new_edge, visited, inSubgraph);
                                }
                            }
                        }
                    }
                }
            }
            if(edge.getFromV() == root) {
                if(vertex_to_find != root){
                    visited.add(edge.getToV());
                    if(vertex_to_find != edge.getToV()){
                        for(Edge new_edge: inSubgraph){
                            if(new_edge != edge && edge.getToV() == new_edge.getToV() && !visited.contains(edge.getToV())){
                                visited.add(new_edge.getFromV());
                                if(vertex_to_find != new_edge.getFromV()) {
                                    DFS(new_edge.getToV(), vertex_to_find, new_edge, visited, inSubgraph);
                                }
                            }
                            if(new_edge != edge && edge.getToV() == new_edge.getFromV() && !visited.contains(edge.getToV())){
                                visited.add(new_edge.getToV());
                                if(vertex_to_find != new_edge.getToV()) {
                                    DFS(new_edge.getFromV(), vertex_to_find, new_edge, visited, inSubgraph);
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}

