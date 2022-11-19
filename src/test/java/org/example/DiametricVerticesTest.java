package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class DiametricVerticesTest {

    //    0 1
//    1 0
// marked - 0, 1
    @Test
    void shouldCheckDiametricalVertices1() throws FileNotFoundException {
        Graph testGraph1 = GraphFactory.loadGraphFromFile(new File("src/main/resources/testgraph1.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph1)).isEqualTo(true);
    }

    //    0 1 1
//    1 0 1
//    1 1 0
// marked - 0, 1, 2
    @Test
    void shouldCheckDiametricalVertices2() throws FileNotFoundException {
        Graph testGraph1 = GraphFactory.loadGraphFromFile(new File("src/main/resources/testgraph2.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph1)).isEqualTo(true);
    }

    //    0
// marked - 0
    @Test
    void shouldCheckDiametricalVertices3() throws FileNotFoundException {
        Graph testGraph1 = GraphFactory.loadGraphFromFile(new File("src/main/resources/testgraph3.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph1)).isEqualTo(false);
    }

    //    0 1 0 0
//    1 0 1 0
//    0 1 0 1
//    0 0 1 0
// marked - 0, 3
    @Test
    void shouldCheckDiametricalVertices4() throws FileNotFoundException {
        Graph testGraph1 = GraphFactory.loadGraphFromFile(new File("src/main/resources/testgraph4.txt"));

        DiametricVertices diametricVertices = new DiametricVertices();
        assertThat(diametricVertices.execute(testGraph1)).isEqualTo(false);
    }
}
