package org.example;

import java.io.File;
import java.io.FileNotFoundException;

import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;

public class main {

	public static void main(String[] args) {
		Graph gr;
		dvudol.GraphDvudol t = new dvudol.GraphDvudol();
		
		try {
			gr = GraphFactory.loadGraphFromFile(new File("src\\main\\resources\\graph (net3).txt")); //считываем граф из файла
			System.out.println(t.execute(gr));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
