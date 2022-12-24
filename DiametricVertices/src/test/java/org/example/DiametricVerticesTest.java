package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class DiametricVerticesTest {

    /*
      0 1
      1 0

      marked - 0, 1
    */
    @Test
    void shouldCheckDiametricalVerticesOnLineSegmentGraphWhenMarked0And1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph1.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph)).isEqualTo(true);
    }

    /*
      0 1 1
      1 0 1
      1 1 0

      marked - 0, 1, 2
    */
    @Test
    void shouldCheckDiametricalVerticesOnTriangleWhenMarkedAll() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph2.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph)).isEqualTo(true);
    }

    /*
      0

      marked - 0
    */
    @Test
    void shouldCheckDiametricalVerticesWithOnlyOneMarkedVertice() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph3.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0 0
      1 0 1 0
      0 1 0 1
      0 0 1 0

      marked - 0, 3
    */
    @Test
    void shouldCheckDiametricalVerticesWithOneWayAndMiddleMarkedVertex() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph4.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0 1 1 0
      0 0 1 1 0 0
      1 0 0 0 1 0
      0 0 1 0 0 0
      0 0 0 1 0 0
      1 0 0 1 1 0

      marked - 1, 5
    */
    @Test
    void shouldCheckDiametricalVerticesWithNonConnectedMarkedVertex() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph5.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 0 0
      1 0 1
      1 0 0

      marked - 1, 2
    */
    @Test
    void shouldCheckDiametricalVerticesWithDirectedTriangleAndDifferentLengthWays() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph6.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0 1 0 1
      1 0 1 1 0 0
      0 1 0 1 1 0
      1 1 1 0 1 1
      0 0 1 1 0 1
      1 0 0 1 1 0

      marked - 3, 4
    */
    @Test
    void shouldCheckDiametricalVerticesWithManyVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph7.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0 0 0
      0 0 1 1 0
      0 0 0 0 1
      0 1 1 0 0
      1 1 0 1 0

      marked - 0, 2
    */
    @Test
    void shouldCheckDiametricalVerticesWithFiveVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph8.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0 0
      0 0 1 1
      0 0 0 0
      1 0 1 0

      marked - 0, 2
    */
    @Test
    void shouldCheckDiametricalVerticesWithFourVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph9.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0
      1 0 1
      0 1 0

      marked - 0, 2
    */
    @Test
    void shouldCheckDiametricalVerticesWithThreeVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph10.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph)).isEqualTo(true);
    }

    /*
    */
    @Test
    void shouldCheckDiametricalVerticesWithEmptyFile() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph11.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0 0 0 1 0
      0 0 1 0 0 0 0
      0 0 0 1 0 0 0
      0 0 1 0 0 0 1
      0 0 0 1 0 0 0
      1 0 0 0 1 0 0
      0 0 1 0 0 1 0

      marked 2, 5
     */
    @Test
    void shouldCheckDiametricalVerticesDifferentWaysAndEqualsLength() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph12.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph)).isEqualTo(true);
    }
}
