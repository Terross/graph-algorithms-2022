package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;


public class ChromaticNumberTest {
    /*
      0 1
      1 0
    */
    @Test
    void shouldFindChromaticNumberOnLineSegmentGraphWhenMarked0And1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph1.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(2);
    }

    /*
      0 1 1
      1 0 1
      1 1 0
    */
    @Test
    void shouldFindChromaticNumberOnTriangleWhenMarkedAll() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph2.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(3);
    }

    /*
      0
    */
    @Test
    void shouldFindChromaticNumberWithOnlyOneMarkedVertice() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph3.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(1);
    }

    /*
      0 1 0 0
      1 0 1 0
      0 1 0 1
      0 0 1 0
    */
    @Test
    void shouldFindChromaticNumberWithOneWayAndMiddleMarkedVertex() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph4.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(2);
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
    void shouldFindChromaticNumberWithNonConnectedMarkedVertex() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph5.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(4);
    }

    /*
      0 0 0
      1 0 1
      1 0 0
    */
    @Test
    void shouldFindChromaticNumberWithDirectedTriangleAndDifferentLengthWays() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph6.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(3);
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
    void shouldFindChromaticNumberWithManyVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph7.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(4);
    }

    /*
      0 1 0 0 0
      0 0 1 1 0
      0 0 0 0 1
      0 1 1 0 0
      1 1 0 1 0
    */
    @Test
    void shouldFindChromaticNumberWithFiveVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph8.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(4);
    }

    /*
      0 1 0 0
      0 0 1 1
      0 0 0 0
      1 0 1 0
    */
    @Test
    void shouldFindChromaticNumberWithFourVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph9.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(3);
    }

    /*
      0 1 0
      1 0 1
      0 1 0
    */
    @Test
    void shouldFindChromaticNumberWithThreeVertices() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph10.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(2);
    }

    /*
     */
    @Test
    void shouldFindChromaticNumberWithEmptyFile() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph11.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(0);
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
    void shouldFindChromaticNumberDifferentWaysAndEqualsLength() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph12.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(3);
    }

    /*
      0 0 1
      1 0 0
      0 1 0
    */

    @Test
    void shouldFindChromaticNumberInTriangleGraph() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph13.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(3);
    }

    /*
      0 0 1 0
      1 0 0 0
      0 1 0 1
      0 0 0 0
    */

    @Test
    void shouldFindChromaticNumberInFourEdgesGraphWithOneTriangle() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph14.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(3);
    }

    @Test
    void shouldFindChromaticNumberInSixEdgesCycledGraph() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph15.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(2);
    }

    @Test
    void shouldFindChromaticNumberInSixEdgesCycledGraph22() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph16.txt"));

        ChromaticNumber chromaticNumber = new ChromaticNumber();
        assertThat(chromaticNumber.execute(testGraph)).isEqualTo(2);
    }
}
