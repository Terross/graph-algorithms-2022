package org.example;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;


public class RightEuclideanRelationTest
{
    @Test
    void shouldCheckRightEuclideanRelationOnEmptyGraph() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph1.txt"));

        RightEuclideanRelation rightEuclideanRelation = new RightEuclideanRelation();
        assertThat(rightEuclideanRelation.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void shouldCheckRightEuclideanRelationOnGraphWithoutEdges() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph2.txt"));

        RightEuclideanRelation rightEuclideanRelation = new RightEuclideanRelation();
        assertThat(rightEuclideanRelation.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void shouldCheckRightEuclideanRelationOnCompleteGraphOn3Vertexes() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph3.txt"));

        RightEuclideanRelation rightEuclideanRelation = new RightEuclideanRelation();
        assertThat(rightEuclideanRelation.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void shouldCheckRightEuclideanRelationOnGraphWithoutRightEuclideanRelation() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph4.txt"));

        RightEuclideanRelation rightEuclideanRelation = new RightEuclideanRelation();
        assertThat(rightEuclideanRelation.execute(testGraph)).isEqualTo(false);
    }
    @Test
    void shouldCheckRightEuclideanRelationOnGraphWithRightEuclideanRelation() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph5.txt"));

        RightEuclideanRelation rightEuclideanRelation = new RightEuclideanRelation();
        assertThat(rightEuclideanRelation.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void shouldCheckRightEuclideanRelationOnGraphWithTransitivityAndWithoutRightEuclideanRelation() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph6.txt"));

        RightEuclideanRelation rightEuclideanRelation = new RightEuclideanRelation();
        assertThat(rightEuclideanRelation.execute(testGraph)).isEqualTo(false);
    }
    @Test
    void shouldCheckRightEuclideanRelationOnGraphWithRightEuclideanRelationAndWithoutTransitivity() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph7.txt"));

        RightEuclideanRelation rightEuclideanRelation = new RightEuclideanRelation();
        assertThat(rightEuclideanRelation.execute(testGraph)).isEqualTo(true);
    }
    @Test
    void shouldCheckRightEuclideanRelationOnGraphWith4VertexesAndWithoutRightEuclideanRelation() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph8.txt"));

        RightEuclideanRelation rightEuclideanRelation = new RightEuclideanRelation();
        assertThat(rightEuclideanRelation.execute(testGraph)).isEqualTo(false);
    }
    @Test
    void shouldCheckRightEuclideanRelationOnGraphWith4VertexesAndWithRightEuclideanRelation() throws FileNotFoundException {
        Graph testGraph = GraphFactory.loadGraphFromFile(new File("src/test/resources/testgraph9.txt"));

        RightEuclideanRelation rightEuclideanRelation = new RightEuclideanRelation();
        assertThat(rightEuclideanRelation.execute(testGraph)).isEqualTo(true);
    }

}