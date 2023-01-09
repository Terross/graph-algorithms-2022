import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class NormalTree implements GraphProperty {
    @Override
    public boolean execute(Graph abstractGraph) {
        List<Edge> notInSubgraph = new ArrayList<>(); // ребра не в подграфе
        List<Edge> inSubgraph = new ArrayList<>(); // ребра в подграфе
        UUID root = new UUID(0, 0); // стартовая вершина
        for (Vertex vertex : abstractGraph.getVertices().values()) { // поиск корня
            if (vertex.getColor() == Color.red) {
                root = vertex.getId();
            }
        }
        for (Edge edge : abstractGraph.getEdges()) { // заполнение списка с непокрашенными ребрами
            if (edge.getColor() == Color.gray) {
                notInSubgraph.add(edge);
            }
        }
        for (Edge edge : abstractGraph.getEdges()) { // заполнение списка с покрашенными ребрами
            if (edge.getColor() != Color.gray) {
                inSubgraph.add(edge);
            }
        }

        if (inSubgraph.size() != abstractGraph.getVertices().size() - 1) { // если подграф не дерево, то и не нормальное дерево
            return false;
        }
        if (notInSubgraph.isEmpty()) { // если подграф - это весь граф, то дерево нормальное
            return true;
        }
        for (Edge edge_check : abstractGraph.getEdges()) {
            if (notInSubgraph.contains(edge_check)) {
                UUID vertex1 = edge_check.getFromV(); // 1 вершина ребра не из подграфа
                UUID vertex2 = edge_check.getToV(); // 2 вершина ребра не из подграфа
                Stack<UUID> stack_dfs_1 = depthFirstSearch(root, vertex1, inSubgraph);
                Stack<UUID> stack_dfs_2 = depthFirstSearch(root, vertex2, inSubgraph);
                if(!stack_dfs_1.contains(vertex2)&&!stack_dfs_2.contains(vertex1)){ // если в стеке есть вершина, значит она встречается на пути
                    return false;
                }
            }
        }
        return true;
    }
    private boolean checkForUnlistedEdges(UUID vertex, List<UUID> visited, List<Edge> inSubgraph){ // проверка на существование смежных вершин
        for(Edge edge : inSubgraph){
            if(edge.getToV().equals(vertex)){
                if(!visited.contains(edge.getFromV())){
                    return true;
                }
            }
            if(edge.getFromV().equals(vertex)){
                if(!visited.contains(edge.getToV())){
                    return true;
                }
            }
        }
        return false;
    }
    private UUID findUnlistedVertex(UUID vertex, List<UUID> visited, List<Edge> inSubgraph){ // нахождение смежной вершины
        for(Edge edge : inSubgraph){
            if(edge.getToV().equals(vertex)){
                if(!visited.contains(edge.getFromV())){
                    return edge.getFromV();
                }
            }
            if(edge.getFromV().equals(vertex)){
                if(!visited.contains(edge.getToV())){
                    return edge.getToV();
                }
            }
        }
        return null;
    }
    // функция обхода в глубину
    private Stack<UUID> depthFirstSearch(UUID root, UUID vertex_to_find, List<Edge> inSubgraph){
        List<UUID> visited = new ArrayList<>(); // посещенные вершины при обходе в глубину
        Stack<UUID> stack = new Stack<>(); // стек для обхода в глубину
        stack.push(root);
        visited.add(root);
        while(!visited.contains(vertex_to_find)&&!stack.isEmpty()){
            UUID vertex = stack.peek();
            if(checkForUnlistedEdges(vertex, visited, inSubgraph)){
                UUID temp_vertex = findUnlistedVertex(vertex, visited, inSubgraph);
                stack.push(temp_vertex);
                visited.add(temp_vertex);
            }
            else {
                stack.pop();
            }
        }
        return stack;
    }

}
