import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BFSVerticesTest {
    @Test
    public void testBFSVertices() throws FileNotFoundException {
        Graph graphTrue1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graphTrue.txt"));
        Graph graphTrue2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graphTrue1.txt"));
        Graph graphTrue3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graph_1_true.txt"));

        Graph graphFalse1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graphFalse.txt"));
        Graph graphFalse2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graphFalse2.txt"));
        Graph graphFalse3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graph_1_false.txt"));
        Graph graphFalse4 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graph_2_false.txt"));
        Graph graphFalse5 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graph_3_false.txt"));
        Graph graphFalse6 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graph_empty.txt"));
        Graph graphFalse7 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graph_not_connective.txt"));
        Graph graphFalse8 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsVertices/graph_one_vert.txt"));


        BFSVertices bfsVertices = new BFSVertices();

        assertThat(bfsVertices.execute(graphTrue1)).isTrue();
        assertThat(bfsVertices.execute(graphTrue2)).isTrue();
        assertThat(bfsVertices.execute(graphTrue3)).isTrue();

        assertThat(bfsVertices.execute(graphFalse1)).isFalse();
        assertThat(bfsVertices.execute(graphFalse2)).isFalse();
        assertThat(bfsVertices.execute(graphFalse3)).isFalse();
        assertThat(bfsVertices.execute(graphFalse4)).isFalse();
        assertThat(bfsVertices.execute(graphFalse5)).isFalse();
        assertThat(bfsVertices.execute(graphFalse6)).isFalse();
        assertThat(bfsVertices.execute(graphFalse7)).isFalse();
        assertThat(bfsVertices.execute(graphFalse8)).isFalse();

    }
}
