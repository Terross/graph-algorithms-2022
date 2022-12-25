package org.module;

import com.mathsystem.api.graph.GraphFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class IsK5InGraphTest {

    @Test
    void TestK5Module() throws FileNotFoundException {
        IsK5InGraph k5Module = new IsK5InGraph();

        File graph = new File("src/test/resources/TEST8_True.txt");
        Assertions.assertTrue(k5Module.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/TEST2_False.txt");
        Assertions.assertFalse(k5Module.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/TEST3_True.txt");
        Assertions.assertTrue(k5Module.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/TEST4_True.txt");
        Assertions.assertTrue(k5Module.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/TEST5_False.txt");
        Assertions.assertFalse(k5Module.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/TEST6_False.txt");
        Assertions.assertFalse(k5Module.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/TEST7_True.txt");
        Assertions.assertTrue(k5Module.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/TEST1_True.txt");
        Assertions.assertTrue(k5Module.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/TEST9_False.txt");
        Assertions.assertFalse(k5Module.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/TEST10_True.txt");
        Assertions.assertTrue(k5Module.execute(GraphFactory.loadGraphFromFile(graph)));
    }
}