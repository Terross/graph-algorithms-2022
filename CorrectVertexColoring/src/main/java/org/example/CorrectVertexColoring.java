package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;
public class CorrectVertexColoring implements GraphProperty {
    @Override
    public boolean execute(Graph abstractGraph) {
        Map<UUID, Vertex> coloredVertex = abstractGraph.getVertices();
        boolean isCorrectlyColoredGraph = true;
        boolean colorsOfTwoVerticesAreTheSame;

        if (abstractGraph.getVertexCount() <= 1) {
            return true;
        }

        for (Edge edge : abstractGraph.getEdges()) {
            colorsOfTwoVerticesAreTheSame = coloredVertex.get(edge.getFromV()).getColor()
                    .equals(coloredVertex.get(edge.getToV()).getColor());
            if(colorsOfTwoVerticesAreTheSame){
                isCorrectlyColoredGraph = false;
                break;
            }
        }

        return isCorrectlyColoredGraph;
    }
}