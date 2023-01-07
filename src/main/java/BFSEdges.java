import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import javax.lang.model.type.NullType;
import java.util.*;

public class BFSEdges implements GraphProperty {
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
        Map<UUID, List<UUID>>  incidence = adjacencyToIncidence(adjacencyMatrix,
                graph.getVertexCount());

        // true если входной граф размечен по BFS,
        // иначе false
        return BFS(graph, start_v, l, incidence);
    }

    // берет ребра между вершинами v w в графе g
    private Edge getEdge(UUID v, UUID w, Graph g) {
        for (Edge e : g.getEdges()){
            if ((e.getFromV().equals(v) && e.getToV().equals(w)) ||
                    (e.getToV().equals(v) && e.getFromV().equals(w))) {
                return e;
            }
        }
        return new Edge();
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
    Map<UUID, List<UUID>> adjacencyToIncidence(Map<UUID, Map<UUID, Boolean>> adj, int n)
    {
        int edge = 0;
        Map<UUID, List<UUID>>  incidence = new HashMap<>();
        List<UUID> ui = new ArrayList<UUID>(adj.keySet());
        for (UUID id : ui) {
            List list = new ArrayList();
            incidence.put(id, list);
        }
        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < n; j += 1) {
                if (adj.get(ui.get(i)).get(ui.get(j))) {
                    incidence.get(ui.get(i)).add(ui.get(j));
                }
            }
        }
        return incidence;
    }

    // s - start - начальная вершина
    private boolean BFS( Graph graph, UUID s, Map<UUID, Boolean> l,
                         Map<UUID, List<UUID>> incident) {
        if (s == null) return false;
        HashSet<Integer> ourLabels = new <Integer>HashSet();
        HashSet<Integer> labels = new <Integer>HashSet();
        boolean isEmp = true; // для проверки, что пользователь назначил графу метки
        // инициализируем очередь
        Queue queue = new LinkedList();

        // добавляем стартовую вершину в очередь
        queue.offer(s);
        // помечаем s как посещенную вершину, добавляя в список
        // просмотренных вершин
        l.put(s, true);

        // для указания порядка при обходе
        int k = 0;
        int m = 0;
        int n = 1;

        // кратчайшие расстояния (номера уровней)
        Map<UUID, Integer> dist = new HashMap<>();
        dist = bfsShortest(s, incident);

        // пока в очереди есть элементы
        while(!queue.isEmpty()) {

            // берем и удаляем первый элемент очереди
            var v = queue.remove();
            // для соседних вершин v
            for (UUID neighbour : incident.get(v)) {
                // если сосед не посещался
                if (!l.get(neighbour)) {
                    // Добавим в множество ребер
                    // если ребро помечено в ином порядке, то
                    // входная разметка графа неверная (не соотв. BFS)
                    Edge e = getEdge(neighbour, UUID.fromString(v.toString()), graph);
                    if (e != null) {
                        String eLabel = e.getLabel();
                        if (eLabel != null && !(eLabel.isEmpty()) && !(eLabel.equals("null"))) {
                            labels.add(Integer.parseInt(eLabel));
                            //увеличиваем счетчик и помещаем в множество
                            //наших меток
                            k += 1;
                            ourLabels.add(k);

                            // добавляем его в очередь
                            queue.add(neighbour);
                        }
                        m += 1; // кол-во элем уровня
                        // помечаем вершину как посещенную
                        l.put(neighbour, true);
                    }
                }
            }
            if (!labels.isEmpty()) isEmp = false;
            if (m == countLevel(dist, n) && !labels.isEmpty()
                    && !ourLabels.isEmpty()) {//если закончили обход уровня
                if (!ourLabels.equals(labels)) return false;
                ourLabels.clear();
                labels.clear();
                m = 0;
                n += 1;
            }
        }
        // если не было неверно размеченных ребер,
        // то граф был верно размечен в порядке BFS
        // при этом он был как-то размечен пользователем (метки не пустые)
        if (isEmp) return false;
        return true;
    }

    // считает колво элементов с такими полями values в c
    Integer countLevel(Map<UUID, Integer> c, Integer n) {
        Integer count = 0;
        for (UUID key : c.keySet()) {
            if (c.get(key) == n) {
                count += 1;
            }
        }
        return count;
    }

    // по айди вершины кратчайший путь до
    // нее в ребрах (номер слоя)
    Map<UUID, Integer> bfsShortest(UUID s, Map<UUID, List<UUID>> inc) {
//        Map<UUID, Boolean> l = new HashMap<>();
        // длина любого кратчайшего пути не превосходит n - 1,
        // поэтому n - достаточное значение для "бесконечности";
        // после работы алгоритма dist[v] = n, если v недостижима из s
        Map<UUID, Integer> dist = new HashMap<>();

        List<UUID> ui = new ArrayList<UUID>(inc.keySet());
        for (UUID id : ui) {
            List list = new ArrayList();
            dist.put(id, inc.size());
        }

        dist.put(s,0);

        // инициализируем очередь
        Queue queue = new LinkedList();

        // добавляем стартовую вершину в очередь
        queue.offer(s);

        while (!queue.isEmpty()) {
            var v = queue.remove();
            for (UUID u : inc.get(v)) {
                if (dist.get(u) > dist.get(v) + 1) {
                    dist.put(u, dist.get(v) + 1);
                    queue.add(u);
                }
            }
        }
        return dist;
    }
}