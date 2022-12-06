package test;

import ThePresenceOfaCycleOfKLength.MyTask;
import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.oldmodel.directed.DirectedGraph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTaskTest {
    @Test
    static void TestOne() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/main/java/test/graph3.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        System.out.println("Let's try");
        MyTask.execute(G);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Let's GO");
        TestOne();
    }
}
