package lcmedium.sortingnsearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKfrequentElements {

	public static int[] topKFrequent(int[] nums, int k) {
		// count the frequency for each element
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// create a min heap
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));

		// maintain a heap of size k.
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			queue.offer(entry);
			if (queue.size() > k) {
				queue.poll();
			}
		}

		// get all elements from the heap
		int[] result = new int[k];
		int i = 0;
		while (queue.size() > 0) {
			result[i++] = queue.poll().getKey();
		}

		// reverse the order
		// Collections.reverse(result);
		Arrays.sort(result);

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5 };
		int k = 2;

		System.out.println(topKFrequent(nums, k));

	}

}
