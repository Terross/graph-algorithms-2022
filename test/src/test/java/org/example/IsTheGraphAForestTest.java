package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class IsTheGraphAForestTest {
    /*
0 1 1 0 0 0 0
0 0 0 1 0 0 0
0 0 0 1 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 1 1
0 0 0 0 0 0 0
0 0 0 0 0 0 0
*/
    @Test
    void shouldCheckForest() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/IsTheGraphAForest/testgraphsonia.txt"));

        IsTheGraphAForest haveCommon = new IsTheGraphAForest();
        assertThat(haveCommon.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void checkEmptyGraph() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/IsTheGraphAForest/graph1Test.txt"));

        IsTheGraphAForest graph = new IsTheGraphAForest();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void checkEdgelessGraph() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/IsTheGraphAForest/graph2Test.txt"));

        IsTheGraphAForest graph = new IsTheGraphAForest();
        assertThat(graph.execute(testGraph)).isEqualTo(true);
    }

    @Test
    void checkUNDCycleGraph1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/IsTheGraphAForest/graph3Test.txt"));

        IsTheGraphAForest graph = new IsTheGraphAForest();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void checkUNDNotCycleGraph() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/IsTheGraphAForest/graph4Test.txt"));

        IsTheGraphAForest graph = new IsTheGraphAForest();
        assertThat(graph.execute(testGraph)).isEqualTo(true);
    }

    @Test
    void checkUNDCycleGraph2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/IsTheGraphAForest/graph5Test.txt"));

        IsTheGraphAForest graph = new IsTheGraphAForest();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void checkDNotCycleGraphMultipleParents1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/IsTheGraphAForest/graph6Test.txt"));

        IsTheGraphAForest  graph = new IsTheGraphAForest();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void checkDNotCycleGraphMultipleParents2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/IsTheGraphAForest/graph7Test.txt"));

        IsTheGraphAForest  graph = new IsTheGraphAForest();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void checkDCycleGraph() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/IsTheGraphAForest/graph8Test.txt"));

        IsTheGraphAForest  graph = new IsTheGraphAForest();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void checkDNotCycleGraph() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/IsTheGraphAForest/graph9Test.txt"));

        IsTheGraphAForest  graph = new IsTheGraphAForest();
        assertThat(graph.execute(testGraph)).isEqualTo(true);
    }

    @Test
    void checkDGraphWithLoops() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/IsTheGraphAForest/graph10Test.txt"));

        IsTheGraphAForest  graph = new IsTheGraphAForest();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }
}