package _20220703;

import java.util.LinkedList;
import java.util.Queue;

class Cell {
	int x;
	int y;
	int dist;

	Cell(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class ShortestPathInBinaryMatrix1091 {

	public int shortestPathBinaryMatrix(int[][] grid) {

		int r = grid.length;
		int c = grid[0].length;

		int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

		if (grid[0][0] == 1 || grid[r - 1][c - 1] == 1)
			return -1;

		Queue<Cell> q = new LinkedList<Cell>();
		Cell start = new Cell(0, 0, 1);
		grid[0][0] = 1;
		q.offer(start);

		while (!q.isEmpty()) {

			int size = q.size();
			for (int i = 0; i < size; i++) {

				Cell t = q.poll();
				if (t.x == r - 1 && t.y == c - 1)
					return t.dist;

				for (int[] s : directions) {
					int nextX = t.x + s[0];
					int nextY = t.y + s[1];
					if (nextX < 0 || nextX > r - 1 || nextY < 0 || nextY > c - 1 || grid[nextX][nextY] == 1)
						continue;

					q.offer(new Cell(nextX, nextY, t.dist + 1));

				}
				grid[t.x][t.y] = 1;
			}

		}

		return -1;
	}

	public static void main(String[] args) {

		// int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		int[][] grid = { { 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 1 },
				{ 0, 0, 0, 1, 0 } };
		ShortestPathInBinaryMatrix1091 sp = new ShortestPathInBinaryMatrix1091();
		System.out.println(sp.shortestPathBinaryMatrix(grid));

	}
}
