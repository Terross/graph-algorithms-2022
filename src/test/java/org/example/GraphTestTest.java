

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphTestTest {

    @Test
    void Test1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test_1.txt"));

        AntiTransitive GraphTest = new AntiTransitive();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }

    @Test
    void Test2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test_2.txt"));

        AntiTransitive GraphTest = new AntiTransitive();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }

    @Test
    void Test3() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test_3.txt"));

        AntiTransitive GraphTest = new AntiTransitive();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(1);
    }

    @Test
    void Test4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test_4.txt"));

        AntiTransitive GraphTest = new AntiTransitive();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-2);
    }

    @Test
    void Test5() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test_5.txt"));

        AntiTransitive GraphTest = new AntiTransitive();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(1);
    }

    @Test
    void Test6() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test_6.txt"));

        AntiTransitive GraphTest = new AntiTransitive();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(5);
    }

    @Test
    void Test7() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test_7.txt"));

        AntiTransitive GraphTest = new AntiTransitive();
        assertThat(GraphTest.execute(testGraph)).isEqualTo(-1);
    }


}
