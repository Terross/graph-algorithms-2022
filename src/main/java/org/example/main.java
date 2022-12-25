package org.example;

import java.io.File;
import java.io.FileNotFoundException;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;

public class main {

	public static void main(String[] args) {
		Graph gr;
		GraphTranzit t = new GraphTranzit();
		
		try {
			gr = GraphFactory.loadGraphFromFile(new File("src\\main\\resources\\test1.txt")); //считываем граф из файла
			System.out.println(t.execute(gr));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
