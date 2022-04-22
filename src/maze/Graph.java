package maze;

import java.util.ArrayList;

public class Graph {
	private Node[][] nodes;
	private Node start;
	private Node end;
	private int max_x;
	private int max_y;
	
	
	
	public Graph(String maze) {
		super();
		populateGraph(maze);
		
	
		
	}
	
	
	private void populateGraph(String maze) {
		String[] lines = maze.split("\n");
		int x = 0;
		int y = 0;
		this.max_x = lines[0].split(" ").length - 1;
		this.max_y = lines.length - 1;
		
		this.nodes = new Node[max_x + 1][max_y + 1];
		
		
		for(int i = 0; i < lines.length; i++) {
			String[] currentLine = lines[i].split(" ");
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
		
		this.start = this.nodes[0][0];
		this.end = this.nodes[max_x][max_y];
	}
	
	
	public void runGraph() {
		populateAdjacencies();
	}
	
	private void populateAdjacencies() {
		for(int i = 0; i < this.max_x - 1; i ++) {
			for(int j = 0; i < this.max_y - 1; j++) {
				Node current = this.nodes[i][j];
				if(j - current.getDistance() >= 0) {
					current.addCardinal(this.nodes[i][j - current.getDistance()]);
				}
				if(j + current.getDistance() < this.max_x) {
					current.addCardinal(this.nodes[i][j+current.getDistance()]);
				}
				if(i - current.getDistance() >= 0) {
					current.addCardinal(this.nodes[i - current.getDistance()][j]);
				}
				if(i + current.getDistance() < this.max_y) {
					current.addCardinal(this.nodes[i + current.getDistance()][j]);
				}
			}
		}
	}
}

