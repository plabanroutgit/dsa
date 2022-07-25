package _20220702;

//https://www.youtube.com/watch?v=toYgBIaUdfM
public class PairOfSongsDurationDivisibleBy60 {

	public int numPairsDivisibleBy60(int[] time) {

		int[] darr = new int[60];
		long res = 0;

		for (int i = 0; i < time.length; i++) {
			darr[time[i] % 60] += 1;
		}

		for (int i = 0; i <= darr.length / 2; i++) {

			if (i == 0 || i == 30) {
				res += darr[i] * (darr[i] - 1) / 2;
			} else {
				res += darr[i] * darr[60 - i];
			}
		}
		return (int) res;
	}

	public static void main(String[] args) {

		int[] time = { 30, 20, 150, 100, 40 };

		PairOfSongsDurationDivisibleBy60 ps = new PairOfSongsDurationDivisibleBy60();
		System.out.println(ps.numPairsDivisibleBy60(time));

	}
}
