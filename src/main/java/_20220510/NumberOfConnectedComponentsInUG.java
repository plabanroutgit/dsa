package _20220510;

import java.util.Iterator;

//https://www.youtube.com/watch?v=8f1XPm4WOUc

public class NumberOfConnectedComponentsInUG {

	int[] par = {};
	int[] rank = {};

	public int find(int n) {
		if (par[n] != n)
			par[n] = find(par[n]);
		return par[n];
	}

	public int union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 == p2)
			return 0;

		if (rank[p2] > rank[p1]) {
			par[p1] = p2;
			rank[p2] += rank[p1];
		} else {
			par[p2] = p1;
			rank[p1] += rank[p2];
		}

		return 1;
	}

	public int countComponents(int n, int[][] edges) {

		par = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			par[i] = i;
			rank[i] = 1;
		}

		int res = n;
		for (int i = 0; i < edges.length; i++) {
			res -= union(edges[i][0], edges[i][1]);
		}

		return res;
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };

		NumberOfConnectedComponentsInUG ug = new NumberOfConnectedComponentsInUG();

		System.out.println(ug.countComponents(n, edges));

	}

}
