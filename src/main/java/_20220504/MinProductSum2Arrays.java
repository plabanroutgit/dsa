package _20220504;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinProductSum2Arrays {

	public int minProductSum(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (Integer i : nums2) {
			pq.add(i);
		}

		int ans = 0;
		for (int i = 0; i < nums1.length; i++) {
			ans += nums1[i] * pq.poll();
		}

		return ans;
	}

	public static void main(String[] args) {

		int[] nums1 = { 5, 3, 4, 2 }, nums2 = { 4, 2, 2, 5 };

	}

}
