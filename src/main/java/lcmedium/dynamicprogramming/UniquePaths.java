package lcmedium.dynamicprogramming;

import java.util.Arrays;


// https://leetcode.com/problems/unique-paths/solution/
public class UniquePaths {
	public static int uniquePaths(int m, int n) {
		int[][] d = new int[m][n];

		for (int[] arr : d) {
			Arrays.fill(arr, 1);
		}
		for (int col = 1; col < m; ++col) {
			for (int row = 1; row < n; ++row) {
				d[col][row] = d[col - 1][row] + d[col][row - 1];
			}
		}
		return d[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int m = 3, n = 7;

		System.out.println(uniquePaths(3, 7));
	}
}
