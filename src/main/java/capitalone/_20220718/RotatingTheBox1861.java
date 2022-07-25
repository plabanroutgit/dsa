package capitalone._20220718;

import java.util.Arrays;

public class RotatingTheBox1861 {
	public char[][] rotateTheBox(char[][] box) {

		int m = box.length;
		int n = box[0].length;
		char[][] res = new char[n][m];

		for (int i = 0; i < n; i++) {
			int k = m - 1;
			for (int j = 0; j < m; j++) {
				res[i][j] = box[k--][i];
			}
		}

		for (char[] cs : res) {
			System.out.println(Arrays.toString(cs));
		}

		System.out.println("------------------");
		for (int i = 0; i < res[0].length; i++) {

			boolean adjustneeded = false;

			while (true) {
				int wc = res.length - 1;
				while (wc > 0) {

					if (res[wc][i] == '.' && res[wc - 1][i] != '*' && res[wc - 1][i] == '#') {
						adjustneeded = true;
					}
					wc--;
				}
				if (adjustneeded) {
					adjustColumn(res, i);
					adjustneeded = false;
				} else
					break;
			}
		}

		return res;
	}

	void adjustColumn(char[][] res, int i) {
		int wc = res.length - 1;
		while (wc > 0) {

			if (res[wc][i] == '.' && res[wc - 1][i] != '*') {
				res[wc][i] = res[wc - 1][i];
				if (res[wc - 1][i] == '#') {
					res[wc - 1][i] = '.';
				}
			}
			wc--;
		}

		for (char[] cs : res) {
			System.out.println(Arrays.toString(cs));
		}
		
		System.out.println("-----------------");
		
	}

	public static void main(String[] args) {
		// char[][] box = { { '#', '.', '*', '.' }, { '#', '#', '*', '.' } };

		char[][] box = { { '#', '#', '*', '.', '*', '.' }, { '#', '#', '#', '*', '.', '.' },
				{ '#', '#', '#', '.', '#', '.' } };

		RotatingTheBox1861 rt = new RotatingTheBox1861();

		char[][] res = rt.rotateTheBox(box);

		for (char[] cs : res) {
			System.out.println(Arrays.toString(cs));
		}

	}
}
