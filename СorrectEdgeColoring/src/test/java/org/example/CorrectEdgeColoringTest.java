package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;


public class CorrectEdgeColoringTest {
    /*
      0 1
      1 0
    */
    @Test
    void EdgeColoringTest1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test1.txt"));

        CorrectEdgeColoring correctEdgeColoring = new CorrectEdgeColoring();
        assertThat(correctEdgeColoring.execute(testGraph)).isEqualTo(true);
    }

    /*
    0 1 1
    1 0 1
    1 1 0
    */
    @Test
    void EdgeColoringTest2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test2.txt"));

        CorrectEdgeColoring correctEdgeColoring = new CorrectEdgeColoring();
        assertThat(correctEdgeColoring.execute(testGraph)).isEqualTo(false);
    }
    /*
      0
    */
    @Test
    void EdgeColoringTest3() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test3.txt"));

        CorrectEdgeColoring correctEdgeColoring = new CorrectEdgeColoring();
        assertThat(correctEdgeColoring.execute(testGraph)).isEqualTo(true);
    }
    /*
      0 1 0 0
      1 0 1 0
      0 1 0 1
      0 0 1 0
    */
    @Test
    void EdgeColoringTest4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test4.txt"));

        CorrectEdgeColoring correctEdgeColoring = new CorrectEdgeColoring();
        assertThat(correctEdgeColoring.execute(testGraph)).isEqualTo(true);
    }
    /*
      0 1 0 1 1 0
      0 0 1 1 0 0
      1 0 0 0 1 0
      0 0 1 0 0 0
      0 0 0 1 0 0
      1 0 0 1 1 0
    */
    @Test
    void EdgeColoringTest5() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test5.txt"));

        CorrectEdgeColoring correctEdgeColoring = new CorrectEdgeColoring();
        assertThat(correctEdgeColoring.execute(testGraph)).isEqualTo(true);
    }

    /*
      0 0 0
      1 0 1
      1 0 0
    */

    @Test
    void EdgeColoringTest6() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test6.txt"));

        CorrectEdgeColoring correctEdgeColoring = new CorrectEdgeColoring();
        assertThat(correctEdgeColoring.execute(testGraph)).isEqualTo(false);
    }

    /*
      0 1 0 1 0 1
      1 0 1 1 0 0
      0 1 0 1 1 0
      1 1 1 0 1 1
      0 0 1 1 0 1
      1 0 0 1 1 0
        */
    @Test
    void EdgeColoringTest7() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test7.txt"));

        CorrectEdgeColoring correctEdgeColoring = new CorrectEdgeColoring();
        assertThat(correctEdgeColoring.execute(testGraph)).isEqualTo(true);
    }

    /*
      0 1 0 0 0
      0 0 1 1 0
      0 0 0 0 1
      0 1 1 0 0
      1 1 0 1 0
    */
    @Test
    void EdgeColoringTest8() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test8.txt"));

        CorrectEdgeColoring correctEdgeColoring = new CorrectEdgeColoring();
        assertThat(correctEdgeColoring.execute(testGraph)).isEqualTo(true);
    }

    /*
      0 1 0 0
      0 0 1 1
      0 0 0 0
      1 0 1 0
    */
    @Test
    void EdgeColoringTest9() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test9.txt"));

        CorrectEdgeColoring correctEdgeColoring = new CorrectEdgeColoring();
        assertThat(correctEdgeColoring.execute(testGraph)).isEqualTo(false);
    }

    /*
          0 1 0
          1 0 1
          0 1 0
        */
    @Test
    void EdgeColoringTest10() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test10.txt"));

        CorrectEdgeColoring correctEdgeColoring = new CorrectEdgeColoring();
        assertThat(correctEdgeColoring.execute(testGraph)).isEqualTo(true);
    }

    /*
     */
    @Test
    void EdgeColoringTest11() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test11.txt"));

        CorrectEdgeColoring correctEdgeColoring = new CorrectEdgeColoring();
        assertThat(correctEdgeColoring.execute(testGraph)).isEqualTo(true);
    }

    /*
          0 1 0 0 0 1 0
          0 0 1 0 0 0 0
          0 0 0 1 0 0 0
          0 0 1 0 0 0 1
          0 0 0 1 0 0 0
          1 0 0 0 1 0 0
          0 0 1 0 0 1 0
         */
    @Test
    void EdgeColoringTest12() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/test12.txt"));

        CorrectEdgeColoring correctEdgeColoring = new CorrectEdgeColoring();
        assertThat(correctEdgeColoring.execute(testGraph)).isEqualTo(false);
    }
}