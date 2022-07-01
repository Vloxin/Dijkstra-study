package application;

import java.util.ArrayList;

class DijkstrasAlgorithm {
//O((V+E)logV) using adjacency list
//This version without a priority queue can not handle negative weight edges. It only visits each graph vertex once. After a vertex is coloured, it is never visited again
	public static Boolean print_results = false;
	
	private static final int NO_PARENT = -1;
	public static int[] shortestDistances;// result
	
	public static ArrayList<ArrayList<Integer>> paths;

	public static void dijkstra(int[][] adjacencyMatrix, int startVertex) {
		int nVertices = adjacencyMatrix[0].length;

		// shortestDistances[i] will hold the shortest distance from src to i

		shortestDistances = new int[nVertices];

		// visted[i] will true if vertex i is
		// included / in shortest path tree
		// or shortest distance from src to
		// i is finalized

		// ---------------------STEP 2--------------------------
		boolean[] VISTED = new boolean[nVertices];

		// --------------------STEP 3-------------------------

		// Initialize all distances as
		// INFINITE and visted[] as false
		for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
			shortestDistances[vertexIndex] = Integer.MAX_VALUE;
			VISTED[vertexIndex] = false;
		}

		// Distance of source vertex from
		// itself is always 0

		shortestDistances[startVertex] = 0;

		// Parent array to store shortest
		// path tree
		int[] parents = new int[nVertices];

		// The starting vertex does not
		// have a parent
		parents[startVertex] = NO_PARENT;

		// -----------------STEP 6----------------
		// Find shortest path for all
		// vertices
		for (int i = 1; i < nVertices; i++) {
			/// ------------------- step 4 --------------------
			// Pick the minimum distance vertex
			// from the set of vertices not yet
			// processed. nearestVertex is
			// always equal to startNode in
			// first iteration.
			int nearestVertex = -1;
			int shortestDistance = Integer.MAX_VALUE;
			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				if (!VISTED[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
					nearestVertex = vertexIndex;
					shortestDistance = shortestDistances[vertexIndex];
				}
			}

			// Mark the picked vertex as
			// processed
			//-------------------step 7-----------
			VISTED[nearestVertex] = true;
			// ----------------STEP 5-------
			// Update dist value of the
			// adjacent vertices of the
			// picked vertex.
			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

				if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
					parents[vertexIndex] = nearestVertex;
					shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
				}
			}
		}

		printSolution(startVertex, shortestDistances, parents);
	}

	// A utility function to print
	// the constructed distances
	// array and shortest paths
// printing
	private static void printSolution(int startVertex, int[] distances, int[] parents) {
		paths = new ArrayList<>();
		int nVertices = distances.length;
	

		for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
			if (vertexIndex != startVertex) {
				
				ArrayList<Integer> path = new ArrayList<>();
				int cv = vertexIndex;
				while (cv != NO_PARENT) {
					path.add(0, cv);
					cv = parents[cv];
				}
				if (print_results)
					for (int i : path) {
						System.out.print(i + " ");
					}
		
				paths.add(path);
			
			}
		}
	}



	private static void printPath(int currentVertex, int[] parents) {

		int cv = currentVertex;
		while (cv != NO_PARENT) {
			System.out.print(cv + " ");
			cv = parents[cv];
		}

	}

	public static void main() {
		// y = index of first source, x = index of distance
		// Adjacency Matrices represinting graphs 4 X 4
		int[][] adjacencyMatrix = { { 0, 7, 1, 0 }, { 7, 0, 0, 1 }, { 1, 0, 0, 10 }, { 0, 1, 10, 0 } };
		dijkstra(adjacencyMatrix, 0);
	}
}
