package _20220507;

public class NumberOfProvincesDFS {

	public int findCircleNum(int[][] isConnected) {

		int res = 0;
		boolean[] visited = new boolean[isConnected.length];

		for (int i = 0; i < isConnected.length; i++) {
			if (!visited[i]) {
				dfs(i, visited, isConnected);
				res++;
			}
		}
		return res;
	}

	public void dfs(int i, boolean[] visited, int[][] isConnected) {

		visited[i] = true;
		for (int j = 0; j < isConnected.length; j++) {
			if (isConnected[i][j] == 1 && i != j && !visited[j]) {
				dfs(j, visited, isConnected);
			}
		}

	}

	public static void main(String[] args) {

		// int[][] M = { { 1, 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1, 0
		// }, { 0, 0, 1, 1, 0, 0 },
		// { 0, 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1 } };

		int[][] M = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		NumberOfProvincesDFS np = new NumberOfProvincesDFS();

		System.out.println(np.findCircleNum(M));
	}

}
