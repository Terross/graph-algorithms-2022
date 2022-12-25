package org.module;

import com.mathsystem.api.graph.GraphFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileNotFoundException;

class LenMinCycleUndirectedTest {

    @Test
    void TestLenMinCycleUndirected() throws FileNotFoundException
    {
        LenMinCycleUndirected lenMinCycleUndirectModule = new LenMinCycleUndirected();

        File graph = new File("src/test/resources/Test1_3.txt");
        Assertions.assertEquals(3,
                lenMinCycleUndirectModule.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/Test2_4.txt");
        Assertions.assertEquals(4,
                lenMinCycleUndirectModule.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/Test3_6.txt");
        Assertions.assertEquals(6,
                lenMinCycleUndirectModule.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/Test4_3.txt");
        Assertions.assertEquals(3,
                lenMinCycleUndirectModule.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/Test5_0.txt");
        Assertions.assertEquals(0,
                lenMinCycleUndirectModule.execute(GraphFactory.loadGraphFromFile(graph)));
    }
}