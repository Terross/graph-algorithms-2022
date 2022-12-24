package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

public class CorrectEdgeColoring implements GraphProperty {
    @Override
    public boolean execute(Graph abstractGraph) {
        boolean isGraphColouredOk = true;
        if (abstractGraph.getEdgeCount() <= 1) {
            return true;
        }

        for (Edge edge1 : abstractGraph.getEdges()) {
            if (!isGraphColouredOk) {
                break;
            }

            for (Edge edge2 : abstractGraph.getEdges()) {
                if (isAdjacent(edge1, edge2)) {
                    boolean isEdgesColoredWrong = edge1.getColor().equals(edge2.getColor());
                    if (isEdgesColoredWrong) {
                        isGraphColouredOk = false;
                        break;
                    }
                }
            }
        }

        return isGraphColouredOk;
    }

    private boolean isAdjacent(Edge edge1, Edge edge2) {
        if (!(edge1.equals(edge2))) {
            return edge1.getToV().equals(edge2.getFromV()) ||
                    edge1.getFromV().equals(edge2.getFromV()) ||
                    edge1.getFromV().equals(edge2.getToV()) ||
                    edge1.getToV().equals(edge2.getToV());
        } else {
            return false;
        }
    }
}