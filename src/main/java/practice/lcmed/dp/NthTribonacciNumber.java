package practice.lcmed.dp;

public class NthTribonacciNumber {

	public int tribonacci(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;

		int nth = 0;
		if (n > 2) {
			int[] t = new int[n + 1];
			t[0] = 0;
			t[1] = 1;
			t[2] = 1;
			for (int i = 3; i <= n; i++) {
				t[i] = t[i - 1] + t[i - 2] + t[i - 3];
			}

			nth = t[n];

		}

		return nth;
	}

	public static void main(String[] args) {

		NthTribonacciNumber cb = new NthTribonacciNumber();
		System.out.println(cb.tribonacci(5));

	}

}
