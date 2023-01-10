package org.finding_smallest_element;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class MaximalElement implements GraphProperty {

    UUID[] v;

    int num_in_vertex_list(UUID n){
        int a = 0;
        for (int i=0; i < v.length; i++){
            if (v[i].equals(n))
                a = i;
        }
        return a;
    }
    
    int maximal (Map<UUID, Vertex> g, int Vertex_n, List<Edge> edges) {
        int out_count = new int[Vertex_n];
        v = new UUID[Vertex_n];
        int i = -1;
        for (Map.Entry<UUID, Vertex> f : g.entrySet()) {
            v[++i] = f.getKey();
        }
        for (i = 0; i < Vertex_n; i++)
            out_count[i] = 0;
        for (Edge temp : edges) {
            int from = num_in_vertex_list(tmp.getFromV());
            ++out[from];
        }
        int max = 0;
        for (i = 0; i < Vertex_n; i++) {
            if (out[i] > max) {
                max = out[i];
            }
        }
        delete out_count;
        return max;
    }
}
