import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BFSVerticesTest {
    @Test
    public void testBFSVertices() throws FileNotFoundException {
        Graph graphTrue1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graphTrue1.txt"));
//        Graph graphTrue2 = GraphFactory.loadGraphFromFile(new File("src/main/resources/graphTrue2.txt"));
        Graph graphFalse = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graphTrue1.txt"));

        BFSVertices bfsVertices = new BFSVertices();

        assertThat(bfsVertices.execute(graphTrue1)).isTrue();
//        assertThat(bfsVertices.execute(graphTrue2)).isTrue();
        assertThat(bfsVertices.execute(graphFalse)).isFalse();

    }
}
