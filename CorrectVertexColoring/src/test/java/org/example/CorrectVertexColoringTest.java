package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class CorrectVertexColoringTest {
    /*
    adjacency matrix
     0 1
     1 0
     */
    @Test
    void shouldCheckCorrectVertexColoringOnLineSegmentGraph() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test1.txt"));

        CorrectVertexColoring correctVertexColoring = new CorrectVertexColoring();
        assertThat(correctVertexColoring.execute(testGraph)).isEqualTo(false);
    }

    /*
    adjacency matrix
      0 1 1
      1 0 1
      1 1 0
    */
    @Test
    void shouldCheckCorrectVertexColoringOnTriangle() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test2.txt"));

        CorrectVertexColoring correctVertexColoring = new CorrectVertexColoring();
        assertThat(correctVertexColoring.execute(testGraph)).isEqualTo(true);
    }

    /*
    adjacency matrix
     0
   */
    @Test
    void shouldCheckCorrectVertexColoringWithOnlyOneVertex() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test3.txt"));

        CorrectVertexColoring correctVertexColoring = new CorrectVertexColoring();
        assertThat(correctVertexColoring.execute(testGraph)).isEqualTo(true);
    }

    /*
    adjacency matrix
      0 1 0 0
      1 0 1 0
      0 1 0 1
      0 0 1 0
    */
    @Test
    void shouldCheckCorrectVertexColoringOnOneWay() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test4.txt"));

        CorrectVertexColoring correctVertexColoring = new CorrectVertexColoring();
        assertThat(correctVertexColoring.execute(testGraph)).isEqualTo(true);
    }

    /*
    adjacency matrix
      0 1 0 1 1 0
      0 0 1 1 0 0
      1 0 0 0 1 0
      0 0 1 0 0 0
      0 0 0 1 0 0
      1 0 0 1 1 0
    */
    @Test
    void shouldCheckCorrectVertexColoringWithOneColorVertexes() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test5.txt"));

        CorrectVertexColoring correctVertexColoring = new CorrectVertexColoring();
        assertThat(correctVertexColoring.execute(testGraph)).isEqualTo(false);
    }

    /*
    adjacency matrix
      0 0 0
      1 0 1
      1 0 0
    */
    @Test
    void shouldCheckCorrectVertexColoringWithDirectedTriangleAndDifferentLengthWays() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test6.txt"));

        CorrectVertexColoring correctVertexColoring = new CorrectVertexColoring();
        assertThat(correctVertexColoring.execute(testGraph)).isEqualTo(false);
    }

    /*
    adjacency matrix
      0 1 0 1 0 1
      1 0 1 1 0 0
      0 1 0 1 1 0
      1 1 1 0 1 1
      0 0 1 1 0 1
      1 0 0 1 1 0
    */
    @Test
    void shouldCheckCorrectVertexColoringWithManyVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test7.txt"));

        CorrectVertexColoring correctVertexColoring = new CorrectVertexColoring();
        assertThat(correctVertexColoring.execute(testGraph)).isEqualTo(false);
    }

    /*
    adjacency matrix
      0 1 0 0 0
      0 0 1 1 0
      0 0 0 0 1
      0 1 1 0 0
      1 1 0 1 0
    */
    @Test
    void shouldCheckCorrectVertexColoringWithFiveVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test8.txt"));

        CorrectVertexColoring correctVertexColoring = new CorrectVertexColoring();
        assertThat(correctVertexColoring.execute(testGraph)).isEqualTo(false);
    }

    /*
    adjacency matrix
      0 1 0 0
      0 0 1 1
      0 0 0 0
      1 0 1 0
    */
    @Test
    void shouldCheckCorrectVertexColoringWithFourVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test9.txt"));

        CorrectVertexColoring correctVertexColoring = new CorrectVertexColoring();
        assertThat(correctVertexColoring.execute(testGraph)).isEqualTo(true);
    }
    /*
    adjacency matrix
      0 1 0
      1 0 1
      0 1 0
    */
    @Test
    void shouldCheckCorrectVertexColoringWithThreeVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test10.txt"));

        CorrectVertexColoring correctVertexColoring = new CorrectVertexColoring();
        assertThat(correctVertexColoring.execute(testGraph)).isEqualTo(true);
    }
    /*
    adjacency matrix

     */
    @Test
    void shouldCheckCorrectVertexColoringWithEmptyFile() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test11.txt"));

        CorrectVertexColoring correctVertexColoring = new CorrectVertexColoring();
        assertThat(correctVertexColoring.execute(testGraph)).isEqualTo(true);
    }

    /*
    adjacency matrix
      0 1 0 0 0 1 0
      0 0 1 0 0 0 0
      0 0 0 1 0 0 0
      0 0 1 0 0 0 1
      0 0 0 1 0 0 0
      1 0 0 0 1 0 0
      0 0 1 0 0 1 0
     */
    @Test
    void shouldCheckCorrectVertexColoringDifferentWaysAndEqualsLength() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test12.txt"));

        CorrectVertexColoring correctVertexColoring = new CorrectVertexColoring();
        assertThat(correctVertexColoring.execute(testGraph)).isEqualTo(true);
    }
}
