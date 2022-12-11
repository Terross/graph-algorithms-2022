package org.example;
import com.mathsystem.api.graph.oldmodel.AbstractGraph;
import com.mathsystem.api.graph.oldmodel.Vertex;
import com.mathsystem.api.graph.oldmodel.directed.DirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class PresenceOfACycleOfLengthK extends AbstractGraph {

    private static class Vertexes {
        Vertex ver;
        List<Vertex> way = new ArrayList<>();

        public Vertexes(Vertex ver, Vertex way) {
            this.ver = ver;
            this.way.add(way);
        }
        public Vertexes(Vertex ver, List<Vertex> way, Vertex new_way){
            this.ver = ver;
            this.way.addAll(way);
            this.way.add(new_way);
        }
    }

    public static boolean execute(DirectedGraph Graph, int CycleLength) {
        Vertex W;
        Vertexes U;
        List<Vertex> Used = new ArrayList<>();
        List<Vertexes> QueueV = new ArrayList<>();

        if (CycleLength <= Graph.getVertexCount() && CycleLength != 0 && CycleLength != 1) {
            for (int CurrentV = 0; CurrentV < Graph.getVertices().size(); CurrentV++) {
                for (int CurrentE = 0; CurrentE < Graph.getVertices().get(CurrentV).getEdgeList().size(); CurrentE++) {
                    W = Graph.getVertices().get(CurrentV).getEdgeList().get(CurrentE).other(Graph.getVertices().get(CurrentV));

                    Vertexes NewVer = new Vertexes(W, Graph.getVertices().get(CurrentV));
                    QueueV.add(NewVer);
                }
                for (int i = 0; i < CycleLength - 2; i++) {
                    int QueueLength = QueueV.size();
                    for (int j = 0; j < QueueLength; j++) {
                        U = QueueV.get(0);
                        QueueV.remove(0);
                        if (U != null) {
                            for (int CurrentE = 0; CurrentE < U.ver.getEdgeList().size(); CurrentE++) {
                                W = U.ver.getEdgeList().get(CurrentE).other(U.ver);
                                if (!Used.contains(W)) {
                                    if (!U.way.contains(W)) {
                                        Vertexes NewVer = new Vertexes(W, U.way, U.ver);
                                        QueueV.add(NewVer);
                                    }
                                }
                            }
                        }
                    }
                }
                while (!QueueV.isEmpty()) {
                    U = QueueV.get(0);
                    QueueV.remove(0);
                    for (int CurrentE = 0; CurrentE < U.ver.getEdgeList().size(); CurrentE++) {
                        if (U.ver.getEdgeList().get(CurrentE).other(U.ver) == Graph.getVertices().get(CurrentV)) {
                            return true;
                        }
                    }
                }
                Used.add(Graph.getVertices().get(CurrentV));
            }
        }
        return false;
    }
}

