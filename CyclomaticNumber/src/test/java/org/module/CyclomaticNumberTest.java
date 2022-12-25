package org.module;

import com.mathsystem.api.graph.GraphFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileNotFoundException;

class CyclomaticNumberTest {

    @Test
    void TestCyclomaticNumber() throws FileNotFoundException {
        CyclomaticNumber cyclomaticNumber = new CyclomaticNumber();

        //UNDIRECTED TESTS

        File graph = new File("src/test/resources/Test1_3.txt");
        Assertions.assertEquals(3,
                cyclomaticNumber.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/Test2_7.txt");
        Assertions.assertEquals(7,
                cyclomaticNumber.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/Test3_0.txt");
        Assertions.assertEquals(0,
                cyclomaticNumber.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/Test4_0.txt");
        Assertions.assertEquals(0,
                cyclomaticNumber.execute(GraphFactory.loadGraphFromFile(graph)));

        graph = new File("src/test/resources/Test5_13.txt");
        Assertions.assertEquals(13,
                cyclomaticNumber.execute(GraphFactory.loadGraphFromFile(graph)));
    }
}