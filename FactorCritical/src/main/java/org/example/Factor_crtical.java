package org.example;

import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;
import java.util.*;
public class Factor_crtical implements GraphProperty {
    @Override
    public boolean execute(Graph graph) {
        List<Edge> array1 = new ArrayList<>();
        Map<UUID, Vertex> map1= new HashMap<>();
        Map<UUID, Vertex> map2 = graph.getVertices();
        if (graph.getVertexCount()%2==0) return false;
        List<Edge> array2 = graph.getEdges();
        if (array2 == null) return false;
        for(UUID vertex: map2.keySet()){
            map1.putAll(map2);
            map1.remove(vertex);
            for (Edge edge: array2){
                if (!(edge.getToV().equals(vertex) || edge.getFromV().equals(vertex))){
                    array1.add(new Edge(edge.getToV(),edge.getFromV(), edge.getColor(),edge.getWeight(), edge.getLabel()));
                }
            }
            Graph graph1= new Graph(graph.getDirectType(), map1.size(), array1.size(),map1,array1);
            if (2*MaxMatching(graph1) != map1.size()){
                return false;
            }
            map1.clear();
            array1.clear();
        }
        return true;
    }


    public Integer MaxMatching(Graph graph) {

        List<Edge> M = new ArrayList<>();

        Map<UUID, Vertex> map = graph.getVertices();

        List<Edge> array = graph.getEdges();

        for (Edge edge : array) {
            map.get(edge.getToV()).setWeight(0);
            map.get(edge.getFromV()).setWeight(0);}

        for (Edge edge : array) {
            map.get(edge.getToV()).setWeight(map.get(edge.getToV()).getWeight() + 1);
            map.get(edge.getFromV()).setWeight(map.get(edge.getFromV()).getWeight() + 1);
        }


        boolean sorted = false;
        Edge temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.size()-1; i++) {
                int sumVWi = map.get(array.get(i).getToV()).getWeight() + map.get(array.get(i).getFromV()).getWeight();
                int sumVWi1 = map.get(array.get(i + 1).getToV()).getWeight() + map.get(array.get(i + 1).getFromV()).getWeight();
                if (sumVWi > sumVWi1) {
                    temp = array.get(i);
                    array.set(i, array.get(i + 1));
                    array.set(i + 1, temp);
                    sorted = false;
                }
            }
        }


        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getColor() != Color.red) {
                M.add(array.get(i));
                array.get(i).setColor(Color.blue);
                for (Edge edge : array) {
                    if (edge == array.get(i)) continue;
                    if ((map.get(edge.getToV()) == (map.get(array.get(i).getToV()))
                            || map.get(edge.getToV()) == (map.get(array.get(i).getFromV()))
                            || map.get(edge.getFromV()) == (map.get(array.get(i).getToV()))
                            || map.get(edge.getFromV()) == (map.get(array.get(i).getFromV())))) {
                        edge.setColor(Color.red);
                    }
                }
            }
        }
        return M.toArray().length;
    }
}
