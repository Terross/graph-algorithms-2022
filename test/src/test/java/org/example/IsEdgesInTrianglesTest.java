package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;


public class IsEdgesInTrianglesTest
{

    /*
      0 1
      1 0
    */
    @Test
    void shouldCheckIsEdgesInTrianglesOnLineSegmentGraphWhenMarked0And1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph1.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 1
      1 0 1
      1 1 0
    */
    @Test
    void shouldCheckIsEdgesInTrianglesOnTriangleWhenMarkedAll() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph2.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(true);
    }

    /*
      0
    */
    @Test
    void shouldCheckIsEdgesInTrianglesWithOnlyOneMarkedVertice() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph3.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0 0
      1 0 1 0
      0 1 0 1
      0 0 1 0
    */
    @Test
    void shouldCheckIsEdgesInTrianglesWithOneWayAndMiddleMarkedVertex() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph4.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0 1 1 0
      0 0 1 1 0 0
      1 0 0 0 1 0
      0 0 1 0 0 0
      0 0 0 1 0 0
      1 0 0 1 1 0
    */
    @Test
    void shouldCheckIsEdgesInTrianglesWithNonConnectedMarkedVertex() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph5.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 0 0
      1 0 1
      1 0 0
    */
    @Test
    void shouldCheckIsEdgesInTrianglesWithDirectedTriangleAndDifferentLengthWays() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph6.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0 1 0 1
      1 0 1 1 0 0
      0 1 0 1 1 0
      1 1 1 0 1 1
      0 0 1 1 0 1
      1 0 0 1 1 0
    */
    @Test
    void shouldCheckIsEdgesInTrianglesWithManyVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph7.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(true);
    }

    /*
      0 1 0 0 0
      0 0 1 1 0
      0 0 0 0 1
      0 1 1 0 0
      1 1 0 1 0
    */
    @Test
    void shouldCheckIsEdgesInTrianglesWithFiveVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph8.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0 0
      0 0 1 1
      0 0 0 0
      1 0 1 0
    */
    @Test
    void shouldCheckIsEdgesInTrianglesWithFourVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph9.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0
      1 0 1
      0 1 0
    */
    @Test
    void shouldCheckIsEdgesInTrianglesWithThreeVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph10.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(false);
    }

    /*
     */
    @Test
    void shouldCheckIsEdgesInTrianglesWithEmptyFile() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph11.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0 0 0 1 0
      0 0 1 0 0 0 0
      0 0 0 1 0 0 0
      0 0 1 0 0 0 1
      0 0 0 1 0 0 0
      1 0 0 0 1 0 0
      0 0 1 0 0 1 0
     */
    @Test
    void shouldCheckIsEdgesInTrianglesDifferentWaysAndEqualsLength() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph12.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(false);
    }
 
    /*
      0 0 1
      1 0 0
      0 1 0
    */

    @Test
    void shouldCheckIsEdgesInTrianglesInTriangleGraph() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph13.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(true);
    }
 
    /*
      0 0 1 0
      1 0 0 0
      0 1 0 1
      0 0 0 0
    */

    @Test
    void shouldCheckIsEdgesInTrianglesInFourEdgesGraphWithOneTriangle() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/isEdgesInTriangles/testgraph14.txt"));

        IsEdgesInTriangles isEdgesInTriangles = new IsEdgesInTriangles();
        assertThat(isEdgesInTriangles.execute(testGraph)).isEqualTo(false);
    }
}
 
