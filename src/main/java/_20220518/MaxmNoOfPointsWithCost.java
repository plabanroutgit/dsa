package _20220518;

//https://www.youtube.com/watch?v=QKu8NQcC6zs&t=1487s
//https://www.youtube.com/watch?v=lk7WUhAwYGA
public class MaxmNoOfPointsWithCost {

	public long maxPoints(int[][] points) {

		int m = points.length;
		int n = points[0].length;

		long[][] dp = new long[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = 0;
			}
		}

		for (int i = 0; i < n; i++) {
			dp[0][i] = points[0][i];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				long maxval = 0;
				for (int k = 0; k < n; k++) {

					maxval = Math.max(maxval, dp[i-1][k] - Math.abs(k - j));
				}
				dp[i][j] = maxval + points[i][j];
			}

		}
		

		long max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(dp[m - 1][i], max);
		}
		return max;

	}

	public static void main(String[] args) {

		int[][] points = { { 1, 2, 3 }, { 1, 5, 1 }, { 3, 1, 1 } };
		//int[][] points = { { 1, 5 }, { 2, 3 }, { 4, 2 } };

		MaxmNoOfPointsWithCost m = new MaxmNoOfPointsWithCost();

		System.out.println(m.maxPoints(points));

	}

}
