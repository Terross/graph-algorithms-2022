package org.example;
import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import java.util.UUID;

public class CommonNeighbour implements GraphProperty {

    @Override
    public boolean execute(Graph abstractGraph)
    {

        int vertexCount = abstractGraph.getVertexCount();

        // initializing id list
        UUID[] id_list = new UUID[vertexCount];
        int k = 0;

        for (Map.Entry<UUID, Vertex> entry: abstractGraph.getVertices().entrySet()) {

            id_list[k++] = entry.getKey();

        }

        // initializing graph matrix
        int[][] graphMatrix = new int[vertexCount][vertexCount];

        for (Edge edge: abstractGraph.getEdges()){

            int from = getIndex(edge.getFromV(), id_list, vertexCount);
            int to = getIndex(edge.getToV(), id_list, vertexCount);

            graphMatrix[from][to] += 1;
            graphMatrix[to][from] += 1;

        }

        // main
        boolean flag = (vertexCount > 1);

        if (flag) {

            for (int i = 0; i < vertexCount - 1; ++i){

                for (int j = i + 1; j < vertexCount; ++j){

                    flag = haveCommonNeighbour(graphMatrix, vertexCount, i, j);

                    if (!flag) {

                        i = vertexCount;
                        break;

                    }

                }

            }

        }

        return flag;

    }

    private boolean haveCommonNeighbour(int[][] graphMatrix, int vertexCount, int vert1, int vert2){

        int result = 0;

        for (int i = 0; i < vertexCount; ++i){

            result += graphMatrix[vert1][i] * graphMatrix[i][vert2];

        }

        return (result > 0);

    }

    private int getIndex(UUID id, UUID[] id_list, int length) {

        for (int i = 0; i < length; ++i) {

            if (id.equals(id_list[i])) {

                return i;

            }

        }

        return -1;

    }

}
