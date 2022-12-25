import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.example.Factor_crtical;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;

public class FactorCriticalTest {

    @Test
    void Test1() throws FileNotFoundException{
        Graph testgraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph (6).txt"));
        Factor_crtical test = new Factor_crtical();
        System.out.println(test.execute(testgraph));
    }
    @Test
    void Test2() throws FileNotFoundException{
        Graph testgraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph (8).txt"));
        Factor_crtical test = new Factor_crtical();
        System.out.println(test.execute(testgraph));
    }
}
