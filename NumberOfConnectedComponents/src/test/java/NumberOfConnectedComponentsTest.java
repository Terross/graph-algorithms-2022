import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;

public class NumberOfConnectedComponentsTest {
    @Test
    void NumberOfConnectedComponents() throws FileNotFoundException {
        Graph graph;
        NumberOfConnectedComponents components = new NumberOfConnectedComponents();
        int[] expectedAnswers = {2, 4, 2, 3, 4, 3, 1, 4, 2, 2, 3, 2, 4, 3, 1, 2};
        for (int i = 0; i < expectedAnswers.length; i++) {
            graph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph" + (i+1) + ".txt"));
            int res = components.execute(graph);
            if (res != expectedAnswers[i]) {
                System.out.println("Error in test #" + (i+1));
                System.out.println("Expected: " + expectedAnswers[i] + " Got: " + res);
            } else {
                System.out.println("Test #" + (i+1) + " passed. Answer: " + res);
            }
        }
    }
}
