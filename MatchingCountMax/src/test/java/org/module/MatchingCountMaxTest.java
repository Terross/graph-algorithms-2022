package org.module;

import com.mathsystem.api.graph.GraphFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class MatchingCountMaxTest {

    @Test
    void TestMatchingCountMax() throws FileNotFoundException {
        MatchingCountMax matchingRandomMaxModule = new MatchingCountMax();

        File graph = new File("src/test/resources/Test1_3.txt");
        Assertions.assertEquals(3,
                matchingRandomMaxModule.execute(GraphFactory.loadGraphFromFile(graph)));
        graph = new File("src/test/resources/Test2_4.txt");
        Assertions.assertEquals(4,
                matchingRandomMaxModule.execute(GraphFactory.loadGraphFromFile(graph)));
        graph = new File("src/test/resources/Test3_2.txt");
        Assertions.assertEquals(2,
                matchingRandomMaxModule.execute(GraphFactory.loadGraphFromFile(graph)));
        graph = new File("src/test/resources/Test4_3.txt");
        Assertions.assertEquals(3,
                matchingRandomMaxModule.execute(GraphFactory.loadGraphFromFile(graph)));
        graph = new File("src/test/resources/Test5_6.txt");
        Assertions.assertEquals(6,
                matchingRandomMaxModule.execute(GraphFactory.loadGraphFromFile(graph)));
    }
}