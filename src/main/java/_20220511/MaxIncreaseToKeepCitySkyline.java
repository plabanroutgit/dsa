package _20220511;

public class MaxIncreaseToKeepCitySkyline {

	public int maxIncreaseKeepingSkyline(int[][] grid) {

		int[] r = new int[grid.length];
		int[] c = new int[grid.length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				r[i] = Math.max(r[i], grid[i][j]);
				c[j] = Math.max(c[j], grid[i][j]);
			}
		}

		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				res += Math.min(r[i], c[j]) - grid[i][j];
			}
		}

		return res;
	}

	public static void main(String[] args) {

		int[][] grid = { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } };

		MaxIncreaseToKeepCitySkyline mn = new MaxIncreaseToKeepCitySkyline();
		System.out.println(mn.maxIncreaseKeepingSkyline(grid));

	}
}
