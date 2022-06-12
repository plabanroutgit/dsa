package _20220529;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildingsWithOceanView {

	public int[] findBuildings(int[] heights) {

		List<Integer> ov = new ArrayList<Integer>();
		int maxHeight = 0;
		for (int i = heights.length - 1; i >= 0; i--) {
			if (heights[i] > maxHeight) {
				maxHeight = heights[i];
				ov.add(i);
			}

		}

		int[] tmp = new int[ov.size()];

		int i = 0;
		for (int v : ov) {
			tmp[i++] = v;
		}
		Arrays.sort(tmp);

		return tmp;
	}

	public static void main(String[] args) {

		int[] heights = { 1, 3, 2, 4 };

		BuildingsWithOceanView b = new BuildingsWithOceanView();

		System.out.println(Arrays.toString(b.findBuildings(heights)));

	}
}
