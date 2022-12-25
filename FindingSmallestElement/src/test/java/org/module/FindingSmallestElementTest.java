package org.module;

import com.mathsystem.api.graph.GraphFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class FindingSmallestElementTest {

    @Test
    void TestFindingSmallestElementModule() throws FileNotFoundException {
        FindingSmallestElement findingSmallestElement = new FindingSmallestElement();

        File graph = new File("src/test/resources/Test1_True.txt");
        Assertions.assertTrue(findingSmallestElement.execute(GraphFactory.loadGraphFromFile(graph)));
        graph = new File("src/test/resources/Test2_False.txt");
        Assertions.assertFalse(findingSmallestElement.execute(GraphFactory.loadGraphFromFile(graph)));
        graph = new File("src/test/resources/Test3_True.txt");
        Assertions.assertTrue(findingSmallestElement.execute(GraphFactory.loadGraphFromFile(graph)));
        graph = new File("src/test/resources/Test4_False.txt");
        Assertions.assertFalse(findingSmallestElement.execute(GraphFactory.loadGraphFromFile(graph)));
    }
}
