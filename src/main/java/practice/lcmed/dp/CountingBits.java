package practice.lcmed.dp;

public class CountingBits {

	public int[] countBits(int n) {

		int[] array = new int[n + 1];

		for (int i = 0; i <= n; i++) {

			int onecnt = 0;
			int y = i;
			while (y != 0) {
				if ((y & 1) == 1)
					onecnt++;
				y >>= 1;
			}
			array[i] = onecnt;
			System.out.println(i + " -> " + onecnt);
		}

		return array;
	}

	public static void main(String[] args) {

		CountingBits cb = new CountingBits();
		cb.countBits(5);

	}

}
