package _20220506;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSrcToTgt_797 {

	int V;
	ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();

	public List<List<Integer>> op = new ArrayList<List<Integer>>();

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		V = graph.length;
		for (int i = 0; i < graph.length; i++) {
			if (!al.contains(i)) {
				al.add(i, new ArrayList<Integer>());
			}

			for (int j = 0; j < graph[i].length; j++) {
				al.get(i).add(graph[i][j]);
			}
		}

		getPathList(0, V - 1);

		return op;
	}

	public void getPathList(int s, int d) {

		boolean isVisited[] = new boolean[V];

		List<Integer> curPath = new ArrayList<Integer>();
		curPath.add(s);
		getPath(s, d, isVisited, curPath);

	}

	public void getPath(int s, int d, boolean[] isVisited, List<Integer> curPath) {

		if (s == d) {
			op.add(curPath);

			System.out.println(op);
			return;
		}

		isVisited[s] = true;

		for (Integer i : al.get(s)) {
			if (!isVisited[i]) {
				curPath.add(i);
				getPath(i, d, isVisited, curPath);

				curPath.remove(i);

			}

		}
		isVisited[s] = false;

	}

	public static void main(String[] args) {

		int[][] p = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };

		AllPathsFromSrcToTgt_797 ab = new AllPathsFromSrcToTgt_797();

		System.out.println(ab.allPathsSourceTarget(p));
	}

}
