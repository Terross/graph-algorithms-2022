package org.module;

import com.mathsystem.api.graph.GraphFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class LenMinCycleDirectedTest {

    @Test
    void TestLenMinCycleDirectModule() throws FileNotFoundException {
        LenMinCycleDirected lenMinCycleDirectModule = new LenMinCycleDirected();

        File graph = new File("src/test/resources/test1_answer_3.txt");
        Assertions.assertEquals(3,
                lenMinCycleDirectModule.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/test2_answer_4.txt");
        Assertions.assertEquals(4,
                lenMinCycleDirectModule.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/test3_answer_7.txt");
        Assertions.assertEquals(7,
                lenMinCycleDirectModule.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/test4_answer_0.txt");
        Assertions.assertEquals(0,
                lenMinCycleDirectModule.execute(GraphFactory.loadGraphFromFile(graph)));
    }
}