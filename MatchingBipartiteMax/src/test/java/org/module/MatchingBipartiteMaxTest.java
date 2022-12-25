package org.module;

import com.mathsystem.api.graph.GraphFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class MatchingBipartiteMaxTest {

    @Test
    void TestMatchingBipartiteMax() throws FileNotFoundException {
        MatchingBipartiteMax matchingBipartiteMaxModule = new MatchingBipartiteMax();

        File graph = new File("src/test/resources/Test1_True.txt");
        Assertions.assertEquals(true,
                matchingBipartiteMaxModule.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/Test2_True.txt");
        Assertions.assertEquals(true,
                matchingBipartiteMaxModule.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/Test3_False.txt");
        Assertions.assertEquals(false,
                matchingBipartiteMaxModule.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/Test4_False.txt");
        Assertions.assertEquals(false,
                matchingBipartiteMaxModule.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/Test5_True.txt");
        Assertions.assertEquals(true,
                matchingBipartiteMaxModule.execute(GraphFactory.loadGraphFromFile(graph)));
    }
}