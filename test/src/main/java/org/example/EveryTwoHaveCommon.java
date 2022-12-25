package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class EveryTwoHaveCommon implements GraphProperty
{
    @Override
    public boolean execute(Graph abstractGraph)
    {

        Map<UUID, Set<UUID>> distanceMatrix = new HashMap<>();
        createAdjentic(abstractGraph, distanceMatrix);
        return answer(abstractGraph, distanceMatrix);
    }

    private void createAdjentic(Graph graph, Map<UUID, Set<UUID>> distanceMatrix)
    {

        for (UUID vertex : graph.getVertices().keySet())
        {
            Set<UUID> array = new HashSet<>();
            distanceMatrix.put(vertex, array);
        }
        for (Edge edge : graph.getEdges())
        {
            UUID vertex1 = edge.getFromV();
            UUID vertex2 = edge.getToV();
            distanceMatrix.get(vertex1).add(vertex2);
            if (graph.getDirectType() == GraphType.UNDIRECTED)
            {
                distanceMatrix.get(vertex2).add(vertex1);
            }
        }
    }

    private boolean intersection(UUID vertex1, UUID vertex2, Map<UUID, Set<UUID>> distanceMatrix)
    {
        Set<UUID> verticesIntersection = new HashSet<>(distanceMatrix.get(vertex1));
        verticesIntersection.retainAll(distanceMatrix.get(vertex2));
        return !verticesIntersection.isEmpty();
    }

    private boolean answer(Graph graph, Map<UUID, Set<UUID>> distanceMatrix)
    {
        for (UUID vertex1 : graph.getVertices().keySet())
        {
            for (UUID vertex2 : graph.getVertices().keySet())
            {
                if (!distanceMatrix.get(vertex1).contains(vertex2))
                {
                    boolean anchoys = intersection(vertex1, vertex2, distanceMatrix);
                    if (!anchoys)
                    {
                        return false;
                    }
                }


            }
        }
        return true;
    }
}