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
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph_da1.txt"));

        dvudol.GraphDvudol GraphTest = new  dvudol.GraphDvudol();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(true);
    }

    @Test
    void MyTest2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph_da2.txt"));

        dvudol.GraphDvudol GraphTest = new  dvudol.GraphDvudol();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(true);
    }

    @Test
    void MyTest3() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph_da3.txt"));

        dvudol.GraphDvudol GraphTest = new dvudol.GraphDvudol();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(true);
    }

    @Test
    void MyTest4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph_net1.txt"));

        dvudol.GraphDvudol GraphTest = new  dvudol.GraphDvudol();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void MyTest5() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph_net2.txt"));

        dvudol.GraphDvudol GraphTest = new  dvudol.GraphDvudol();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void MyTest6() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph_net3.txt"));

        dvudol.GraphDvudol GraphTest = new  dvudol.GraphDvudol();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }
}
