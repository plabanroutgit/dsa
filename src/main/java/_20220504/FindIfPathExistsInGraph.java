package _20220504;

import java.util.ArrayList;

public class FindIfPathExistsInGraph {

	static FindIfPathExistsInGraph g;
	int V;
	ArrayList<ArrayList<Integer>> adjListArray;

	FindIfPathExistsInGraph(int V) {
		this.V = V;

		adjListArray = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adjListArray.add(i, new ArrayList<Integer>());
		}
	}

	void addEdge(int src, int dest) {

		adjListArray.get(src).add(dest);

		adjListArray.get(dest).add(src);
	}

	boolean DFSUtil(int v, boolean[] visited, int dest) {

		visited[v] = true;

		if (v == dest)
			return true;

		for (int x : adjListArray.get(v)) {
			if (!visited[x])
				if (DFSUtil(x, visited, dest))
					return true;
		}

		return false;
	}

	public boolean validPath(int n, int[][] edges, int source, int destination) {

		for (int i = 0; i < edges.length; i++) {
			g.addEdge(edges[i][0], edges[i][1]);
		}

		boolean[] visited = new boolean[V];

		if (!visited[source]) {

			return DFSUtil(source, visited, destination);

		}

		return false;
	}

	public static void main(String[] args) {

		g = new FindIfPathExistsInGraph(6);

		int n = 6, source = 0, destination = 2;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } };

		// int n = 3, source = 0, destination = 2;
		// int[][] edges = { { 0, 1 }, { 1, 2 }, { 2,0 } };

		System.out.println("From src to dest ... ");
		System.out.println(g.validPath(n, edges, source, destination));
	}
}