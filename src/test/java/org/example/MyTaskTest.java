package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.oldmodel.directed.DirectedGraph;
import org.example.MyTask;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTaskTest {
    @Test
    static void TestOne() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph10.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(MyTask.execute(G, 3)).isEqualTo(true);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Let's GO");
        TestOne();
    }
}
