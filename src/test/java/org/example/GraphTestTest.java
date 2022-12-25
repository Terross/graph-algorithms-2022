package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphTestTest {

    @Test
    void Test1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test1.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }

    @Test
    void Test2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test2.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }

    @Test
    void Test3() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test3.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(1);
    }

    @Test
    void Test4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test4.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-2);
    }

    @Test
    void Test5() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test5.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(1);
    }

    @Test
    void Test6() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test6.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(5);
    }

    @Test
    void Test7() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test7.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }
    @Test
    void Test8() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test8.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-2);
    }
    @Test
    void Test9() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test9.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }
    @Test
    void Test10() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test10.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-2);
    }
    @Test
    void Test11() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test11.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(2);
    }
    @Test
    void Test12() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test12.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-2);
    }
    @Test
    void Test13() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test13.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }
    @Test
    void Test14() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test14.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }
    @Test
    void Test15() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test15.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(4);
    }
    @Test
    void Test16() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test16.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }
    @Test
    void Test17() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test17.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(3);
    }

    @Test
    void Test18() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test18.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-2);
    }
    @Test
    void Test19() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test19.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(2);
    }
    @Test
    void Test20() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test20.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }

}
