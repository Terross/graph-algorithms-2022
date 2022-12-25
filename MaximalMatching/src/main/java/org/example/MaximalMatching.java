package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.plugin.plugintype.GraphCharacteristic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MaximalMatching implements GraphCharacteristic {
    @Override
    public Integer execute(Graph graph) {

        List<Edge> M = new ArrayList<>();

        Map<UUID, com.mathsystem.api.graph.model.Vertex> map = graph.getVertices();

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
