import java.util.*;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.api.graph.model.Graph;

import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.plugin.plugintype.GraphCharacteristic;


public class NumberOfConnectedComponents implements GraphCharacteristic
{
    private boolean[] marked;
    private int[] id;
    private int[] size;
    private int count;
    private List<List<Integer>> adj;

    @Override
    public Integer execute(final Graph graph) {
        this.marked = new boolean[(int)graph.getVertexCount()];
        this.id = new int[(int)graph.getVertexCount()];
        this.size = new int[(int)graph.getVertexCount()];
        this.count = 0;
        this.adj = new ArrayList<List<Integer>>();
        for (int i = 0; i < graph.getVertexCount(); ++i) {
            this.adj.add(new ArrayList<Integer>());
        }
        List<Vertex> vertices = new ArrayList<Vertex>();
        for (Map.Entry<UUID, Vertex> entry : graph.getVertices().entrySet()) {
            vertices.add(entry.getValue());
        }
        List<Edge> list_edge = graph.getEdges();

        List<Integer> index1 = new ArrayList<Integer>();
        for (Edge edge : list_edge) {
            UUID fromV = edge.getFromV();
            UUID toV = edge.getToV();
            if(graph.getVertices().get(fromV).getColor() != Color.gray | graph.getVertices().get(toV).getColor() != Color.gray)
            {
                index1.add(list_edge.indexOf(edge));
            }
        }
        Integer shift = 0;

        for(Integer i : index1){
            i = i - shift;

            Edge del_edge = list_edge.get(i);
            list_edge.remove(del_edge);
            shift++;
        }

        graph.setEdges(list_edge);

        List<Integer> index2 = new ArrayList<Integer>();
        for(Vertex vertex : vertices){
            if(vertex.getColor() != Color.gray){
                index2.add(vertices.indexOf(vertex));
            }
        }
        shift = 0;
        for(Integer i : index2){
            i = i - shift;
            Vertex del_vertex = vertices.get(i);
            vertices.remove(del_vertex);
           shift++;
        }
        graph.setVertexCount(vertices.size());

        for (Edge edge : graph.getEdges()) {

            UUID fromV = edge.getFromV();
            UUID toV = edge.getToV();
            int v = vertices.indexOf(graph.getVertices().get(fromV));
            int w = vertices.indexOf(graph.getVertices().get(toV));
            this.adj.get(v).add(w);
            this.adj.get(w).add(v);
        }
        for (int v2 = 0; v2 < graph.getVertexCount(); ++v2) {

            if (!this.marked[v2]) {
                this.dfs(graph, v2);
                ++this.count;
            }
        }
        return this.count;
    }

    private void dfs(final Graph G, final int v) {
        this.marked[v] = true;
        this.id[v] = this.count;
        int[] size = this.size;
        int count = this.count;
        ++size[count];
        for (int w : this.adj.get(v)) {
            if (!this.marked[w]) {
                this.dfs(G, w);
            }
        }
    }
}
