import com.mathsystem.api.graph.model.Graph;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;

public class SomeModule implements GraphProperty {
    @Override
    public boolean execute(Graph graph) {
        return false;
    }
}
