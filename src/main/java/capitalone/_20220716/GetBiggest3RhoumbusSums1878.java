package capitalone._20220716;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class GetBiggest3RhoumbusSums1878 {

	public int[] getBiggestThree(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		HashSet<Integer> visited = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!visited.contains(grid[i][j])) {
					visited.add(grid[i][j]);
					pq.add(grid[i][j]);
				}
				if (pq.size() > 3) {
					pq.poll();
				}
			}
		}

		for (int i = 0; i < m - 2; i++) {
			for (int j = 1; j < n - 1; j++) {
				int colSize = Math.min(j - 0, n - j - 1);
				int rowSize = 0;
				if ((m - i) % 2 == 0) {
					rowSize = (m - i) / 2 - 1;
				} else {
					rowSize = (m - 1 - i) / 2;
				}

				int maxSize = Math.min(colSize, rowSize);
				for (int size = 1; size <= maxSize; size++) {
					int sum = 0;
					for (int cn = 0; cn < size; cn++) {
						sum += grid[i][j];
						j--;
						i++;
					}
					for (int cn = 0; cn < size; cn++) {
						sum += grid[i][j];
						i++;
						j++;
					}
					for (int cn = 0; cn < size; cn++) {
						sum += grid[i][j];
						j++;
						i--;
					}
					for (int cn = 0; cn < size; cn++) {
						sum += grid[i][j];
						i--;
						j--;
					}
					if (!visited.contains(sum)) {
						visited.add(sum);
						pq.add(sum);
					}
					if (pq.size() > 3) {
						pq.poll();
					}
				}

			}
		}
		int[] res = new int[pq.size()];
		int a = pq.size() - 1;
		while (!pq.isEmpty()) {
			res[a] = pq.poll();
			a--;
		}
		return res;
	}

	public static void main(String[] args) {

		int[][] grid = { { 3, 4, 5, 1, 3 }, { 3, 3, 4, 2, 3 }, { 20, 30, 200, 40, 10 }, { 1, 5, 5, 4, 1 },
				{ 4, 3, 2, 2, 5 } };

		GetBiggest3RhoumbusSums1878 gb = new GetBiggest3RhoumbusSums1878();
		System.out.println(Arrays.toString(gb.getBiggestThree(grid)));

	}

}
