package _20220514;

public class RemoveAllOnesWithRCFlip {

	public boolean removeOnes(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		// flip the column where there's 1 in the first row
		for (int j = 0; j < n; j++) {
			if (grid[0][j] == 1) {
				for (int i = 0; i < m; i++) {
					grid[i][j] = grid[i][j] == 0 ? 1 : 0;
				}
			}
		}

		// flip all 1s rows from second row
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (grid[i][j - 1] != grid[i][j])
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		int[][] grid = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } };

		RemoveAllOnesWithRCFlip rc = new RemoveAllOnesWithRCFlip();
		System.out.println(rc.removeOnes(grid));

	}

}
