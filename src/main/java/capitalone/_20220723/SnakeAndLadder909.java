package capitalone._20220723;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=zWS2fCJGxmU&t=916s
public class SnakeAndLadder909 {

	public int snakesAndLadders(int[][] board) {

		int n = board.length;
		boolean[][] visited = new boolean[n][n];
		int steps = 0;

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(1);
		visited[n - 1][0] = true;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int c = q.poll();
				System.out.println(c);
				if (c == n * n)
					return steps;
				for (int j = 1; j <= 6; j++) {
					if ((c + j) > n * n)
						break;

					int[] pos = findcoordinates(c + j, n);
					int row = pos[0];
					int col = pos[1];
					System.out.println("row -> " + row + " col -> " + col);

					if (board[row][col] != -1)
						q.add(board[row][col]);
					else
						q.add(c + j);
					
					if (visited[row][col])
						continue;
					visited[row][col] = true;


				}

			}
			steps++;
		}

		return -1;
	}

	public int[] findcoordinates(int curr, int n) {

		int r = n - (curr - 1) / n - 1;
		int c = (curr - 1) % n;
		if (r % 2 == n % 2) {
			return new int[] { r, n - 1 - c };
		} else {
			return new int[] { r, c };
		}
	}

	public static void main(String[] args) {

		int[][] board = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
				{ -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };

		SnakeAndLadder909 sal = new SnakeAndLadder909();
		System.out.println(sal.snakesAndLadders(board));
	}

}
