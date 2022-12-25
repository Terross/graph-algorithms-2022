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
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/lin.txt"));

        LinearOrderCheck GraphTest = new LinearOrderCheck();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(true);
    }

    @Test
    void MyTest2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/ne_assim.txt"));

        LinearOrderCheck GraphTest = new LinearOrderCheck();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void MyTest3() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/ne_transit.txt"));

        LinearOrderCheck GraphTest = new LinearOrderCheck();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void MyTest4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/visyachaya_vershina.txt"));

        LinearOrderCheck GraphTest = new LinearOrderCheck();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void MyTest5() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/ne_lin_ne_transit.txt"));

        LinearOrderCheck GraphTest = new LinearOrderCheck();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void MyTest6() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/ne_ne_ne.txt"));

        LinearOrderCheck GraphTest = new LinearOrderCheck();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }
}
