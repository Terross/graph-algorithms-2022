package org.example;
import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
public class K33GraphTest {
    @Test
    void K33Graph_1() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/13_graph1.txt"));
        K33Graph hasK33 = new K33Graph();
        assertThat(hasK33.hasK33Subgraph(testGraph_1)).isEqualTo(true);
    }
        @Test
    void K33Graph_2() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/13_graph2.txt"));
        K33Graph hasK33 = new K33Graph();
        assertThat(hasK33.hasK33Subgraph(testGraph_1)).isEqualTo(false);
    }
        @Test
    void K33Graph_3() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/13_graph3.txt"));
        K33Graph hasK33 = new K33Graph();
        assertThat(hasK33.hasK33Subgraph(testGraph_1)).isEqualTo(true);
    }
        @Test
    void K33Graph_4() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/13_graph4.txt"));
        K33Graph hasK33 = new K33Graph();
        assertThat(hasK33.hasK33Subgraph(testGraph_1)).isEqualTo(false);
    }
        @Test
    void K33Graph_5() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/13_graph5.txt"));
        K33Graph hasK33 = new K33Graph();
        assertThat(hasK33.hasK33Subgraph(testGraph_1)).isEqualTo(true);
    }
        @Test
    void K33Graph_6() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/13_graph6.txt"));
        K33Graph hasK33 = new K33Graph();
        assertThat(hasK33.hasK33Subgraph(testGraph_1)).isEqualTo(false);
    }
        @Test
    void K33Graph_7() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/13_graph7.txt"));
        K33Graph hasK33 = new K33Graph();
        assertThat(hasK33.hasK33Subgraph(testGraph_1)).isEqualTo(true);
    }
        @Test
    void K33Graph_8() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/13_graph8.txt"));
        K33Graph hasK33 = new K33Graph();
        assertThat(hasK33.hasK33Subgraph(testGraph_1)).isEqualTo(true);
    }
        @Test
    void K33Graph_9() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/13_graph9.txt"));
        K33Graph hasK33 = new K33Graph();
        assertThat(hasK33.hasK33Subgraph(testGraph_1)).isEqualTo(false);
    }
        @Test
    void K33Graph_10() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/13_graph10.txt"));
        K33Graph hasK33 = new K33Graph();
        assertThat(hasK33.hasK33Subgraph(testGraph_1)).isEqualTo(false);
    }

}
