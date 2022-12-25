package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class test {

    @Test
    void MyTest1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test1.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }

    @Test
    void MyTest2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test2.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }

    @Test
    void MyTest3() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test3.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(1);
    }

    @Test
    void MyTest4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test4.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-2);
    }

    @Test
    void MyTest5() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test5.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(1);
    }

    @Test
    void MyTest6() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test6.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(5);
    }

    @Test
    void MyTest7() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test7.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }

    @Test
    void MyTest8() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test8.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-2);
    }

    @Test
    void MyTest9() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test9.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }

    @Test
    void MyTest10() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test10.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-2);
    }

    @Test
    void MyTest11() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test11.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(2);
    }

    @Test
    void MyTest12() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test12.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-2);
    }

    @Test
    void MyTest13() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test13.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }

    @Test
    void MyTest14() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test14.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }

    @Test
    void MyTest15() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test15.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(4);
    }

    @Test
    void MyTest16() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test16.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }

    @Test
    void MyTest17() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test17.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(3);
    }

    @Test
    void MyTest18() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test18.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-2);
    }

    @Test
    void MyTest19() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test19.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(2);
    }

    @Test
    void MyTest20() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test20.txt"));

        RedNeighbour GraphTest = new RedNeighbour();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }
}