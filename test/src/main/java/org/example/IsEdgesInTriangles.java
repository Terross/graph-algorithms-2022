package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class IsEdgesInTriangles implements GraphProperty
{
    @Override
    public boolean execute(Graph abstractGraph)
    {
        if (abstractGraph.getEdgeCount() < 3)
            return false;

        boolean isEdgesInTriangle;
        List <Edge> edgesInTriangle = new ArrayList<>();

        for (Edge edge1: abstractGraph.getEdges())
            for (Edge edge2:  abstractGraph.getEdges())
                for (Edge edge3:  abstractGraph.getEdges())
                {
                    if (abstractGraph.getDirectType() == GraphType.DIRECTED)
                        isEdgesInTriangle = IsTriangle(edge1, edge2, edge3);
                    else
                        isEdgesInTriangle = IsTriangle2(edge1, edge2, edge3);

                    if (isEdgesInTriangle)
                    {
                        List<Edge> edges = new ArrayList<>();
                        edges.add(edge1);
                        edges.add(edge2);
                        edges.add(edge3);

                        for (Edge edge4: edges)
                        {
                            if (!edgesInTriangle.contains(edge4))
                                edgesInTriangle.add(edge4);
                        }
                    }
                }

        return abstractGraph.getEdgeCount() == edgesInTriangle.size();
    }

    private boolean IsTriangle(Edge edge1, Edge edge2, Edge edge3)
    {
        return edge1.getToV().equals(edge2.getFromV()) && edge2.getToV().equals(edge3.getFromV())
                && edge3.getToV().equals(edge1.getFromV());
    }

    private boolean IsTriangle2(Edge edge1, Edge edge2, Edge edge3)
    {
        if (edge1 != edge2 && edge2 != edge3 && edge1 != edge3)
        {
            return CompareTwoEdges(edge1,edge2) && CompareTwoEdges(edge2, edge3) && CompareTwoEdges(edge1, edge3);
        }

        return false;
    }

    private boolean CompareTwoEdges(Edge edge1, Edge edge2)
    {
        return (edge1.getFromV().equals(edge2.getFromV())) || (edge1.getFromV().equals(edge2.getToV()))
                || (edge1.getToV().equals(edge2.getFromV())) || (edge1.getToV().equals(edge2.getToV()));
    }
}