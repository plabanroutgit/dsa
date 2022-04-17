package lceasy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOf2Arrays {

	public static int[] intersect(int[] nums1, int[] nums2) {

		Map<Integer, Integer> nums2M = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums2.length; i++) {
			if (nums2M.containsKey(nums2[i])) {
				nums2M.put(nums2[i], nums2M.get(nums2[i]) + 1);
			} else {
				nums2M.put(nums2[i], 1);
			}
		}

		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < nums1.length; i++) {

			if (nums2M.containsKey(nums1[i])) {
				result.add(nums1[i]);
				nums2M.put(nums1[i], nums2M.get(nums1[i]) - 1);
				if (nums2M.get(nums1[i]) == 0)
					nums2M.remove(nums1[i]);
			}

		}

		int[] myArray = new int[result.size()];

		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = result.get(i);
		}
		return myArray;
	}

	public static void main(String[] args) {

		int[] nums1 = { 4, 9, 5 }, nums2 = { 9, 4, 9, 8, 4 };

		System.out.println(Arrays.toString(intersect(nums1, nums2)));

	}
}
