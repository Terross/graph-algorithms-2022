import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AntiTransitive implements GraphProperty {

	public boolean execute(Graph graph) {

		List<Edge> edges = graph.getEdges();
		Map<UUID, Vertex> vertexMap = graph.getVertices();
		List<UUID> vertices = vertexMap.keySet().stream().toList();
		int vertexCount = vertices.size();
		Integer [][] matrix = new Integer[vertexCount][vertexCount];

		for (int i = 0; i < vertexCount; ++ i) for (int j = 0; j < vertexCount; ++j) matrix[i][j] = 0;

		for (int edgeIndex = 0; edgeIndex < graph.getEdgeCount(); ++edgeIndex) {

			Edge edge = edges.get(edgeIndex);
			UUID from = edge.getFromV();
			UUID to = edge.getToV();

			int index_from = vertices.indexOf(from);
			int index_to = vertices.indexOf(to);

			matrix[index_from][index_to] = 1;

			if (graph.getDirectType() != GraphType.DIRECTED) matrix[index_to][index_from] = 1;
		}

		for (int i = 0; i < vertexCount; ++ i) {
			for (int j = 0; j < vertexCount; ++j) {
				if (matrix[i][j] == 1) {
					// i - vertex A
					for (int k = 0; k < vertexCount; ++k) {
						if (matrix[j][k] == 1 && j != k && k != i) {
							// j - vertex B
							for (int l = 0; l < vertexCount; ++l) {
								if (matrix[i][l] == 1 && l == k) {
									// k - vertex C
									return false;
								}
							}
						}
					}
				}
			}
		}

		return true;
	}
}