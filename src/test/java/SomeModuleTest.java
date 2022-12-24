
import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SomeModuleTest {
    @Test
    public void testSomeModule() throws FileNotFoundException {
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graphs/someModule/testGraph_1.txt"));

        SomeModule someModule = new SomeModule();
        // assertThat(*результат вашего модуля над тестовыми графами*).isEqualTo(*ожидаемый результат*);
        assertThat(someModule.execute(testGraph_1)).isFalse(); // пример
        // assertThat(someModule.execute(testGraph_2)).isFalse();
        // assertThat(3).isEqualTo(3);
        // assertThat(3).isEqualTo(4); <- тест упадет
    }
}
