package org.example;

import com.mathsystem.api.graph.GraphFactory;

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        DiametricVertices diametricVertices = new DiametricVertices();
        System.out.println(diametricVertices.
                execute(GraphFactory.loadGraphFromFile(
                        new File("src/main/resources/testgraph4.txt"))));
    }
}