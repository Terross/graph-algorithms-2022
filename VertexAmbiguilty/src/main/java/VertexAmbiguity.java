import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class VertexAmbiguity implements GraphProperty {
    public VertexAmbiguity() {
    }

    public boolean execute(Graph g) {
        HashMap<Vertex, Boolean> visited = new HashMap<>();
        for (Vertex v : g.getVertices().values()) {
            visited.put(v, false);
        }
        HashMap<Vertex, Integer> up = new HashMap<>();
        HashMap<Vertex, Integer> tin = new HashMap<>();
        HashMap<Edge, UUID> e_ids = new HashMap<>();
        ArrayList<Vertex> cut = new ArrayList<>();
        ArrayList<ArrayList<UUID>> res = new ArrayList<>();
        int time = 0;
        for (Edge e : g.getEdges()) {
            e_ids.put(e, UUID.randomUUID());
        }
        for (Vertex v : g.getVertices().values()) {
            if (!visited.get(v)) {
                DFS(g, v, v, time, up, tin, visited, cut);
            }
        }
        for (Vertex v : g.getVertices().values()) {
            visited.put(v, false);
        }
        for (var v : g.getVertices().values()) {
            if (!visited.get(v)){
                get_array_with_marks(g, v, v, up, tin, visited, res, e_ids);
            }
        }

        for (var i : res) {
            Collections.sort(i);
        }
        var t = new HashSet<ArrayList<UUID>>(res);

        var result = new ArrayList<ArrayList<UUID>>(t);

        HashMap<UUID, String> labels = new HashMap<UUID, String>();

        for (var e : g.getEdges()){
            labels.put(e_ids.get(e), e.getLabel());
        }
        ArrayList<String> unique_labels = new ArrayList<String>();
        for ( var p : labels.values()){
            if (!unique_labels.contains(p)){
                unique_labels.add(p);
            }
        }

        ArrayList<ArrayList<UUID>> res_1 = new ArrayList<ArrayList<UUID>>();
        int k = 0;

        for(var i : unique_labels) {
            res_1.add(new ArrayList<UUID>());
            for (var key : labels.keySet()) {
                if (labels.get(key).equals(i)) {
                    res_1.get(k).add(key);
                }
            }
            k+=1;

        }

        for (var i : res_1) {
            Collections.sort(i);
        }
        var z = new HashSet<ArrayList<UUID>>(res_1);

        var result_1 = new ArrayList<ArrayList<UUID>>(z);


        return result.equals(result_1);


    }

    private void DFS(Graph g, Vertex v, Vertex p, int time, HashMap<Vertex, Integer> up, HashMap<Vertex, Integer> tin, HashMap<Vertex, Boolean> visited, ArrayList<Vertex> cut) {
        time += 1;
        up.put(v, time);
        tin.put(v, time);
        visited.put(v, true);
        int count = 0;
        for (var e : edges_connected_to_vertex(g, v)) {
            var u_ = (e.getFromV().equals(v.getId())) ? e.getToV() : e.getFromV();
            var u = g.getVertices().get(u_);
            if (u.equals(p)) {
                continue;
            }
            if (visited.get(u)) {
                up.put(v, Math.min(up.get(v), tin.get(u)));
            } else {
                DFS(g, u, v, time, up, tin, visited, cut);
                up.put(v, Math.min(up.get(v), up.get(u)));
                if (up.get(u) >= tin.get(v) && !p.equals(v)) {
                    cut.add(v);
                }
                count += 1;
            }
        }
        if (p.equals(v) && count > 1) {
            cut.add(v);
        }
    }

    private void get_array_with_marks(Graph g, Vertex v, Vertex p, HashMap<Vertex, Integer> up, HashMap<Vertex, Integer> tin, HashMap<Vertex, Boolean> visited, ArrayList<ArrayList<UUID>> res, HashMap<Edge, UUID> e_ids) {
        visited.put(v, true);
        var cur_size = res.size();
        var v_edges = edges_connected_to_vertex(g, v);
        for (Edge e : v_edges) {
            var u_ = (e.getFromV().equals(v.getId())) ? e.getToV() : e.getFromV();
            var u = g.getVertices().get(u_);
            if (u.equals(p)) {
                continue;
            }
            if (!visited.get(u)) {
                if (up.get(u) >= tin.get(v)) {
                    var new_arr = new ArrayList<UUID>();
                    new_arr.add(e_ids.get(e));
                    res.add(new_arr);
                    get_array_with_marks(g, u, v, up, tin, visited, res, e_ids);
                } else {
                    get_array_with_marks(g, u, v, up, tin, visited, res, e_ids);
                    res.get(cur_size - 1).add(e_ids.get(e));
                }
            } else if (tin.get(u) < tin.get(v)) {
                res.get(cur_size - 1).add(e_ids.get(e));
            }
        }
    }

    private Vertex get_vertex_by_id(Graph g, UUID id) {
        for (var v : g.getVertices().values()) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    private void get_labels(Graph g, UUID id, HashMap<UUID, Boolean> visited, HashMap<UUID, String> labels) {
        ArrayList<UUID> adjList = new ArrayList<>();
        visited.put(id, true);
        labels.put(id, g.getVertices().get(id).getLabel());
        for (Edge edge : g.getEdges()) {

            if (edge.getFromV().equals(id) && !(visited.containsKey(edge.getToV()))) {
                adjList.add(edge.getToV());
            }
            if (edge.getToV().equals(id) && !(visited.containsKey(edge.getFromV()))) {
                adjList.add(edge.getFromV());
            }
        }
        for (UUID i : adjList) {
            get_labels(g, i, visited, labels);
        }
    }

    private ArrayList<Edge> edges_connected_to_vertex(Graph g, Vertex v) {
        UUID id = v.getId();
        ArrayList<Edge> edges = new ArrayList<>();
        for (Edge edge : g.getEdges()) {
            if (edge.getFromV().equals(id) || edge.getToV().equals(id)) {
                edges.add(edge);
            }
        }
        return edges;
    }

}
