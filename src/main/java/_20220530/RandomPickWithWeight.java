package _20220530;

//https://www.youtube.com/watch?v=v-_aEMtgnkI&t=975s

public class RandomPickWithWeight {

	int totalSum = 0;
	int[] cumulativeSum;

	public RandomPickWithWeight(int[] w) {

		cumulativeSum = new int[w.length];
		for (int i = 0; i < w.length; i++) {
			totalSum += w[i];
			cumulativeSum[i] = totalSum;
		}
	}

	public int pickIndex() {

		double target = Math.random() * totalSum;
		int i = 0;
		for (; i < cumulativeSum.length; i++) {
			if (target < cumulativeSum[i])
				return i;
		}
		return i - 1;
	}

	public static void main(String[] args) {

		System.out.println(Math.random() * 20);

	}

}
