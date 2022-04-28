package maze;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test1 = "1 4 5 21 -2\n"
					 + "2 1 -1 -3 -1\n"
					 + "2 1 -4 1 6";
		
		
		
		String test = "4 2 -2 4 4 -3 4 -3\n"
					+ "3 5 3 4 2 3 5 -2\n"
					+ "4 3 2 -5 2 2 5 2\n"
					+ "7 1 4 4 4 2 2 3\n"
					+ "-3 2 2 4 2 5 2 5\n"
					+ "2 -3 2 4 4 2 5 -1\n"
					+ "6 2 2 -3 2 5 6 3\n"
					+ "1 -2 5 4 4 2 -1 0\n";
				
		
		
		Graph graph = new Graph(test);
		graph.runGraph();
		System.out.print("\n");
		
		
		//do a thing
	}

}
