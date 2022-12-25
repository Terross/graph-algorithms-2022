package org.example;
import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
public class EdgeGraphTest {
    @Test
    void EdgeGraph_1() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph1_1.txt"));
        Graph testGraph_2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph1_2.txt"));
        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.isEdgeGraph(testGraph_1, testGraph_2)).isEqualTo(true);
    }
    @Test
    void EdgeGraph_2() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph2_1.txt"));
        Graph testGraph_2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph2_2.txt"));
        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.isEdgeGraph(testGraph_2, testGraph_1)).isEqualTo(true);
    }
    @Test
    void EdgeGraph_3() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph3_1.txt"));
        Graph testGraph_2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph3_2.txt"));
        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.isEdgeGraph(testGraph_1, testGraph_2)).isEqualTo(true);
    }
    @Test
    void EdgeGraph_4() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph4_1.txt"));
        Graph testGraph_2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph4_2.txt"));
        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.isEdgeGraph(testGraph_1, testGraph_2)).isEqualTo(true);
    }
    @Test
    void EdgeGraph_5() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph5_1.txt"));
        Graph testGraph_2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph5_2.txt"));
        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.isEdgeGraph(testGraph_1, testGraph_2)).isEqualTo(false);
    }
    @Test
    void EdgeGraph_6() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph6_1.txt"));
        Graph testGraph_2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph6_2.txt"));
        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.isEdgeGraph(testGraph_1, testGraph_2)).isEqualTo(false);
    }
    @Test
    void EdgeGraph_7() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph7_1.txt"));
        Graph testGraph_2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph7_2.txt"));
        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.isEdgeGraph(testGraph_1, testGraph_2)).isEqualTo(true);
    }
    @Test
    void EdgeGraph_8() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph8_1.txt"));
        Graph testGraph_2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph8_2.txt"));
        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.isEdgeGraph(testGraph_1, testGraph_2)).isEqualTo(true);
    }

}

