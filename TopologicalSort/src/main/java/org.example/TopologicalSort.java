import com.mathsystem.api.graph.oldmodel.AbstractEdge;
import com.mathsystem.api.graph.oldmodel.AbstractGraph;
import com.mathsystem.api.graph.oldmodel.Vertex;
import com.mathsystem.api.graph.oldmodel.directed.DirectedGraph;
import java.util.*;
import static java.lang.Math.abs;
public class TopologicalSort extends AbstractGraph {
    public boolean execute(DirectedGraph Graph) {
        int n_1 = 0;
        int n_2 = 0;
        int b = 0;
        int v, w, max_abs = 0;
        int vertex_count = Graph.getVertexCount();
        boolean cycle;
        List<Vertex> vertices = Graph.getVertices();
        List<AbstractEdge> answer = new ArrayList<>();
        int[] vertex_array = new int[vertex_count];
        int max_v = 0;
        if(vertex_count == 0 || vertex_count == 1)return true;
        for (int i = 0; i < Graph.getVertexCount(); i++) {
            Vertex vertexProjection = vertices.get(i);
            for (AbstractEdge abstractEdge: vertexProjection.getEdgeList()) {
                answer.add(abstractEdge);
            }
        }
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).getV().getWeight() != null) v = answer.get(i).getV().getWeight();
            else return false;
            if (answer.get(i).getW().getWeight() != null) w = answer.get(i).getW().getWeight();
            else return false;
            if((abs(v)>max_abs) && v < 0)max_abs = abs(v);
            if((abs(w)>max_abs) && w < 0)max_abs = abs(w);
        }
        for (int i = 0; i < answer.size(); i++) {

            v = answer.get(i).getV().getWeight() + max_abs;
            w = answer.get(i).getW().getWeight() + max_abs;
            if(max_v < v)max_v = v;
            if(max_v < w)max_v = w;
            for(int j = 0; j < b; j++)
            {
                if(vertex_array[j] == v)n_1+= 1;
                if(vertex_array[j] == w)n_2+= 1;
            }
            if(n_1 == 0)
            {
                vertex_array[b] = v;
                b += 1;
            }
            if(n_2 == 0)
            {
                vertex_array[b] = w;
                b += 1;
            }
            n_1 = 0;
            n_2 = 0;
        }
        for(int i = 0; i < vertex_array.length; i++)
        {
            for(int j = 0; j < vertex_array.length; j++)
            {
                if(vertex_array[i] == vertex_array[j])n_1 += 1;
            }
            if(n_1 > 1)return false;
        }
        adj = new LinkedList[max_v+1];
        for (int i=0; i<max_v+1; ++i)
            adj[i] = new LinkedList();
        for (int i = 0; i < answer.size(); i++) {
            v = answer.get(i).getV().getWeight() + max_abs;
            w = answer.get(i).getW().getWeight() + max_abs;
            adj[v].add(w);
        }
        Stack stack = new Stack();
        // Помечаем все вершины как непосещенные
        boolean visited[] = new boolean[max_v+1];
        for (int i = 0; i < max_v+1; i++)
            visited[i] = false;
        cycle = isCyclic(max_v, vertex_array);
        // Вызываем рекурсивную вспомогательную функцию
        // для поиска топологической сортировки для каждой вершины
        if(cycle == false)
        {
            for (int i = max_v; i >=0; i--) {
                for (int j = 0; j < vertex_array.length; j++) {
                    if (vertex_array[j] == i) n_1 += 1;
                }
                if (visited[i] == false && n_1 > 0)
                    topologicalSortUtil(i, visited, stack);
                n_1 = 0;
            }
            // Выводим содержимое стека
            Iterator<Integer> itr = stack.iterator();
            // hasNext() возвращает true, если в stack больше элементов
            while (itr.hasNext())
            {
                vertex_array[n_1] = itr.next();
                n_1 += 1;
            }
            n_1 = 0;
            n_2 = vertex_array[0];
            for(int i = 0; i < vertex_array.length; i++)
            {
                if((i + 1) < vertex_array.length)
                {
                    if(n_2 <= vertex_array[i+1])
                    {
                        n_1 += 1;
                        n_2 = vertex_array[i+1];
                    }
                }
            }
            if(n_1 == 0)return true;
            else return false;
        }
        else return false;
    }
    private void topologicalSortUtil(int v, boolean visited[],
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
    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack)
    {
        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;
        if (visited[i])
            return false;
        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = adj[i];
        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack))
                return true;
        recStack[i] = false;
        return false;
    }
    private boolean isCyclic(int max_v, int[] vertex_array )
    {
        int n_1 = 0;
        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[max_v+1];
        boolean[] recStack = new boolean[max_v+1];
        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < max_v+1; i++) {
            for (int j = 0; j < vertex_array.length; j++) {
                if (vertex_array[j] == i) n_1 += 1;
            }
            if(n_1 > 0)
            {
                if (isCyclicUtil(i, visited, recStack))
                    return true;
            }
        }
        return false;
    }
    public LinkedList[] adj;
}