package org.example;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.graph.repository.GraphType;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

public class GraphTranzit implements GraphProperty {
	private int vertexCount;
	private int edgeCount;

	private boolean[] used;

	public boolean execute(Graph graph) {
		// создание матрицы смежности
		GraphAdjMatrix graphMatrix = new GraphAdjMatrix(graph);
		// количество вершин
		vertexCount = graph.getVertexCount();
		// количество ребер
		edgeCount = graph.getEdgeCount();
		int res = 0;
		// циклы по всем вершинам
		for (int i=0; i <vertexCount; i++ )
			for(int j =0; j<vertexCount;j++)
				// проверяем третью вершину, только когда первые две не совпадают
				for (int k=0; k < vertexCount && i != j; k++ ) {
					// если среди третья рассматриваемая вершина совпадает со второй или первой, то мы ее пропускаем
					if (k == i || k == j) continue;
					// если есть ребро от первой вершины к третьей, и от третьей ко второй
					if ((graphMatrix.matrix[i][k] == 1) && (graphMatrix.matrix[k][j]==1)){
						// проверяем, есть ли ребро от первой вершины ко второй. Если нет, значит, 
						// граф уже не транзитивен, и дальнейшая проверка бессмысленна
						res = graphMatrix.matrix[i][j];
						if (res!=1) return false;

					}
				}

		// если алгоритм так и не нашел ребер, 
		// которые противоречили бы условию транзитивности, значит, граф транзитивный
		return true;




	}



	private void createAdjacencyMatrix(Graph graph, Map<UUID, Map<UUID, Integer>> adjacencyMatrix) {
		for (UUID vertex1 : graph.getVertices().keySet()) {
			Map<UUID, Integer> vertexes = new HashMap<>();

			for (UUID vertex2 : graph.getVertices().keySet()) {
				vertexes.put(vertex2, 0);
			}

			adjacencyMatrix.put(vertex1, vertexes);
		}

		for (Edge edge : graph.getEdges()) {
			UUID vertex1 = edge.getFromV();
			UUID vertex2 = edge.getToV();

			adjacencyMatrix.get(vertex1).put(vertex2, 1);
			if (graph.getDirectType() == GraphType.UNDIRECTED) {
				adjacencyMatrix.get(vertex2).put(vertex1, 1);
			}
		}
	}

	public static class GraphAdjMatrix {
		private final Integer[][] matrix;
		// класс матрицы смежности
		public GraphAdjMatrix(Graph graph) {
			int vertexCount = graph.getVertexCount();
			int edgeCount = graph.getEdgeCount();
			List<Edge> edges = graph.getEdges();
			Map<UUID, Vertex> vertexMap = graph.getVertices();
			List<UUID> vertexes = vertexMap.keySet().stream().toList();  // список вершин
			// матрица размером количество вершин на количество ребер
			matrix = new Integer[vertexCount][edgeCount];
			// изначально заполняем матрицу так, словно граф не имеет ребер вообще
			for (int row = 0; row < vertexCount; row++) {
				for (int col = 0; col < vertexCount; col++) {
					matrix[row][col] = -1;
				}
			}
			// заполняем связи
			for (int edgeIndex = 0; edgeIndex < edgeCount; ++edgeIndex) {
				// рассматриваемое ребро
				Edge e = edges.get(edgeIndex);
				// вершина, откуда исходит ребро
				UUID from = e.getFromV();
				// вершина, куда ребро ведет
				UUID to = e.getToV();
				// индексы вершин
				int fromIndex = vertexes.indexOf(from);
				int toIndex = vertexes.indexOf(to);
				// единица на пересечении полученных индексов
				matrix[fromIndex][toIndex] = 1;


			}
		}

	}


}