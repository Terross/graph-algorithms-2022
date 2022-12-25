import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.oldmodel.AbstractEdge;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class BFSVertices implements GraphProperty {
    @Override
    public boolean execute(Graph graph) {
        // читаем граф: получаем матрицу смежности
        Map<UUID, Map<UUID, Boolean>> adjacencyMatrix = new HashMap<>();

        // l - множество просмотренных вершин
        Map<UUID, Boolean> l = new HashMap<>();

        for (UUID vertex : graph.getVertices().keySet()) {
            l.put(vertex, false);
        }
        createMatrix(graph, adjacencyMatrix);


        // получить начальную вершину (зеленую)
        UUID start_v = null;

        for (UUID vertex : graph.getVertices().keySet()) {
            if (graph.getVertices().get(vertex).getColor() == Color.green){
                start_v = vertex;
            }
        }

        // по матрице смежности сделать списки инцидентности
        Map<UUID, Map<UUID, Boolean>> incidence = adjacencyToIncidence(adjacencyMatrix,
                graph.getVertexCount());

        // true если входной граф размечен по BFS,
        // иначе false
        return BFS(graph, start_v, l, incidence);
    }

    private void createMatrix(Graph graph, Map<UUID, Map<UUID, Boolean>> adjacencyMatrix) {
        for (UUID vertex1 : graph.getVertices().keySet()) {
            Map<UUID, Boolean> vertexes = new HashMap<>();

            for (UUID vertex2 : graph.getVertices().keySet()) {
                vertexes.put(vertex2, false);
            }

            adjacencyMatrix.put(vertex1, vertexes);
        }

        for (Edge edge : graph.getEdges()) {
            UUID vertex1 = edge.getFromV();
            UUID vertex2 = edge.getToV();

                adjacencyMatrix.get(vertex1).put(vertex2, true);
                if (graph.getDirectType() == GraphType.UNDIRECTED) {
                    adjacencyMatrix.get(vertex2).put(vertex1, true);
                }
        }
    }

    // для каждого ребра добавляем в список те вершины,
    // с которыми у него на пересечении в матрице смежности true
    Map<UUID, Map<UUID, Boolean>> adjacencyToIncidence(Map<UUID, Map<UUID, Boolean>> adj, int n)
    {
        int edge = 0;
        Map<UUID, Map<UUID, Boolean>> incidence = null;
        UUID[] l = new UUID[n];
        l = (UUID[]) adj.keySet().toArray();
        for (int col = 0; col < n; col += 1) {
            // Смотрим на половину матрицы смежности, чтобы
            // добавлять вершину один раз
            for (int row = 0; row <= col; row += 1) {
                if (adj.get(l[col]).get(l[row])) {
                    incidence.get(l[edge]).put(l[row], true); // [edge][row]
                    ++edge;
                }
            }
        }
        return incidence;
    }

    // s - start - начальное ребро
    private boolean BFS( Graph graph, UUID s, Map<UUID, Boolean> l,
                         Map<UUID, Map<UUID, Boolean>> incedent) {

        // инициализируем очередь
        Queue queue = new LinkedList();

        // добавляем стартовую вершину в очередь
        queue.offer(s);
        // помечаем s как посещенную вершину, добавляя в список
        // просмотренных вершин
        l.put(s, false);

        // для указания порядка при обходе
        int k = 1;
        // пока в очереди есть элементы
        while(!queue.isEmpty()) {
            // берем и удаляем первый элемент очереди
            var v = queue.remove();

            // для соседних вершин v
            for(Map.Entry<UUID, Boolean> neighbour : incedent.get(v).entrySet()) {
                // если сосед не посещался
                if(!l.get(neighbour.getKey())) {
                    // добавляем его в очередь
                    queue.add(neighbour);

                    // помечаем вершину как посещенную
                    l.put(neighbour.getKey(), true);

                    //увеличиваем счетчик
                    k += 1;

                    // если ребро помечено в ином порядке, то
                    // входная разметка графа неверная (не соотв. BFS)
                    if(Integer.parseInt(
                            graph.getVertices().get(neighbour).getLabel())
                            != k) return false;
                }
            }
        }
        // если не было неверно размеченных ребер,
        // то граф был верно размечен в порядке BFS
        return true;
    }
}
