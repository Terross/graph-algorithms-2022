import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.FileNotFoundException;
import java.io.File;

public class SubdivisionTest {
    @Test
    public void testSubdivision() throws FileNotFoundException {
        Graph testGraphTrue1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph1_True.txt"));
        Graph testGraphTrue2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph2_True.txt"));
        Graph testGraphTrue3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph3_True.txt"));
        Graph testGraphTrue4 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph4_True.txt"));
        Graph testGraphTrue5 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph5_True.txt"));

        Graph testGraphFalse1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph1_False.txt"));
        Graph testGraphFalse2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph2_False.txt"));
        Graph testGraphFalse3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph3_False.txt"));
        Graph testGraphFalse4 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph4_False.txt"));
        Graph testGraphFalse5 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/subdivision/graph5_False.txt"));

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
    }
}
