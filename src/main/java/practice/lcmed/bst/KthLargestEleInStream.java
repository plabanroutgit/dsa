package practice.lcmed.bst;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestEleInStream {

	private static int k;
	private PriorityQueue<Integer> heap;

	public KthLargestEleInStream(int k, int[] nums) {
		this.k = k;
		heap = new PriorityQueue<>();

		for (int num : nums) {
			heap.offer(num);
		}

		while (heap.size() > k) {
			heap.poll();
		}
	}

	public int add(int val) {
		heap.offer(val);
		if (heap.size() > k) {
			heap.poll();
		}

		return heap.peek();
	}

	public static void main(String[] args) {

		int[] nums = { 4, 5, 8, 2 };
		KthLargestEleInStream ks = new KthLargestEleInStream(3, nums);

		System.out.println(ks.add(3));

	}

}
