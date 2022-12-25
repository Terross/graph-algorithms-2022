package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class EveryTwoHaveCommonTest {
    /*
  0 1
  1 0
    */
    @Test
    void shouldCheckEveryTwoHaveCommon2x2Undir() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/EveryTwoHaveCommon/testgraph1.txt"));

        EveryTwoHaveCommon haveCommon = new EveryTwoHaveCommon();
        assertThat(haveCommon.execute(testGraph)).isEqualTo(true);
    }
    /*
     0 1 0 0
     1 0 0 1
     0 1 0 0
     0 1 0 0
    */
    @Test
    void shouldCheckEveryTwoHaveCommon4x4Undir() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/EveryTwoHaveCommon/testgraph2.txt"));

        EveryTwoHaveCommon haveCommon = new EveryTwoHaveCommon();
        assertThat(haveCommon.execute(testGraph)).isEqualTo(true);
    }
    /*
    0 1 1 1
    0 0 0 0
    0 0 0 0
    1 0 0 0
    */
    @Test
    void shouldCheckEveryTwoHaveCommon4x4Dir1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/EveryTwoHaveCommon/testgraph3.txt"));

        EveryTwoHaveCommon haveCommon = new EveryTwoHaveCommon();
        assertThat(haveCommon.execute(testGraph)).isEqualTo(false);
    }
    /*
    0 1 1 1
    1 0 1 1
    1 1 0 1
    1 1 1 0
    */
    @Test
    void shouldCheckEveryTwoHaveCommon4x4FullUndir() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/EveryTwoHaveCommon/testgraph4.txt"));

        EveryTwoHaveCommon haveCommon = new EveryTwoHaveCommon();
        assertThat(haveCommon.execute(testGraph)).isEqualTo(true);
    }
    /*
    0 1 1 1 0
    1 0 1 1 0
    1 1 0 1 0
    1 1 1 0 0
    0 0 0 0 0
    */
    @Test
    void shouldCheckEveryTwoHaveCommon5x5NotConnectedUndir() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/EveryTwoHaveCommon/testgraph5.txt"));

        EveryTwoHaveCommon haveCommon = new EveryTwoHaveCommon();
        assertThat(haveCommon.execute(testGraph)).isEqualTo(false);
    }
    /*
    0 1 0 0 0
    1 0 1 1 0
    0 1 0 0 0
    0 1 0 0 1
    0 0 0 1 0
    */
    @Test
    void shouldCheckEveryTwoHaveCommon5x5UndirTree() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/EveryTwoHaveCommon/testgraph6.txt"));

        EveryTwoHaveCommon haveCommon = new EveryTwoHaveCommon();
        assertThat(haveCommon.execute(testGraph)).isEqualTo(false);
    }
    /*
    0 1 0 0
    0 0 1 0
    0 1 0 0
    0 1 0 0
    */
    @Test
    void shouldCheckEveryTwoHaveCommon4x4Dir2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/EveryTwoHaveCommon/testgraph7.txt"));

        EveryTwoHaveCommon haveCommon = new EveryTwoHaveCommon();
        assertThat(haveCommon.execute(testGraph)).isEqualTo(false);
    }
    /*
    0 1 1 0
    0 0 1 0
    0 1 0 0
    0 1 1 0
    */
    @Test
    void shouldCheckEveryTwoHaveCommon4x4Dir3() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/EveryTwoHaveCommon/testgraph8.txt"));

        EveryTwoHaveCommon haveCommon = new EveryTwoHaveCommon();
        assertThat(haveCommon.execute(testGraph)).isEqualTo(true);
    }
    /*
    0 1 1
    0 0 0
    0 0 0
    */
    @Test
    void shouldCheckEveryTwoHaveCommon3x3Dir4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/EveryTwoHaveCommon/testgraph9.txt"));

        EveryTwoHaveCommon haveCommon = new EveryTwoHaveCommon();
        assertThat(haveCommon.execute(testGraph)).isEqualTo(false);
    }
    /*
    0 1 0 0 0
    0 0 1 0 0
    0 1 0 1 0
    0 0 0 0 1
    0 0 1 1 0
    */
    @Test
    void shouldCheckEveryTwoHaveCommon5x5Dir5() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/EveryTwoHaveCommon/testgraph10.txt"));

        EveryTwoHaveCommon haveCommon = new EveryTwoHaveCommon();
        assertThat(haveCommon.execute(testGraph)).isEqualTo(false);
    }

}

