package example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphTestTest {

    @Test
    void MyTest1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph_1.txt"));

        AntiTransitive GraphTest = new AntiTransitive();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(true);
    }

    @Test
    void MyTest2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph_2.txt"));

        AntiTransitive GraphTest = new AntiTransitive();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }

    @Test
    void MyTest3() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph_3.txt"));

        AntiTransitive GraphTest = new AntiTransitive();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(true);
    }

    @Test
    void MyTest4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph_4.txt"));

        AntiTransitive GraphTest = new AntiTransitive();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(false);
    }

}
