package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.oldmodel.directed.DirectedGraph;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class PresenceOfACycleOfLengthKTests {
    @Test
    void TestOne() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph1.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 5)).isEqualTo(true);
    }

    @Test
    void TestTwo() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph2.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 13)).isEqualTo(false); //6
    }
    @Test
    void TestThree() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph3.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 4)).isEqualTo(false);
    }
    @Test
    void TestFour() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph4.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 12)).isEqualTo(true);
    }
    @Test
    void TestFive() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph5.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 7)).isEqualTo(false);
    }
    @Test
    void TestSix() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph6.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 3)).isEqualTo(false);
    }
    @Test
    void TestSeven() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph7.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 3)).isEqualTo(true);
    }
    @Test
    void TestEight() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph8.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 5)).isEqualTo(true);
    }
    @Test
    void TestNine() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph9.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 4)).isEqualTo(true);
    }
    @Test
    void TestTen() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph10.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 7)).isEqualTo(true);
    }
    @Test
    void TestEleven() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph11.txt"));
        DirectedGraph G = new DirectedGraph(testGraph);

        assertThat(PresenceOfACycleOfLengthK.execute(G, 9)).isEqualTo(true);
    }
}
