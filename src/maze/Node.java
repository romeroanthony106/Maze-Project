package maze;

import java.util.ArrayList;


public class Node {
	private int x;
	private int y;
	
	private int max_x;
	private int max_y;
	
	private boolean isRedCircle;
	
	private int distance;
	
	private ArrayList<Node> nodesNextDiagonal = new ArrayList<>();
	private ArrayList<Node> nodesNextCardinal = new ArrayList<>();
	
	
	public Node(int x, int y, int max_x, int max_y, boolean isRedCircle, int distance) {
		super();
		this.x = x;
		this.y = y;
		this.max_x = max_x;
		this.max_y = max_y;
		this.isRedCircle = isRedCircle;
		this.distance = distance;
	}
	
	
	public void addDiagonal (Node node) {
		this.nodesNextDiagonal.add(node);
	}
	
	public void addCardinal (Node node) {
		this.nodesNextCardinal.add(node);
	}


	public ArrayList<Node> getNodesNextDiagonal() {
		return nodesNextDiagonal;
	}


	public ArrayList<Node> getNodesNextCardinal() {
		return nodesNextCardinal;
	}
	
	
	
	
	
	
}
