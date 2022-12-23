package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class AnyTwoNodesHaveCommonNeighbourTest {

    /*
      0 1 1
      1 0 1
      1 1 0

      marked - 1, 2
    */
    @Test
    void AnyTwoNodesHaveCommonNeighbour1() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/AnyTwoNodesHaveCommonNeighbour/testgraph1.txt"));

        AnyTwoNodesHaveCommonNeighbour AnyTwoNodesHaveCommonNeighbour = new AnyTwoNodesHaveCommonNeighbour();
        assertThat(AnyTwoNodesHaveCommonNeighbour.execute(testGraph)).isEqualTo(1);
    }

    /*
      0 1 1
      1 0 1
      1 1 0

      marked - 1, 2, 3
    */
    @Test
    void AnyTwoNodesHaveCommonNeighbour2() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/AnyTwoNodesHaveCommonNeighbour/testgraph2.txt"));

        AnyTwoNodesHaveCommonNeighbour AnyTwoNodesHaveCommonNeighbour = new AnyTwoNodesHaveCommonNeighbour();
        assertThat(AnyTwoNodesHaveCommonNeighbour.execute(testGraph)).isEqualTo(1);
    }

    /*
      0

      marked - 0
    */
    @Test
    void AnyTwoNodesHaveCommonNeighbour3() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/AnyTwoNodesHaveCommonNeighbour/testgraph3.txt"));

        AnyTwoNodesHaveCommonNeighbour AnyTwoNodesHaveCommonNeighbour = new AnyTwoNodesHaveCommonNeighbour();
        assertThat(AnyTwoNodesHaveCommonNeighbour.execute(testGraph)).isEqualTo(-1);
    }

    /*
      0 1 0 0
      1 0 1 0
      0 1 0 1
      0 0 1 0

      marked - 1, 4
    */
    @Test
    void AnyTwoNodesHaveCommonNeighbour4() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/AnyTwoNodesHaveCommonNeighbour/testgraph4.txt"));

        AnyTwoNodesHaveCommonNeighbour AnyTwoNodesHaveCommonNeighbour = new AnyTwoNodesHaveCommonNeighbour();
        assertThat(AnyTwoNodesHaveCommonNeighbour.execute(testGraph)).isEqualTo(1);
    }

    /*
      0 1 0 1 1 0
      0 0 1 1 0 0
      1 0 0 0 1 0
      0 0 1 0 0 0
      0 0 0 1 0 0
      1 0 0 1 1 0

      marked - 1, 5
    */
    @Test
    void AnyTwoNodesHaveCommonNeighbour5() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/AnyTwoNodesHaveCommonNeighbour/testgraph5.txt"));

        AnyTwoNodesHaveCommonNeighbour AnyTwoNodesHaveCommonNeighbour = new AnyTwoNodesHaveCommonNeighbour();
        assertThat(AnyTwoNodesHaveCommonNeighbour.execute(testGraph)).isEqualTo(2);
    }

    /*
      0 0 0
      1 0 1
      1 0 0

      marked - 1, 2
    */
    @Test
    void AnyTwoNodesHaveCommonNeighbour6() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/AnyTwoNodesHaveCommonNeighbour/testgraph6.txt"));

        AnyTwoNodesHaveCommonNeighbour AnyTwoNodesHaveCommonNeighbour = new AnyTwoNodesHaveCommonNeighbour();
        assertThat(AnyTwoNodesHaveCommonNeighbour.execute(testGraph)).isEqualTo(1);
    }

    /*
      0 1 0 0 1 0
      0 0 1 0 0 0
      0 0 0 0 0 1
      0 0 1 0 0 0
      0 0 0 1 0 1
      1 1 0 1 0 0

      marked - 3, 4
    */
    @Test
    void AnyTwoNodesHaveCommonNeighbour7() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/AnyTwoNodesHaveCommonNeighbour/testgraph7.txt"));

        AnyTwoNodesHaveCommonNeighbour AnyTwoNodesHaveCommonNeighbour = new AnyTwoNodesHaveCommonNeighbour();
        assertThat(AnyTwoNodesHaveCommonNeighbour.execute(testGraph)).isEqualTo(1);
    }

    /*
      0 1 0 0 0
      0 0 1 1 0
      0 0 0 0 1
      0 1 1 0 0
      1 1 0 1 0

      marked - 0, 2
    */
    @Test
    void AnyTwoNodesHaveCommonNeighbour8() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/AnyTwoNodesHaveCommonNeighbour/testgraph8.txt"));

        AnyTwoNodesHaveCommonNeighbour AnyTwoNodesHaveCommonNeighbour = new AnyTwoNodesHaveCommonNeighbour();
        assertThat(AnyTwoNodesHaveCommonNeighbour.execute(testGraph)).isEqualTo(2);
    }

    /*
      0 1 0 0
      0 0 1 1
      0 0 0 0
      1 0 1 0

      marked - 0, 2
    */
    @Test
    void AnyTwoNodesHaveCommonNeighbour9() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/AnyTwoNodesHaveCommonNeighbour/testgraph9.txt"));

        AnyTwoNodesHaveCommonNeighbour AnyTwoNodesHaveCommonNeighbour = new AnyTwoNodesHaveCommonNeighbour();
        assertThat(AnyTwoNodesHaveCommonNeighbour.execute(testGraph)).isEqualTo(2);
    }

    /*
      0 1 1 1
      1 0 1 1
      1 1 0 1
      1 1 1 0
      marked - 0, 2
    */
    @Test
    void AnyTwoNodesHaveCommonNeighbour10() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/AnyTwoNodesHaveCommonNeighbour/testgraph10.txt"));

        AnyTwoNodesHaveCommonNeighbour AnyTwoNodesHaveCommonNeighbour = new AnyTwoNodesHaveCommonNeighbour();
        assertThat(AnyTwoNodesHaveCommonNeighbour.execute(testGraph)).isEqualTo(2);
    }

}
