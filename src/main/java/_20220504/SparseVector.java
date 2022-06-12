package _20220504;

import java.util.Arrays;

public class SparseVector {

	public int[] lnum;
	public int sum = 0;

	SparseVector(int[] nums) {
		lnum = Arrays.copyOf(nums, nums.length);
	}

	// Return the dotProduct of two sparse vectors
	public int dotProduct(SparseVector vec) {

		for (int i = 0; i < vec.lnum.length; i++) {
			sum += lnum[i] * vec.lnum[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 0, 0, 2, 3 }, nums2 = { 0, 3, 0, 4, 0 };

		SparseVector v1 = new SparseVector(nums1), v2 = new SparseVector(nums2);

		System.out.println(v1.dotProduct(v2));

	}
}
