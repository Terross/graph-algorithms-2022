package org.example;

import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.plugin.plugintype.GraphCharacteristic;

public class BergeDeficite implements GraphCharacteristic {
    @Override
    public Integer execute(Graph graph) {
        return graph.getVertexCount()-2*(new MaximalMatching().execute(graph));
    }
}
