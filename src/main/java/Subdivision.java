import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.*;

public class Subdivision implements GraphProperty {
    @Override
    public boolean execute(Graph abstractGraph) {
        Map<UUID, ArrayList<Boolean>> markedVertexes = new HashMap<>();

        for (Vertex vertex : abstractGraph.getVertices().values()) {
            if (vertex.getColor() != Color.gray) {
                markedVertexes.put(vertex.getId(), new ArrayList<>(Arrays.asList(false, false)));
            }
        }

        if (markedVertexes.size() == 0) {
            return false;
        }

        List<Edge> coloredToUncoloredEdges = new ArrayList<>();
        for (Edge edge : abstractGraph.getEdges()) {
            UUID vertex1 = edge.getFromV();
            UUID vertex2 = edge.getToV();
            if (markedVertexes.containsKey(vertex2) && !markedVertexes.containsKey(vertex1)) {
                coloredToUncoloredEdges.add(edge);
            } else if (markedVertexes.containsKey(vertex1) && !markedVertexes.containsKey(vertex2)) {
                coloredToUncoloredEdges.add(edge);
            } else if (markedVertexes.containsKey(vertex1) && markedVertexes.containsKey(vertex2)) {
                return false;
            }
        }

        for (Edge edge : coloredToUncoloredEdges) {
            UUID vertex1 = edge.getFromV();
            UUID vertex2 = edge.getToV();
            if (markedVertexes.containsKey(vertex1)) {
                if (markedVertexes.get(vertex1).get(1)) {

                    return false;
                } else {
                    markedVertexes.get(vertex1).set(1, true);
                }

            } else {
                if (markedVertexes.get(vertex2).get(0)) {
                    return false;
                } else {
                    markedVertexes.get(vertex2).set(0, true);
                }
            }
        }
        for (ArrayList<Boolean> booleans : markedVertexes.values()) {
            if (!booleans.get(0) || !booleans.get(1)) {
                return false;
            }
        }

        return true;
    }
}