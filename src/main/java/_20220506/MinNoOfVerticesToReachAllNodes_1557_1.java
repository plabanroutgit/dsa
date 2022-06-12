package _20220506;

import java.util.ArrayList;
import java.util.List;

public class MinNoOfVerticesToReachAllNodes_1557_1 {

	int V;
	ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();

	MinNoOfVerticesToReachAllNodes_1557_1(int v) {

		this.V = v;
		for (int i = 0; i < V; i++) {
			al.add(i, new ArrayList<Integer>());
		}
	}

	public void findSmallestSetOfVertices(int n, int[][] edges) {

		for (int i = 0; i < edges.length; i++) {
			al.get(edges[i][0]).add(edges[i][1]);
		}

		getVertexList();

	}

	public void getVertexList() {

		boolean isVisited[] = new boolean[V];
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] op = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			if (op[i] == null) {
				op[i] = new ArrayList<Integer>();
			}
			getPath(i, i, isVisited, op);
		}

		for (int i = 0; i < op.length; i++) {
			System.out.println(i + " -> " + op[i]);
			
			
			
		}

	}

	public void getPath(int s, int cur, boolean[] isVisited, List<Integer>[] op) {

		isVisited[s] = true;

		for (Integer i : al.get(cur)) {
			if (!isVisited[i]) {
				op[s].add(i);
				getPath(s, i, isVisited, op);
			}
		}
		isVisited[s] = false;
	}

	public static void main(String[] args) {

		int n = 6;
		int[][] p = { { 0, 1 }, { 0, 2 }, { 2, 5 }, { 3, 4 }, { 4, 2 } };

		MinNoOfVerticesToReachAllNodes_1557_1 ab = new MinNoOfVerticesToReachAllNodes_1557_1(n);

		ab.findSmallestSetOfVertices(n, p);
	}

}
