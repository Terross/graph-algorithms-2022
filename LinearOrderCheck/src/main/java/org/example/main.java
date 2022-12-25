package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import com.mathsystem.api.graph.GraphFactory;
import com.mathsystem.api.graph.model.Graph;

public class main {

	public static void main(String[] args) {
		Graph gr;
		LinearOrderCheck t = new LinearOrderCheck();
		
		try {
			gr = GraphFactory.loadGraphFromFile(new File("C:\\Users\\user\\Schastlivaya Chernikova\\src\\test\\resources\\lin.txt"));
			System.out.println(t.execute(gr));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
