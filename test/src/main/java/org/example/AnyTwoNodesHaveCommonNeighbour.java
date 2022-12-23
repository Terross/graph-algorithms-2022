package org.example;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.plugin.plugintype.GraphCharacteristic;

import java.util.*;


public class AnyTwoNodesHaveCommonNeighbour implements GraphCharacteristic {
    @Override
    public Integer execute(Graph abstractGraph) {

        if (abstractGraph.getVertexCount() < 3) //EdgeCount()
            return -1;

        int min_count = 65535, count = 0, red_count = 0, red_min_count = 0;

        List<Edge> UnVisitedEdges = new ArrayList<>(abstractGraph.getEdges());
        List<UUID> visitedVertexes = new ArrayList<>();

        for (Edge currentEdge = UnVisitedEdges.get(0); UnVisitedEdges.size() > 1; currentEdge = UnVisitedEdges.get(0))
        {
            UnVisitedEdges.remove(0);
            for (Edge checkEdge : UnVisitedEdges)
            {
                if(currentEdge.getFromV().equals(checkEdge.getToV()) && !currentEdge.getToV().equals(checkEdge.getFromV()))
                {
                    count++;
                    if (checkIsVertexIsRed(currentEdge.getToV(), abstractGraph) && checkIsVertexIsRed(checkEdge.getFromV(), abstractGraph)
                            && isVertexNotVisited(currentEdge.getFromV(),visitedVertexes))
                    {
                        red_count++;
                        visitedVertexes.add(currentEdge.getFromV());
                    }
                }
                else if(currentEdge.getToV().equals(checkEdge.getFromV()) && !currentEdge.getFromV().equals(checkEdge.getToV()))
                {
                    count++;
                    if (checkIsVertexIsRed(currentEdge.getFromV(), abstractGraph) && checkIsVertexIsRed(checkEdge.getToV(), abstractGraph)
                            && isVertexNotVisited(currentEdge.getToV(),visitedVertexes))
                    {
                        red_count++;
                        visitedVertexes.add(currentEdge.getToV());
                    }
                }
                else if (currentEdge.getFromV().equals(checkEdge.getFromV()) && !currentEdge.getToV().equals(checkEdge.getToV()))
                {
                    count++;
                    if (checkIsVertexIsRed(currentEdge.getToV(), abstractGraph) && checkIsVertexIsRed(checkEdge.getToV(), abstractGraph)
                            && isVertexNotVisited(currentEdge.getFromV(),visitedVertexes))
                    {
                        red_count++;
                        visitedVertexes.add(currentEdge.getFromV());
                    }
                }
                else if (currentEdge.getToV().equals(checkEdge.getToV()) && !currentEdge.getFromV().equals(checkEdge.getFromV()))
                {
                    count++;
                    if (checkIsVertexIsRed(currentEdge.getFromV(), abstractGraph) && checkIsVertexIsRed(checkEdge.getFromV(), abstractGraph)
                            && isVertexNotVisited(currentEdge.getToV(),visitedVertexes))
                    {
                        red_count++;
                        visitedVertexes.add(currentEdge.getToV());
                    }
                }
            }
            if (count < min_count) min_count = count;
            if (red_count < red_min_count) red_min_count = red_count;
        }


        if (min_count == 0) return -1;
        return red_count;
    }
    public boolean checkIsVertexIsRed(UUID IdVertex, Graph graph) {
        for (Map.Entry<UUID, Vertex> Vertex1 : graph.getVertices().entrySet())
            if (Vertex1.getKey().equals(IdVertex))
                if (Vertex1.getValue().getColor().equals(Color.red))
                    return true;
        return false;
    }

    public  boolean isVertexNotVisited(UUID IdVertex, List<UUID> visitedVertexes) {
        for (UUID check : visitedVertexes)
            if (IdVertex.equals(check))
                return false;
        return true;
    }
}