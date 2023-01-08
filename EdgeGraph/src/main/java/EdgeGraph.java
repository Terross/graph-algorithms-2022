import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;
import java.util.*;

public class EdgeGraph implements GraphProperty {
    public EdgeGraph() {
    }
    public boolean execute(Graph g) {
        Map<UUID, Vertex> g1_verts = new HashMap<UUID, Vertex>();
        Map<UUID, Vertex> g2_verts = new HashMap<UUID, Vertex>();

        List<Edge> g1_edges = new ArrayList<Edge>();
        List<Edge> g2_edges = new ArrayList<Edge>();

        for (var v : g.getVertices().keySet()){
            if (g.getVertices().get(v).getColor().equals(Color.blue)){
                g1_verts.put(v, g.getVertices().get(v));
            } else {
                g2_verts.put(v, g.getVertices().get(v));
            }
        }

        for (var v : g1_verts.keySet()){
            for (var e : g.getEdges()){
                if ((e.getToV().equals(v) || e.getFromV().equals(v)) && !(g1_edges.contains(e))){
                    g1_edges.add(e);
                }
            }
        }

        for (var v : g2_verts.keySet()){
            for (var e : g.getEdges()){
                if ((e.getToV().equals(v) || e.getFromV().equals(v)) && !(g2_edges.contains(e))){
                    g2_edges.add(e);
                }
            }
        }

        Graph g1 = new Graph(g.getDirectType(), g1_verts.size(), g1_edges.size(), g1_verts, g1_edges);
        Graph g2 = new Graph(g.getDirectType(), g2_verts.size(), g2_edges.size(), g2_verts, g2_edges);

        //Проверяем количество рёбер в g1 и количество вершин в g2 (должны совпадать)
        if (!Objects.equals(g1.getEdgeCount(), g2.getVertexCount())){
            return false;
        }

        var verticesDeg = new ArrayList<Integer>();
        var edgesDeg = new ArrayList<Integer>();

        //список степеней вершин
        for (var i : g2.getVertices().keySet()){
            verticesDeg.add(VertexDegree(g2.getVertices().get(i), g2));
        }

        //список "степеней" рёбер (сколько у каждого ребра смежных рёбер)
        for (var i : g1.getEdges()){
            int s = 0;
            s += VertexDegree(g1.getVertices().get(i.getFromV()), g1) + VertexDegree(g1.getVertices().get(i.getToV()), g1) - 2;
            edgesDeg.add(s);
        }

        Collections.sort(verticesDeg);
        Collections.sort(edgesDeg);

        //сравниваем эти списки (должны совпадать)
        return verticesDeg.equals(edgesDeg);
    }
    public Integer VertexDegree(Vertex v, Graph g){
        int i = 0;
        for(var e: g.getEdges()){
            if(e.getFromV().equals(v.getId()) || e.getToV().equals(v.getId())){
                i++;
            }
        }
        return i;
    }
}
