package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("./intput.txt");	//opens file
		Scanner s = new Scanner(file);
		s.nextLine();
		String input = "";
		while(s.hasNextLine()){			
			input = input + s.nextLine();		//reads file
		}
		Graph graph = new Graph(input);			//setup and run graph
		graph.runGraph();
	}

}
