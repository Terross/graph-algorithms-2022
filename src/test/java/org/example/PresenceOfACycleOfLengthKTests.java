package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.oldmodel.directed.DirectedGraph;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class PresenceOfACycleOfLengthKTests {
    @Test
    static void TestOne() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph1.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 6)).isEqualTo(true);
    }

    @Test
    static void TestTwo() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph2.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 6)).isEqualTo(false);
    }
    @Test
    static void TestThree() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph3.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 6)).isEqualTo(false);
    }
    @Test
    static void TestFour() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph4.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 12)).isEqualTo(true);
    }
    @Test
    static void TestFive() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph5.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 8)).isEqualTo(true);
    }
    @Test
    static void TestSix() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph6.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 7)).isEqualTo(false);
    }
    @Test
    static void TestSeven() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph7.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 3)).isEqualTo(true);
    }
    @Test
    static void TestEight() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph8.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 5)).isEqualTo(true);
    }
    @Test
    static void TestNine() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph9.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 4)).isEqualTo(true);
    }
    @Test
    static void TestTen() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph10.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 9)).isEqualTo(true);
    }
}
