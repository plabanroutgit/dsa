package _20220508;

import java.util.ArrayList;
import java.util.List;

public class TreeDiameter {

	List<List<Integer>> g = new ArrayList<List<Integer>>();

	int[] memo = null;
	int V = 0;
	int maxlen = Integer.MIN_VALUE;

	public void addedges(int[][] edges) {

		V = edges.length + 1;
		memo = new int[V];
		for (int i = 0; i < V; i++) {
			g.add(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {
			g.get(edges[i][0]).add(edges[i][1]);
			g.get(edges[i][1]).add(edges[i][0]);
		}
	}

	public int treeDiameter(int[][] edges) {

		addedges(edges);
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {

			int curlen = 0;
			dfs(i, curlen, visited);
			memo[i] = maxlen;
		}

		return maxlen;
	}

	private void dfs(int n, int curlen, boolean[] visited) {

		if (!visited[n]) {

			maxlen = Math.max(maxlen, curlen);
			visited[n] = true;
			for (int nextnode : g.get(n)) {
				dfs(nextnode, curlen + 1, visited);
			}
			visited[n] = false;
		}
	}

	public static void main(String[] args) {

		// int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 4 }, { 4, 5 } };

		int[][] edges = { { 0, 1 }, { 0, 2 } };

		TreeDiameter td = new TreeDiameter();

		System.out.println(td.treeDiameter(edges));

	}
}
