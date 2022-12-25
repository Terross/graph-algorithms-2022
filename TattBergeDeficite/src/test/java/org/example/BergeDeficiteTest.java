package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;

public class BergeDeficiteTest {
    @Test
    void BergeTest() throws FileNotFoundException {
        Graph graph;
        DeficiteByTattBerge tatt = new DeficiteByTattBerge();
        //BergeDeficite tatt = new BergeDeficite();
        int[] expectedAnswers = {0, 1, 0, 1, 0, 1, 100, 1000};
        for (int i = 0; i < expectedAnswers.length; i++) {
            graph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Berge" + i + ".txt"));
            int res = tatt.execute(graph);
            if (res != expectedAnswers[i]) {
                System.out.println("Error in test #" + i);
                System.out.println("Expected: " + expectedAnswers[i] + " Got: " + res);
            } else {
                System.out.println("Test #" + i + " passed. Answer: " + res);
            }
        }
    }

    @Test
    void BergeBenchmark() throws FileNotFoundException {
        Graph graph;
        //DeficiteByTatt tatt = new DeficiteByTatt();
        BergeDeficite std = new BergeDeficite();
        int[] expectedAnswers = {100, 98, 1000, 0};
        for (int i = 0; i < expectedAnswers.length; i++) {
            graph = GraphFactory.loadGraphFromFile(new File("src/test/resources/Bench" + i + ".txt"));
            long start = System.nanoTime();
            int res = std.execute(graph);
            long end = System.nanoTime();
            if (res != expectedAnswers[i]) {
                System.out.println("Error in test #" + i);
                System.out.println("Expected: " + expectedAnswers[i] + " Got: " + res);
                System.out.println("Time elapsed: " + (end - start) + "ns");
            } else {
                System.out.println("Test #" + i + " passed. Answer: " + res);
                System.out.println("Time elapsed: " + (end - start) + "ns");
            }
        }
    }
}