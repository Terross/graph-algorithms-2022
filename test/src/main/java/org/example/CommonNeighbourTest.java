package org.example;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.api.graph.GraphFactory;


class CommonNeighbourTest {

    /*
      0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph1.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(false, commonNeighbour.execute(testGraph));
    }

    /*
      0 1
      1 0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph2.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(false, commonNeighbour.execute(testGraph));
    }

    /*
      0 1
      0 0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_3() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph3.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(false, commonNeighbour.execute(testGraph));
    }

    /*
      0 1 0
      1 0 1
      0 1 0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph4.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(false, commonNeighbour.execute(testGraph));
    }

    /*
      0 1 1
      1 0 1
      1 1 0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_5() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph5.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(true, commonNeighbour.execute(testGraph));
    }

    /*
      0 1 0
      0 0 1
      1 0 0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_6() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph6.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(false, commonNeighbour.execute(testGraph));
    }

    /*
      0 0 0
      1 0 1
      1 0 0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_7() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph7.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(false, commonNeighbour.execute(testGraph));
    }

    /*
      0 1 1 0
      1 0 0 1
      1 0 0 1
      0 1 1 0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_8() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph8.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(false, commonNeighbour.execute(testGraph));
    }

    /*
      0 1 1 0
      1 0 1 1
      1 1 0 1
      0 1 1 0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_9() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph9.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(true, commonNeighbour.execute(testGraph));
    }

    /*
      0 1 1 0
      0 0 0 0
      0 1 0 1
      1 0 0 0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_10() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph10.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(false, commonNeighbour.execute(testGraph));
    }

    /*
      0 1 0 0 1
      1 0 1 0 1
      0 1 0 1 0
      0 0 1 0 1
      1 1 0 1 0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_11() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph11.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(false, commonNeighbour.execute(testGraph));
    }

    /*
      0 1 0 0 1
      1 0 0 0 1
      0 0 0 1 1
      0 0 1 0 1
      1 1 1 1 0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_12() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph12.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(true, commonNeighbour.execute(testGraph));
    }

    /*
      0 1 1 0
      0 0 1 0
      0 1 0 0
      0 1 1 0
     */
    @org.junit.jupiter.api.Test
    void testCommonNeighbour_13() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/CommonNeighbour/testgraph8sonia.txt"));

        CommonNeighbour commonNeighbour = new CommonNeighbour();

        assertEquals(false, commonNeighbour.execute(testGraph));
    }
}