package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphLeavesTest {
    /*
      empty graph
     */
    @Test
    void shouldCheckGraphLeavesOnEmptyUndirectedGraph() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph1Test.txt"));

        GraphLeaves graphLeaves = new GraphLeaves();
        assertThat(graphLeaves.execute(testGraph)).isEqualTo(0);
    }

    /*
        0 0 0 0
        0 0 0 0
        0 0 0 0
        0 0 0 0
     */
    @Test
    void shouldCheckGraphLeavesOnUndirectedGraphWithoutEdges() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph2Test.txt"));

        GraphLeaves graphLeaves = new GraphLeaves();
        assertThat(graphLeaves.execute(testGraph)).isEqualTo(0);
    }

    /*
        0 1 1
        1 0 1
        1 1 0
     */
    @Test
    void shouldCheckGraphLeavesOnUndirectedCycledGraph() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph3Test.txt"));

        GraphLeaves graphLeaves = new GraphLeaves();
        assertThat(graphLeaves.execute(testGraph)).isEqualTo(0);
    }

    /*
        0 0 1
        0 0 1
        1 1 0
     */
    @Test
    void shouldCheckGraphLeavesOnUndirectedGraphWithTwoLeaves() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph4Test.txt"));

        GraphLeaves graphLeaves = new GraphLeaves();
        assertThat(graphLeaves.execute(testGraph)).isEqualTo(2);
    }

    /*
        0 0 0 0 0 0 0
        0 0 1 1 1 0 0
        0 1 0 0 0 0 0
        0 1 0 0 1 0 0
        0 1 0 1 0 1 1
        0 0 0 0 1 0 0
        0 0 0 0 1 0 0
     */
    @Test
    void shouldCheckGraphLeavesOnUndirectedGraphWithThreeLeaves() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph5Test.txt"));

        GraphLeaves graphLeaves = new GraphLeaves();
        assertThat(graphLeaves.execute(testGraph)).isEqualTo(3);
    }

    /*
        0 1 0
        0 0 0
        0 1 0
     */
    @Test
    void shouldCheckGraphLeavesOnDirectedGraphWithZeroLeaves() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph6Test.txt"));

        GraphLeaves graphLeaves = new GraphLeaves();
        assertThat(graphLeaves.execute(testGraph)).isEqualTo(0);
    }

    /*
        0 1 0 0 0 0
        0 0 1 0 0 0
        0 0 0 0 0 0
        0 0 0 0 0 0
        0 0 0 0 0 1
        0 1 0 0 0 0
     */
    @Test
    void shouldCheckGraphLeavesOnDirectedGraphWithOneLeaf() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph7Test.txt"));

        GraphLeaves graphLeaves = new GraphLeaves();
        assertThat(graphLeaves.execute(testGraph)).isEqualTo(1);
    }

    /*
        0 1
        0 0
     */
    @Test
    void shouldCheckGraphLeavesOnDirectedGraphWithTwoVerticesAndOneArc() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph8Test.txt"));

        GraphLeaves graphLeaves = new GraphLeaves();
        assertThat(graphLeaves.execute(testGraph)).isEqualTo(1);
    }

    /*
        0 1 0 0 0
        0 0 1 0 0
        0 1 0 0 0
        0 0 1 0 1
        0 0 1 1 0
     */
    @Test
    void shouldCheckGraphLeavesOnDirectedGraphWithEdges() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph9Test.txt"));

        GraphLeaves graphLeaves = new GraphLeaves();
        assertThat(graphLeaves.execute(testGraph)).isEqualTo(0);
    }
}