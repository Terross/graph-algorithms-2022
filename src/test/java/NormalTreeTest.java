import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.FileNotFoundException;
import java.io.File;

public class NormalTreeTest {
    @Test
    public void testNormalTree() throws FileNotFoundException {
        Graph testGraphTrue1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/normalTree/graph1_True.txt"));
        Graph testGraphTrue2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/normalTree/graph2_True.txt"));
        Graph testGraphTrue3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/normalTree/graph3_True.txt"));
        Graph testGraphTrue4 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/normalTree/graph4_True.txt"));
        Graph testGraphTrue5 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/normalTree/graph5_True.txt"));

        Graph testGraphFalse1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/normalTree/graph1_False.txt"));
        Graph testGraphFalse2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/normalTree/graph2_False.txt"));
        Graph testGraphFalse3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/normalTree/graph3_False.txt"));
        Graph testGraphFalse4 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/normalTree/graph4_False.txt"));
        Graph testGraphFalse5 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/normalTree/graph5_False.txt"));

        NormalTree normalTree = new NormalTree();

        //System.out.printf("testGraphTrue1: %s ", normalTree.execute(testGraphTrue1));
        //System.out.printf("\n");
        //System.out.printf("testGraphTrue2: %s ", normalTree.execute(testGraphTrue2));
        //System.out.printf("\n");
        //System.out.printf("testGraphTrue3: %s ", normalTree.execute(testGraphTrue3));
        //System.out.printf("\n");
        //System.out.printf("testGraphTrue4: %s ", normalTree.execute(testGraphTrue4));
        //System.out.printf("\n");
        //System.out.printf("testGraphTrue5: %s ", normalTree.execute(testGraphTrue5));
        //System.out.printf("\n");

        //System.out.printf("testGraphFalse1: %s ", normalTree.execute(testGraphFalse1));
        //System.out.printf("\n");
        //System.out.printf("testGraphFalse2: %s ", normalTree.execute(testGraphFalse2));
        //System.out.printf("\n");
        //System.out.printf("testGraphFalse3: %s ", normalTree.execute(testGraphFalse3));
        //System.out.printf("\n");
        //System.out.printf("testGraphFalse4: %s ", normalTree.execute(testGraphFalse4));
        //System.out.printf("\n");
        //System.out.printf("testGraphFalse5: %s ", normalTree.execute(testGraphFalse5));
        //System.out.printf("\n");

        assertThat(normalTree.execute(testGraphTrue1)).isTrue();
        assertThat(normalTree.execute(testGraphTrue2)).isTrue();
        assertThat(normalTree.execute(testGraphTrue3)).isTrue();
        assertThat(normalTree.execute(testGraphTrue4)).isTrue();
        assertThat(normalTree.execute(testGraphTrue5)).isTrue();
        assertThat(normalTree.execute(testGraphFalse1)).isFalse();
        assertThat(normalTree.execute(testGraphFalse2)).isFalse();
        assertThat(normalTree.execute(testGraphFalse3)).isFalse();
        assertThat(normalTree.execute(testGraphFalse4)).isFalse();
        assertThat(normalTree.execute(testGraphFalse5)).isFalse();
    }
}