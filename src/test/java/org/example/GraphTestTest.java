package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphTestTest {

    @Test
    void MyTest1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test1.txt"));

        GraphTranzit GraphTest = new GraphTranzit();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(true);
    }

    @Test
    void MyTest2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test2not.txt"));

        GraphTranzit GraphTest = new GraphTranzit();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void MyTest3() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test3.txt"));

        GraphTranzit GraphTest = new GraphTranzit();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void MyTest4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test4not.txt"));

        GraphTranzit GraphTest = new GraphTranzit();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void MyTest5() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test5.txt"));

        GraphTranzit GraphTest = new GraphTranzit();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(true);
    }

    @Test
    void MyTest6() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test6.txt"));

        GraphTranzit GraphTest = new GraphTranzit();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void MyTest7() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test7easy.txt"));

        GraphTranzit GraphTest = new GraphTranzit();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void MyTest8() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test8easyNot.txt"));

        GraphTranzit GraphTest = new GraphTranzit();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }
}
