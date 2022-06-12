package _20220507;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvincesBFS {

	public int findCircleNum(int[][] isConnected) {

		int res = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[isConnected.length];

		for (int i = 0; i < isConnected.length; i++) {

			if (!visited[i]) {
				q.add(i);

				while (!q.isEmpty()) {
					int s = q.poll();
					visited[s] = true;
					for (int j = 0; j < isConnected.length; j++) {
						if (isConnected[s][j] == 1 && s != j && !visited[j]) {
							q.add(j);
						}

					}

				}
				res++;
			}

		}

		return res;
	}

	public static void main(String[] args) {

		int[][] M = { { 1, 1, 0, 0, 0, 0 },

				{ 1, 1, 0, 0, 0, 0 },

				{ 0, 0, 1, 1, 1, 0 },

				{ 0, 0, 1, 1, 0, 0 },

				{ 0, 0, 1, 0, 1, 0 },

				{ 0, 0, 0, 0, 0, 1 } };

		NumberOfProvincesBFS np = new NumberOfProvincesBFS();

		System.out.println(np.findCircleNum(M));
	}

}
