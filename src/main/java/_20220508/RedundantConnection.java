package _20220508;

import java.util.Arrays;

//https://www.youtube.com/watch?v=FXWRE67PLL0
public class RedundantConnection {

	int V = 0;
	int[] par = null, rank = null;

	public int find(int n) {
		if (par[n] != n)
			par[n] = find(par[n]);

		return par[n];
	}

	public boolean union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 == p2)
			return false;

		if (rank[p1] > rank[p2]) {
			par[p2] = p1;
			rank[p1] += rank[p2];
		} else {
			par[p1] = p2;
			rank[p2] += rank[p1];
		}

		return true;
	}

	public int[] findRedundantConnection(int[][] edges) {

		V = edges.length + 1;
		par = new int[V];
		rank = new int[V];
		for (int i = 0; i < V; i++) {
			par[i] = i;
			rank[i] = 1;
		}
		
		for (int i = 0; i < edges.length; i++) {

			if (union(edges[i][0], edges[i][1]) == false)
				return edges[i];

		}
		return null;
	}

	public static void main(String[] args) {

		int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };

		RedundantConnection rc = new RedundantConnection();

		System.out.println(Arrays.toString(rc.findRedundantConnection(edges)));
	}

}
