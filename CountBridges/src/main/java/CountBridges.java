import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.plugin.plugintype.GraphCharacteristic;
import java.util.*;

public class CountBridges implements GraphCharacteristic {
    public CountBridges() {
    }

    public Integer execute(Graph g) {

        ArrayList<Edge> bridges = new ArrayList<>();
        ArrayList<Edge> edgeList = new ArrayList<>(g.getEdges());

        for (var e : edgeList) {
            ArrayList<Edge> temp = new ArrayList<>(edgeList);

            temp.remove(e);
            Graph temp_graph = new Graph(g.getDirectType(), g.getVertices().size(), temp.size(), g.getVertices(), temp);
            int i_1 = graphComps(temp_graph).size();
            int i_2 = graphComps(g).size();

            if (i_1 > i_2) {
                bridges.add(e);
            }
        }

        return bridges.size();
    }

    private void DFS(Graph g, UUID id, HashMap<UUID, Boolean> visited) {
        ArrayList<UUID> adjList = new ArrayList<>();
        visited.put(id, true);
        for (Edge edge : g.getEdges()) {

            if (edge.getFromV().equals(id) && !(visited.containsKey(edge.getToV()))) {
                adjList.add(edge.getToV());
            }
            if (edge.getToV().equals(id) && !(visited.containsKey(edge.getFromV()))) {
                adjList.add(edge.getFromV());
            }
        }
        for (UUID i : adjList) {
            DFS(g, i, visited);
        }
    }

    private ArrayList<UUID> compFind(HashMap<UUID, Boolean> visited) {

        ArrayList<UUID> res = new ArrayList<>(visited.keySet());
        visited.clear();
        return res;
    }

    private ArrayList<ArrayList<UUID>> graphComps(Graph g) {
        ArrayList<ArrayList<UUID>> res = new ArrayList<>();

        ArrayList<UUID> vertList = new ArrayList<>(g.getVertices().keySet());

        HashMap<UUID, Boolean> visited = new HashMap<>();

        for (UUID uuid : vertList) {
            DFS(g, uuid, visited);
            res.add(compFind(visited));

        }
        for (var i : res) {
            Collections.sort(i);
        }
        var t = new HashSet<>(res);
        return new ArrayList<>(t);
    }

}
