package _20220506;

public class FindTheTownJudge {

	public int findJudge(int n, int[][] trust) {

		int[] outdegree = new int[n+1];
		int[] indegree = new int[n+1];

		for (int[] is : trust) {

			outdegree[is[0]]++;
			indegree[is[1]]++;

		}

		for (int i = 1; i <= n; i++) {
			if (indegree[i] == n - 1 && outdegree[i] == 0)
				return i;
		}

		return -1;
	}

	public static void main(String[] args) {

		int n = 3;
		int[][] trust = { { 1, 3 }, { 2, 3 }, { 3, 1 } };

		FindTheTownJudge g = new FindTheTownJudge();

		System.out.println("judge...");
		System.out.println(g.findJudge(n, trust));
	}
}
