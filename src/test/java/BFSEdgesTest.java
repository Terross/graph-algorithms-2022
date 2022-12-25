import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BFSEdgesTest {
    @Test
    public void testBFSVertices() throws FileNotFoundException {
        Graph graphTrue1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graphTrue1.txt"));
//        Graph graphTrue2 = GraphFactory.loadGraphFromFile(new File("src/main/resources/graphTrue2.txt"));
        Graph graphFalse = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graphTrue1.txt"));

        BFSEdgesTest bfsEdges = new BFSEdgesTest();

//        assertThat(bfsEdges.execute(graphTrue1)).isTrue();
////        assertThat(bfsEertices.execute(graphTrue2)).isTrue();
//        assertThat(bfsEdges.execute(graphFalse)).isFalse();

    }
}
