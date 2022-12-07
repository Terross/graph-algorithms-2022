package org.example;

import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.api.graph.oldmodel.AbstractGraph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;
import java.util.*;

public class KFactor implements GraphProperty {
    @Override
    public boolean execute(Graph graph){
        Map<UUID, Vertex> vertices = graph.getVertices();
        List<Edge> edges=graph.getEdges();
        int k=0,k1,t=0;
        if (edges!=null) {
            for (UUID vertex : vertices.keySet()) {
                k1 = 0;
                for (Edge edge : edges) {
                    if (edge.getColor() != Color.gray) {
                        if (edge.getToV().equals(vertex) || edge.getFromV().equals(vertex)) k1 += 1;
                    }
                }
                if (k == 0 && t == 0) {
                    k = k1;
                    t = 1;
                } else if (k != k1) return false;

            }
        }
        return true;
    }

}