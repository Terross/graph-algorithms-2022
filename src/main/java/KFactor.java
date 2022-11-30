import com.mathsystem.domain.graph.repository.Color;
import com.mathsystem.domain.plugin.plugintype.GraphProperty;
import com.mathsystem.api.graph.oldmodel.AbstractGraph;
import com.mathsystem.api.graph.oldmodel.Vertex;
import com.mathsystem.api.graph.oldmodel.AbstractEdge;
import java.util.List;

public abstract class KFactor implements GraphProperty {
    public boolean execute(AbstractGraph graph){
        List<Vertex> vertices = graph.getVertices();
        List<AbstractEdge> edges;
        int k=0,k1;
        for (int i=0;i<graph.getVertexCount();i++){
            k1=0;
            edges=(vertices.get(i)).getEdgeList();
            for (int j=0;j< edges.size();j++){
                if ((edges.get(j).getColor()!= Color.gray)){
                    k1+=1;
                }
            }
            if (k==0) k=k1;
            else if(k!=k1) return false;
        }
        return true;
    }
}