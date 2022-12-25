package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;



public class TestMaximalMatching {
    @Test
    void testik() throws FileNotFoundException{
        Graph testGraph_1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph-01.txt"));
        Graph testGraph0 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph1.txt"));
        Graph testGraph1 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph2.txt"));
        Graph testGraph2 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph3.txt"));
        Graph testGraph3 = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph4.txt"));
        Graph testGraphV = GraphFactory.loadGraphFromFile(new File("src/test/resources/graph69.txt"));

        MaximalMatching test = new MaximalMatching();

        if (test.execute(testGraph_1) == 1){
            System.out.print((test.execute(testGraph_1) == 1) + " ");
            System.out.println(test.execute(testGraph_1));
        }
        if (test.execute(testGraph0) == 1){
            System.out.print((test.execute(testGraph0) == 1) + " ");
            System.out.println(test.execute(testGraph0));
        }
        if (test.execute(testGraph1) == 2){
            System.out.print((test.execute(testGraph1) == 2) + " ");
            System.out.println(test.execute(testGraph1));
        }
        if (test.execute(testGraph2) == 3){
            System.out.print((test.execute(testGraph2) == 3) + " ");
            System.out.println(test.execute(testGraph2));
        }
        if (test.execute(testGraph3) == 4){
            System.out.print((test.execute(testGraph3) == 4) + " ");
            System.out.println(test.execute(testGraph3));
        }

        if (test.execute(testGraphV) == 2){
            System.out.print((test.execute(testGraphV) == 2) + " ");
            System.out.println(test.execute(testGraphV));
        }

        }
}
