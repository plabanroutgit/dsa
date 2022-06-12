package _20220506;

import java.util.ArrayList;
import java.util.List;

public class MinNoOfVerticesToReachAllNodes_1557 {

	public List<Integer> findSmallestSetOfVertices(int n, int[][] edges) {

		List<Integer> ans = new ArrayList<>();

		boolean[] hasParent = new boolean[n];

		for (int i = 0; i < edges.length; i++) {
			hasParent[edges[i][1]] = true;
		}

		for (int i = 0; i < n; i++) {
			if (!hasParent[i]) {
				ans.add(i);
			}
		}

		return ans;
	}

	public static void main(String[] args) {

		int n = 6;
		int[][] p = { { 0, 1 }, { 0, 2 }, { 2, 5 }, { 3, 4 }, { 4, 2 } };

		MinNoOfVerticesToReachAllNodes_1557 ab = new MinNoOfVerticesToReachAllNodes_1557();

		System.out.println(ab.findSmallestSetOfVertices(n, p));
	}

}
