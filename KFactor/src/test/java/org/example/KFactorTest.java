package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.example.KFactor;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;

public class KFactorTest {
    @Test
    void Test1() throws FileNotFoundException{
        Graph testgraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/KFactorTest1.txt"));
        KFactor test = new KFactor();
        System.out.println(test.execute(testgraph));
    }
    @Test
    void Test2() throws FileNotFoundException{
        Graph testgraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/KFactorTest2.txt"));
        KFactor test = new KFactor();
        System.out.println(test.execute(testgraph));
    }
}

