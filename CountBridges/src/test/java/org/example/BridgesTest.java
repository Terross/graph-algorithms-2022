package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgesTest {
    @Test
    void bridges1() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/18_graph1.txt"));
        CountBridges countBridges = new CountBridges();
        assertThat(countBridges.bridgeCounter(testGraph)).isEqualTo(1);
    }
    @Test
    void bridges2() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/18_graph2.txt"));
        CountBridges countBridges = new CountBridges();
        assertThat(countBridges.bridgeCounter(testGraph)).isEqualTo(8);
    }
    @Test
    void bridges3() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/18_graph3.txt"));
        CountBridges countBridges = new CountBridges();
        assertThat(countBridges.bridgeCounter(testGraph)).isEqualTo(3);
    }

    @Test
    void bridges4() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/18_graph4.txt"));
        CountBridges countBridges = new CountBridges();
        assertThat(countBridges.bridgeCounter(testGraph)).isEqualTo(6);
    }

    @Test
    void bridges5() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/18_graph5.txt"));
        CountBridges countBridges = new CountBridges();
        assertThat(countBridges.bridgeCounter(testGraph)).isEqualTo(5);
    }

    @Test
    void bridges6() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/18_graph6.txt"));
        CountBridges countBridges = new CountBridges();
        assertThat(countBridges.bridgeCounter(testGraph)).isEqualTo(10);
    }

    @Test
    void bridges7() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/18_graph7.txt"));
        CountBridges countBridges = new CountBridges();
        assertThat(countBridges.bridgeCounter(testGraph)).isEqualTo(2);
    }

    @Test
    void bridges8() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/18_graph8.txt"));
        CountBridges countBridges = new CountBridges();
        assertThat(countBridges.bridgeCounter(testGraph)).isEqualTo(3);
    }

    @Test
    void bridges9() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/18_graph9.txt"));
        CountBridges countBridges = new CountBridges();
        assertThat(countBridges.bridgeCounter(testGraph)).isEqualTo(0);
    }

    @Test
    void bridges10() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/18_graph10.txt"));
        CountBridges countBridges = new CountBridges();
        assertThat(countBridges.bridgeCounter(testGraph)).isEqualTo(0);
    }
}