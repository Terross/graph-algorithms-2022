package org.example;
import com.mathsystem.api.graph.oldmodel.AbstractGraph;
import com.mathsystem.api.graph.oldmodel.directed.DirectedGraph;
import com.mathsystem.api.graph.oldmodel.AbstractEdge;
import com.mathsystem.api.graph.oldmodel.Vertex;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class TopologicalSort extends AbstractGraph {
    public void topologicalSortUtil(int v, boolean visited[],
                                    Stack stack)
    {
        //  Помечаем текущий узел как посещенный
        visited[v] = true;
        Integer i;

        // Рекурсивно вызываем функцию для всех смежных вершин
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Добавляем текущую вершину в стек с результатом
        stack.push(v);
    }
    public LinkedList[] adj;
    public void execute(DirectedGraph Graph) {
        adj = new LinkedList[Graph.getVertexCount()];
        for (int i=0; i<Graph.getVertexCount(); ++i)
            adj[i] = new LinkedList();

        List<Vertex> vertices = Graph.getVertices();
        List<AbstractEdge> answer = new ArrayList<>();
        for (int i = 0; i < Graph.getVertexCount(); i++) {
            Vertex vertexProjection = vertices.get(i);
            for (AbstractEdge abstractEdge: vertexProjection.getEdgeList()) {
                answer.add(abstractEdge);
            }
        }
        for (int i = 0; i < answer.size(); i++) {
            String v_1 = answer.get(i).getV().getLabel();
            String w_1 = answer.get(i).getW().getLabel();
            Integer v = Integer.valueOf(v_1);
            Integer w = Integer.valueOf(w_1);
            adj[v].add(w);
        }
        System.out.println("Following is a Topological " +
                "sort of the given graph:");
        Stack stack = new Stack();
        // Помечаем все вершины как непосещенные
        boolean visited[] = new boolean[Graph.getVertexCount()];
        for (int i = 0; i < Graph.getVertexCount(); i++)
            visited[i] = false;

        // Вызываем рекурсивную вспомогательную функцию
        // для поиска топологической сортировки для каждой вершины
        for (int i = 0; i < Graph.getVertexCount(); i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Выводим содержимое стека
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }
}