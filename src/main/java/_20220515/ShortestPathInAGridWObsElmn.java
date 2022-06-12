package _20220515;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=ID9YJXy3OJk
public class ShortestPathInAGridWObsElmn {

	public int shortestPath(int[][] grid, int k) {

		int m = grid.length;
		int n = grid[0].length;
		int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		// int[][][] gd = new int[m][n][k + 1];
		boolean[][][] visited = new boolean[m][n][k + 1];
		int steps = 0;

		Queue<int[]> q = new LinkedList<int[]>();

		q.offer(new int[] { 0, 0, k });
		// visited[0][0][k] = true;
		while (!q.isEmpty()) {

			int size = q.size();

			while (size-- > 0) {
				int[] curr = q.poll();

				if (curr[0] == m - 1 && curr[1] == n - 1)
					return steps;

				for (int[] d : dir) {
					int row = curr[0] + d[0];
					int col = curr[1] + d[1];
					int obs = curr[2];

					if (row >= 0 && row < m && col >= 0 && col < n) {

						if (grid[row][col] == 0 && !(visited[row][col][obs])) {

							q.offer(new int[] { row, col, obs });
							visited[row][col][obs] = true;

						} else if (grid[row][col] == 1 && obs > 0 && !(visited[row][col][obs - 1])) {

							q.offer(new int[] { row, col, obs - 1 });
							visited[row][col][obs - 1] = true;
						}
					}
				}
			}

			++steps;
		}

		return -1;
	}

	public static void main(String[] args) {

		// int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0,
		// 0 } };
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 } };
		int k = 1;

		ShortestPathInAGridWObsElmn sp = new ShortestPathInAGridWObsElmn();
		System.out.println(sp.shortestPath(grid, k));
	}

}
