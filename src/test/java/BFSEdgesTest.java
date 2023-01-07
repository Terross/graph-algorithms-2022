import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BFSEdgesTest {
    @Test
    public void testBFSEdges() throws FileNotFoundException {
        Graph graphTrue1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graphTrue.txt"));
        Graph graphTrue2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graph_1_true.txt"));
        Graph graphTrue3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graph_2_true.txt"));
        Graph graphTrue4 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graph_3_true.txt"));
        Graph graphTrue5 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graph_4_true.txt"));
        Graph graphTrue6 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graph_5_true.txt"));

        Graph graphFalse1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graphFalse.txt"));
        Graph graphFalse2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graph_1_false.txt"));
        Graph graphFalse3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graph_2_false.txt"));
        Graph graphFalse4 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graph_3_false.txt"));
        Graph graphFalse5 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graph_4_false.txt"));
        Graph graphFalse6 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graph_empty.txt"));
        Graph graphFalse7 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graph_not_connective.txt"));
        Graph graphFalse8 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/bfsEdges/graph_one_vert.txt"));


        BFSEdges bfsEdges = new BFSEdges();

        assertThat(bfsEdges.execute(graphTrue1)).isTrue();
        assertThat(bfsEdges.execute(graphTrue2)).isTrue();
        assertThat(bfsEdges.execute(graphTrue3)).isTrue();
        assertThat(bfsEdges.execute(graphTrue4)).isTrue();
        assertThat(bfsEdges.execute(graphTrue5)).isTrue();
        assertThat(bfsEdges.execute(graphTrue6)).isTrue();

        assertThat(bfsEdges.execute(graphFalse1)).isFalse();
        assertThat(bfsEdges.execute(graphFalse2)).isFalse();
        assertThat(bfsEdges.execute(graphFalse3)).isFalse();
        assertThat(bfsEdges.execute(graphFalse4)).isFalse();
        assertThat(bfsEdges.execute(graphFalse5)).isFalse();
        assertThat(bfsEdges.execute(graphFalse6)).isFalse();
        assertThat(bfsEdges.execute(graphFalse7)).isFalse();
        assertThat(bfsEdges.execute(graphFalse8)).isFalse();

    }
}
