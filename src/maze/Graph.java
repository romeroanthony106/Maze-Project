package maze;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Graph {
	private Node[][] nodes;				//all the nodes in a grid
	private Node start;					//(1,1)
	private Node end;					//(max_x,Max_y)
	private int max_x;
	private int max_y;
	private boolean isSolved;			//used in a recursive method
	private ArrayList<Node> visitedDiagonal = new ArrayList<Node>();
	private ArrayList<Node> visitedCardinal = new ArrayList<Node>();
	
	private Stack<Node>result = new Stack<Node>();
	
	public Graph(String maze) {
		super();
		this.isSolved = false;
		populateGraph(maze);
		
		
	
		
	}
	
	
	private void populateGraph(String maze) {
		String[] lines = maze.split("\n");
		int x = 0;
		int y = 0;
		this.max_x = lines[0].split(" ").length - 1;
		this.max_y = lines.length - 1;
		
		this.nodes = new Node[max_x + 2][max_y + 2];
		
		//next two loops read in and create all node objects
		for(int i = 0; i < lines.length; i++) {
			String[] currentLine = lines[i].split(" ");
 			for(int j = 0; j < currentLine.length; j++) {
 				boolean isRed = false;
 				int current = Integer.parseInt(currentLine[j]);
				if(current < 0) {
					isRed = true;
				}
				Node node = new Node(j+1,i+1,max_x, max_y, isRed, Math.abs(current));
				this.nodes[j][i] = node;
			}
		}
		
		this.start = this.nodes[0][0];
		this.end = this.nodes[max_x][max_y];
	}
	
	
	public void runGraph() {
		populateAdjacencies();
		this.result.push(this.start);
		runGraph(this.start, this.start.isRed());
		printResult();
		
	}
	
	private void populateAdjacencies() {
		for(int i = 0; i <= this.max_x; i ++) {
			for(int j = 0; j <= this.max_y; j++) {	//iterates through all nodes
				Node current = this.nodes[i][j];
				int distance = current.getDistance();	//adds all ajdacencies that exist for current node
				if(j + distance < this.max_y + 1) {
					current.addCardinal(this.nodes[i][j+distance]);
				}
				if(j - distance >= 0) {
					current.addCardinal(this.nodes[i][j - distance]);
				}
				if(i + distance < this.max_x + 1) {
					current.addCardinal(this.nodes[i + distance][j]);
				}
				if(i - distance >= 0) {
					current.addCardinal(this.nodes[i - distance][j]);
				}
				if(i - distance >=0 && j - distance >=0) {
					current.addDiagonal(this.nodes[i - distance][j - distance]);
				}
				if(i + distance < this.max_x + 1 && j + distance < this.max_y + 1) {
					current.addDiagonal(this.nodes[i + distance][j + distance]);
				}
				if(i - distance >= 0 && j + distance < this.max_y + 1) {
					current.addDiagonal(this.nodes[i - distance][j + distance]);
				}
				if(j - distance >= 0 && i + distance < this.max_x + 1) {
					current.addDiagonal(this.nodes[i + distance][j - distance]);
				}
			}
		}
	}
	
	private void runGraph(Node current, boolean redCurrent) {
		if(current == this.end) {
			this.isSolved = true;		//base case
			return;
		}
	
		else {
			ArrayList<Node>VisitedCurrent;
			if(redCurrent) {
				this.visitedDiagonal.add(current);
				
			}
			else {
				this.visitedCardinal.add(current);
			
			}
			
			ArrayList<Node>childTargets;
			if(current.isRed()) {
				redCurrent = !redCurrent;		//flips directionality if node is red
			}
			if(redCurrent) {
				childTargets = current.getNodesNextDiagonal();
				VisitedCurrent = this.visitedDiagonal;
			}
			else {
				childTargets = current.getNodesNextCardinal();
				VisitedCurrent = this.visitedCardinal;
			}
			
			
		
			for(int i = 0; i < childTargets.size(); i++) {
				if(this.isSolved) {
					return;
				}
				else {
					Node next = childTargets.get(i);
					if(!VisitedCurrent.contains(next)) {
						this.result.push(next);
						runGraph(next, redCurrent);
						if(!this.isSolved) {
							this.result.pop();
						}
					}
					
				}
			}
			return;
		}
	}
	
	private void printResult() {
		if(this.isSolved) {
			String result = "";
			while(!this.result.isEmpty()) {
				Node current = this.result.pop();
				result = current.print() + result;
				
			}
			System.out.print(result);
		}
		else {
			System.out.print("no solution");
		}
	}
}

