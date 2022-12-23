package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class EccentricityTest {

    /*
      0 0 0 0 1
      1 0 0 0 0
      0 1 0 0 0
      0 0 1 0 0
      0 0 0 1 0
    */
    @Test
    void shouldCheckTest_1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_1.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(true);
    }

    /*
      0 1 3 0 0 0
      0 0 2 0 0 0
      0 0 0 2 0 0
      0 0 0 2 0 1
      0 0 0 3 0 0
      0 0 0 0 2 0
    */
    @Test
    void shouldCheckTest_2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_2.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 0
      0 0
    */
    @Test
    void shouldCheckTest_3() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_3.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(true);
    }

    /*
      0 0
      0 0
    */
    @Test
    void shouldCheckTest_4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_4.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 0 2 3 0
      0 0 0 4 2
      2 0 0 0 2
      3 4 0 0 0
      0 2 2 0 0
     */
    @Test
    void shouldCheckTest_5() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_5.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(true);
    }

    /*
     0 1 0 2 0 0
     1 0 0 0 0 0
     0 0 0 3 0 5
     2 0 3 0 4 0
     0 0 0 4 0 0
     0 0 5 0 0 0
     */
    @Test
    void shouldCheckTest_6() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_6.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(true);
    }

    /*
      0 2 0 4 0
      2 0 1 0 0
      0 1 0 0 0
      4 0 0 0 1
      0 0 0 1 0
     */
    @Test
    void shouldCheckTest_7() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_7.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 3 1 5 0
      3 0 2 0 0
      1 2 0 4 1
      5 0 4 0 0
      0 0 1 0 0
     */
    @Test
    void shouldCheckTest_8() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_8.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(true);
    }

    /*
      0 3 1 5 0
      3 0 2 0 0
      1 2 0 4 0
      5 0 4 0 0
      0 0 0 0 0
     */
    @Test
    void shouldCheckTest_9() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_9.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 3 1 5 0
      3 0 2 0 0
      1 2 0 4 0
      5 0 4 0 0
      0 0 0 0 0
     */
    @Test
    void shouldCheckTest_10() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_10.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(true);
    }

    /*
      0 3 0
      0 0 4
      1 3 0
     */
    @Test
    void shouldCheckTest_11() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_11.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(true);
    }

    /*
      0 5 0 0 0
      0 0 0 0 0
      1 3 0 0 0
      0 0 0 0 0
     */
    @Test
    void shouldCheckTest_12() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_12.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 2 2 1
      4 0 3 4
      0 6 0 0
      0 5 3 0
     */
    @Test
    void shouldCheckTest_13() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Eccentricity/test_13.txt"));

        Eccentricity graph = new Eccentricity();
        assertThat(graph.execute(testGraph)).isEqualTo(false);
    }

}