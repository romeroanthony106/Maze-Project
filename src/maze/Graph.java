package maze;

import java.util.ArrayList;

public class Graph {
	private Node[][] nodes;
	private Node start;
	private Node end;
	
	
	
	
	public Graph(String maze) {
		super();
		populateGraph(maze);
		
	
		
	}
	
	
	private void populateGraph(String maze) {
		String[] lines = maze.split("\n");
		int x = 0;
		int y = 0;
		int max_x = lines[0].split(" ").length;
		int max_y = lines.length;
		
		this.nodes = new Node[max_x][max_y];
		
		
		for(int i = 0; i < lines.length; i++) {
			String[] currentLine = lines[i].split(" ");
			max_x = currentLine.length;
 			for(int j = 0; j < currentLine.length; j++) {
 				boolean isRed = false;
 				int current = Integer.parseInt(currentLine[j]);
				if(current < 0) {
					isRed = true;
				}
				Node node = new Node(i,j,max_x, max_y, isRed, Math.abs(current));
				this.nodes[i][j] = node;
			}
		}
	}
	
}
