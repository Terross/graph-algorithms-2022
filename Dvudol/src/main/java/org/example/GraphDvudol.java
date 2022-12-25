package dvudol;

import java.util.*;

import com.mathsystem.api.graph.model.Edge;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.model.Vertex;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

import javax.swing.*;

public class GraphDvudol implements GraphProperty {
	private int vertexCount;
	private boolean TF;

	private boolean used[];

	public boolean execute(Graph graph) {
		vertexCount = graph.getVertexCount();
		List<UUID> vertexes = graph.getVertices().keySet().stream().toList();// список вершин списком
		used = new boolean[vertexCount];
		boolean used1[];
		used1 = new boolean[vertexCount];
		int[] clrs = new int[vertexCount];
		int[] carl = new int[vertexCount];
		TF = true;
		int c = 1;
		int k = 0, p = 0;
		Arrays.fill(used, false);

		for (int i = 0;i<vertexCount;i++)
		{
			clrs[i]= 0;
			carl[i] = 0;
		}

		GraphAdjMatrix graphMatrix = new GraphAdjMatrix(graph);// граф заданный матрицой
		used[0] = true;
		check(graphMatrix);
		while(k == 0)
		{
			for (int i = 0;i<vertexCount;i++)
			{
				used1[i] = used[i];
			}
			check(graphMatrix);
			for (int i = 0;i<vertexCount;i++)
			{
				if(used1[i] == used[i])
				{
					p = p + 1;
				}
			}
			if (p == vertexCount)
			{
				k = 1;
			}
			p = 0;
		}

		for (int i = 0;i<vertexCount;i++)
		{
			if (used[i]== false)
			{
				TF = false;
			}
		}


		if (TF == true)
		{
			for (int i = 1;i <vertexCount;i++)
			{
				if (carl[i]== 0)
				{
					carl[i]= 1;
					coralli(i,graphMatrix,carl);

				}
			}
		}


		return TF;

	}
	public static class GraphAdjMatrix {
		private final Integer[][] matrix;
		private List<Integer> adjLists[];

		public GraphAdjMatrix(Graph graph) {
			int vertexCount = graph.getVertexCount();
			int edgeCount = graph.getEdgeCount();
			List<Edge> edges = graph.getEdges(); // список ребер
			Map<UUID, Vertex> vertexMap = graph.getVertices();// список вершин
			List<UUID> vertexes = vertexMap.keySet().stream().toList();// список вершин
			adjLists = new LinkedList[vertexCount];
			matrix = new Integer[vertexCount][vertexCount];
			for (int row = 0; row < vertexCount; row++) {
				for (int col = 0; col < vertexCount; col++) {
					matrix[row][col] = 0;
				}
			}
			for (int i = 0;i <vertexCount;i++)
			{
				adjLists[i] = new LinkedList<Integer>();
			}


			for (int edgeIndex = 0; edgeIndex < edgeCount; ++edgeIndex) {
				Edge e = edges.get(edgeIndex);
				UUID from = e.getFromV();
				UUID to = e.getToV();
				int fromIndex = vertexes.indexOf(from);
				int toIndex = vertexes.indexOf(to);

				add_edg(fromIndex,toIndex,adjLists);
				add_edg(toIndex,fromIndex,adjLists);

				matrix[fromIndex][toIndex] = 1;
				matrix[toIndex][fromIndex] = 1;

			}



		}
		public void add_edg(int a, int b, List<Integer> adjLists[])
		{
			adjLists[a].add(b);
		}



	}
	public void coralli(int u, GraphAdjMatrix graph, int[] carl)

	{
		for (int i = 0; i<graph.adjLists[u].size();i++)
		{
			int v = graph.adjLists[u].get(i);
			if (carl[v] == 0 )
			{
				carl[v] = 3 - carl[u];
				coralli(v,graph, carl);
			}
			else if (carl[u] == carl[v])
			{

				TF = false;
			}
		}
	}
	public void check(GraphAdjMatrix graphMatrix)
	{
		for (int i = 0;i<vertexCount;i++)
		{
			if (used[i] == true)
			{
				for (int j = 0;j<vertexCount;j++)
				{
					if (graphMatrix.matrix[i][j] == 1)
					{
						used[j] = true;
					}
				}
			}

		}


	}
}

