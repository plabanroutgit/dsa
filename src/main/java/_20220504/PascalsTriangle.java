package _20220504;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	private List<Integer> lst = new ArrayList<Integer>();

	public List<Integer> getRow(int rowIndex) {

		for (int i = 0; i <= rowIndex; i++) {

			lst.add(getNum(rowIndex, i));

		}
		
		return lst;
	}

	private int getNum(int r, int c) {

		if (r == 0 || c == 0 || r == c)
			return 1;

		return getNum(r - 1, c - 1) + getNum(r - 1, c);

	}

	public static void main(String[] args) {

		PascalsTriangle cb = new PascalsTriangle();

		int rowidx = 3;

		System.out.println(cb.getRow(rowidx));

	}

}
