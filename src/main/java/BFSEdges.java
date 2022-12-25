import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.oldmodel.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.rmi.server.UID;
import java.util.*;

public class BFSEdges implements GraphProperty {
    @Override
    public boolean execute(Graph graph) {
        // матрица смежности adjacencyMatrix
        Map<UUID, Map<UUID, Boolean>> adjacencyMatrix = new HashMap<>();

        // l - множество просмотренных ребер
        Map<Edge, Boolean> l = new HashMap<>();

        // пометили все ребра как непросмотренные
        for (Edge edge : graph.getEdges()) {
            l.put(edge, false);
        }

        // читаем граф: получаем матрицу смежности
        createMatrix(graph, adjacencyMatrix);

        // получить начальное ребро (зеленое)
        Edge start_e = null;

        for (Edge edge : graph.getEdges()) {
            if (edge.getColor() == Color.green){
                start_e = edge;
            }
        }
        // по матрице смежности сделать списки инцидентности
        Map<UUID, Map<UUID, Boolean>> incidence = adjacencyToIncidence(adjacencyMatrix,
                graph.getVertexCount());

        // true если входной граф размечен по BFS,
        // иначе false
        return BFS(graph, start_e, l, incidence);
    }

    private void createMatrix(Graph graph, Map<UUID, Map<UUID, Boolean>> adjacencyMatrix) {
        for (UUID vertex1 : graph.getVertices().keySet()) {
                Map<UUID, Boolean> vertexes = new HashMap<>();

                for (UUID vertex2 : graph.getVertices().keySet()) {
                    if (graph.getVertices().get(vertex2).getColor() == Color.gray) {
                        vertexes.put(vertex2, false);
                    }
                }

                adjacencyMatrix.put(vertex1, vertexes);
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

    // для каждой вершины добавляем в список те вершины,
    // с которыми у него на пересечении в матрице смежности true
    Map<UUID, Map<UUID, Boolean>> adjacencyToIncidence(Map<UUID, Map<UUID, Boolean>> adj, int n)
    {
        int edge = 0;
        Map<UUID, Map<UUID, Boolean>> incidence = null;
        UUID[] l = new UUID[n];
        l = (UUID[]) adj.keySet().toArray();
        for (int col = 0; col < n; col += 1) {
            // смотрим на половину матрицы смежности, чтобы
            // добавлять вершину один раз (для ненаправленного графа)
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
    private boolean BFS( Graph graph, Edge s, Map<Edge, Boolean> l,
                         Map<UUID, Map<UUID, Boolean>> incedent) {

        // инициализируем очередь
        Queue queue = new LinkedList();

        // добавляем стартовое ребро в очередь
        queue.offer(s);

        // помечаем s как посещенное ребро, добавляя в список
        // просмотренных ребер
        l.put(s, false);
        //    Iterator var5 = graph.getEdges().keySet().iterator();
       // списки инциндентности для вершин текущего ребра
        // для указания порядка при обходе
        int k = 1;
        // пока в очереди есть элементы
        while(!queue.isEmpty()) {
            // берем в e и удаляем первый элемент очереди
            Edge e = (Edge) queue.remove();

            // берем ребро по левому концу текущего ребра
            for(Edge neighbour : graph.getEdges()) {//.get(incedent.get(e.getToV()).getEdges())

                // если ребро не посещалось
                if(!l.get(neighbour)) {
                    // добавляем его в очередь
                    queue.add(neighbour);

                    // помечаем ребро как посещенное
                    l.put(neighbour, true);

                    //увеличиваем счетчик
                    k += 1;

                    // если ребро помечено в ином порядке, то
                    // входная разметка графа неверная (не соотв. BFS)
                    if(Integer.parseInt(
                            graph.getVertices().get(neighbour.getToV()).getLabel())
                            != k) return false;
                }
            }
        }
        // если не было неверно размеченных ребер,
        // то граф был верно размечен в порядке BFS
        return true;
    }
}