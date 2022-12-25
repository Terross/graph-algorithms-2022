package org.example;
import org.junit.jupiter.api.Test;
import com.mathsystem.api.graph.model.Graph;
import java.io.File;
import java.io.FileNotFoundException;
import com.mathsystem.api.graph.oldmodel.directed.DirectedGraph;
import com.mathsystem.api.graph.GraphFactory;
public class TopologicalSortTest {
    @Test
    public void Test1() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test_graph_1.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);
        TopologicalSort test = new TopologicalSort();
        test.execute(G);
        System.out.println("\n");
    }
    @Test
    public void Test2() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test_graph_2.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);
        TopologicalSort test = new TopologicalSort();
        test.execute(G);
    }
}
