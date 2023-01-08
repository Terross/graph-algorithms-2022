import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
public class EdgeAmbiguilityTest {

    @Test
    void Edge1() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/17_test1.txt"));
        EdgeAmbiguity countEdges = new EdgeAmbiguity();
        assertThat(countEdges.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void Edge2() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/17_test2.txt"));
        EdgeAmbiguity countEdges = new EdgeAmbiguity();
        assertThat(countEdges.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void Edge3() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/17_test3.txt"));
        EdgeAmbiguity countEdges = new EdgeAmbiguity();
        assertThat(countEdges.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void Edge4() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/17_test4.txt"));
        EdgeAmbiguity countEdges = new EdgeAmbiguity();
        assertThat(countEdges.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void Edge5() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/17_test5.txt"));
        EdgeAmbiguity countEdges = new EdgeAmbiguity();
        assertThat(countEdges.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void Edge6() throws FileNotFoundException{
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/17_test6.txt"));
        EdgeAmbiguity countEdges = new EdgeAmbiguity();
        assertThat(countEdges.execute(testGraph)).isEqualTo(false);
    }

}
