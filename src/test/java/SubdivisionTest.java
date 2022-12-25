import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.FileNotFoundException;
import java.io.File;

public class SubdivisionTest {
    @Test
    public void testSubdivision() throws FileNotFoundException {
        Graph testGraphTrue1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph1_true.txt"));
        Graph testGraphTrue2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph2_true.txt"));
        Graph testGraphTrue3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph3_true.txt"));
        Graph testGraphTrue4 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph4_true.txt"));
        Graph testGraphTrue5 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph5_true.txt"));

        Graph testGraphFalse1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph1_false.txt"));
        Graph testGraphFalse2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph2_false.txt"));
        Graph testGraphFalse3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph3_false.txt"));
        Graph testGraphFalse4 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph4_false.txt"));
        Graph testGraphFalse5 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph5_false.txt"));

        Graph testUndirectedGraphTrue1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph1undirected_true.txt"));
        Graph testUndirectedGraphTrue2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph2undirected_true.txt"));
        Graph testUndirectedGraphTrue3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph3undirected_true.txt"));
        Graph testUndirectedGraphTrue4 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph4undirected_true.txt"));
        Graph testUndirectedGraphTrue5 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph5undirected_true.txt"));
        
        Graph testUndirectedGraphFalse1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph1undirected_false.txt"));
        Graph testUndirectedGraphFalse2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph2undirected_false.txt"));
        Graph testUndirectedGraphFalse3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph3undirected_false.txt"));
        Graph testUndirectedGraphFalse4 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph4undirected_false.txt"));
        Graph testUndirectedGraphFalse5 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph5undirected_false.txt"));
        
        Subdivision subdivision = new Subdivision();
        
        assertThat(subdivision.execute(testGraphTrue1)).isTrue();
        assertThat(subdivision.execute(testGraphTrue2)).isTrue();
        assertThat(subdivision.execute(testGraphTrue3)).isTrue();
        assertThat(subdivision.execute(testGraphTrue4)).isTrue();
        assertThat(subdivision.execute(testGraphTrue5)).isTrue();
        
        assertThat(subdivision.execute(testGraphFalse1)).isFalse();
        assertThat(subdivision.execute(testGraphFalse2)).isFalse();
        assertThat(subdivision.execute(testGraphFalse3)).isFalse();
        assertThat(subdivision.execute(testGraphFalse4)).isFalse();
        assertThat(subdivision.execute(testGraphFalse5)).isFalse();
        
        assertThat(subdivision.execute(testUndirectedGraphTrue1)).isTrue();
        assertThat(subdivision.execute(testUndirectedGraphTrue2)).isTrue();
        assertThat(subdivision.execute(testUndirectedGraphTrue3)).isTrue();
        assertThat(subdivision.execute(testUndirectedGraphTrue4)).isTrue();
        assertThat(subdivision.execute(testUndirectedGraphTrue5)).isTrue();
        
        assertThat(subdivision.execute(testUndirectedGraphFalse1)).isFalse();
        assertThat(subdivision.execute(testUndirectedGraphFalse2)).isFalse();
        assertThat(subdivision.execute(testUndirectedGraphFalse3)).isFalse();
        assertThat(subdivision.execute(testUndirectedGraphFalse4)).isFalse();
        assertThat(subdivision.execute(testUndirectedGraphFalse5)).isFalse();
        
    }
}
