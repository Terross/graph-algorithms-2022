import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
public class EdgeGraphTest {
    @Test
    void EdgeGraph_1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph1.txt"));

        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void EdgeGraph_2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph2.txt"));
        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void EdgeGraph_4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph4.txt"));
        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.execute(testGraph)).isEqualTo(false);
    }
    @Test
    void EdgeGraph_5() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph5.txt"));
        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void EdgeGraph_6() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/15_graph6.txt"));
        EdgeGraph isEdgeGraph_ = new EdgeGraph();
        assertThat(isEdgeGraph_.execute(testGraph)).isEqualTo(true);
    }


}

