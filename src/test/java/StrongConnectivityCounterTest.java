import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StrongConnectivityCounterTest {
    @Test
    public void testStrongConnectivityCounter() throws FileNotFoundException {
        Graph testGraph1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/strongConnectivityCounter/graph 1.txt"));
        Graph testGraph2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/strongConnectivityCounter/graph 2.txt"));
        Graph testGraph3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/strongConnectivityCounter/graph 3.txt"));

        Graph testGraph4 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/strongConnectivityCounter/tree 1.txt"));
        Graph testGraph5 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/strongConnectivityCounter/tree 2.txt"));
        Graph testGraph6 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/strongConnectivityCounter/tree 3.txt"));

        Graph testGraph7 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/strongConnectivityCounter/graph 4.txt"));
        Graph testGraph8 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/strongConnectivityCounter/graph 5.txt"));

        StrongConnectivityCounter strongConnectivityCounter = new StrongConnectivityCounter();

        assertThat(strongConnectivityCounter.execute(testGraph1)).isEqualTo(9);
        assertThat(strongConnectivityCounter.execute(testGraph2)).isEqualTo(7);
        assertThat(strongConnectivityCounter.execute(testGraph3)).isEqualTo(11);
        assertThat(strongConnectivityCounter.execute(testGraph4)).isEqualTo(8);
        assertThat(strongConnectivityCounter.execute(testGraph5)).isEqualTo(7);
        assertThat(strongConnectivityCounter.execute(testGraph6)).isEqualTo(0);
        assertThat(strongConnectivityCounter.execute(testGraph7)).isEqualTo(1);
        assertThat(strongConnectivityCounter.execute(testGraph8)).isEqualTo(1);
    }
}
