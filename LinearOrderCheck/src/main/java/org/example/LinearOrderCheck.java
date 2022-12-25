package org.example;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.oldmodel.Vertex;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;
import com.mathsystem.api.graph.oldmodel.AbstractEdge;
import com.mathsystem.api.graph.oldmodel.directed.DirectedGraph;
import java.util.ArrayList;
import java.util.List;

public class LinearOrderCheck implements GraphProperty {
    //проверить связь всех вершин друг с другом
    public boolean Linearity(ArrayList<Vertex> vertices, int vertexCount, ArrayList<AbstractEdge> edges, int edgesCount){
        boolean b = true;
        ArrayList<com.mathsystem.api.graph.oldmodel.Vertex> usedV = new ArrayList<>();
        for (int k = 0; k < vertexCount && b; k++) {
            Vertex v;
            v = vertices.get(k);
            var edgesFromV = v.getEdgeList();
            for (AbstractEdge abstractEdge : edgesFromV) {
                var neigh = abstractEdge.other(v);
                usedV.add(neigh);
            }

            for (int i = 0; i < vertexCount; i++) {
                var w = vertices.get(i);
                if (i != k) {
                    if (!usedV.contains(w)) {
                        var edgesFromW = w.getEdgeList();
                        if (edgesFromW.size() != 0) {
                            var countNotToV = 0;
                            for (AbstractEdge abstractEdge : edgesFromW) {
                                if (abstractEdge.other(w) != v) {
                                    countNotToV++;
                                }
                            }
                            if (countNotToV == edgesFromW.size())
                                b = false;
                        } else {
                            var countToW = 0;
                            for (int j = 0; j < edgesCount; j++){
                                var start = edges.get(j).either();
                                if (edges.get(j).other(start) == w) {
                                    countToW++;
                                }
                            }
                            if (countToW != vertexCount)
                                b = false;
                        }
                    }
                }

            }
            usedV.clear();
        }
        return b;
    }
    //проверить выполняется ли свойство во множестве вершин aRb, bRc => aRc
    public boolean Transitivity(ArrayList<AbstractEdge> edges, int edgesCount){
        var b = true;
        for(int i = 0; i < edgesCount && b; i++) {
            var start1 = edges.get(i).either();
            var edgesFromS1 = start1.getEdgeList();
            var end1 = edges.get(i).other(start1);
            var edgesFromE1 = end1.getEdgeList();
            for(AbstractEdge abstractEdge : edgesFromE1) {
                var end2 = abstractEdge.other(end1);
                var countNotToE2 = 0;
                for (AbstractEdge abstractEdge0 : edgesFromS1) {
                    if (abstractEdge0.other(start1) != end2)
                        countNotToE2++;
                }
                if (countNotToE2 == edgesFromS1.size())
                    b = false;
            }
        }
        return b;
    }
    //проверить выполняется ли свойство во множестве вершин aRb => ! bRa
    public boolean Asymmetry(ArrayList<AbstractEdge> edges, int edgesCount){
        var b = true;
        for(int i = 0; i < edgesCount; i++) {
            var start1 = edges.get(i).either();
            var end1 = edges.get(i).other(start1);
            for(int j = i; j < edgesCount; j++) {
                var start2 = edges.get(j).either();
                var end2 = edges.get(j).other(start2);
                if (start1 == end2 && end1 == start2){
                    i = j = edgesCount;
                    b = false;
                }
            }
        }
        return b;
    }
    //проверить выполняются ли все указанные свойства для данного ориентированного графа
    public boolean execute(Graph graph) {
        DirectedGraph abstractGraph = new DirectedGraph(graph);
        List<Vertex> vertices = abstractGraph.getVertices();
        ArrayList<AbstractEdge> edges = new ArrayList<>();
        for (int i = 0; i < abstractGraph.getVertexCount(); i++) {
            Vertex vertex = vertices.get(i);
            edges.addAll(vertex.getEdgeList());
        }
        boolean result = false;
        var linear = Linearity((ArrayList<Vertex>) vertices, abstractGraph.getVertexCount(), edges, edges.size());
        if (linear){
            var transit = Transitivity(edges, edges.size());
            if (transit){
                var asym =  Asymmetry(edges, edges.size());
                if (asym){
                    result = true;
                }
            }
        }
        return result;
    }
}