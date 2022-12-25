package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.plugin.plugintype.GraphCharacteristic;

import java.util.*;

public class DeficiteByTatt implements GraphCharacteristic {
    @Override
    public Integer execute(Graph graph) {

        List<Edge> M = new ArrayList<>();

        Map<UUID, Vertex> map = graph.getVertices();

        List<Edge> array = graph.getEdges();
        for (Edge edge : array) {
            map.get(edge.getToV()).setWeight(0);
            map.get(edge.getFromV()).setWeight(0);}

        for (Edge edge : array) {
            map.get(edge.getToV()).setWeight(map.get(edge.getToV()).getWeight() + 1);
            map.get(edge.getToV()).setWeight(map.get(edge.getFromV()).getWeight() + 1);
        }


        boolean sorted = false;
        Edge temp;
        Set<List<Vertex>> set = new HashSet<>();
        Vertex[] arr = (Vertex[]) graph.getVertices().values().toArray();
        Arrays.sort(arr);
        int N = (int)Math.pow(2, arr.length);
        for (int i = 0; i < N; i++)
        {
            List<Vertex> subset = new ArrayList<>();

            // проверить каждый бит `i`
            for (int j = 0; j < arr.length; j++)
            {
                // если установлен j-й бит `i`, добавляем `S[j]` к подмножеству
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }

            // вставляем подмножество в множество
            set.add(subset);
        }
        int def = graph.getVertexCount();
        for (List<Vertex> list : set) {
            k=// количество компонент связности при удалении данного множества вершин
                    def = Math.max(def, k-list.size());
        }
        return def;
    }
}