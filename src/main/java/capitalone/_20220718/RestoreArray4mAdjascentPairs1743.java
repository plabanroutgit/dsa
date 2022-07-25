package capitalone._20220718;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//https://www.youtube.com/watch?v=ZLTU9yRTVqY
public class RestoreArray4mAdjascentPairs1743 {

	public int[] restoreArray(int[][] adjacentPairs) {

		Map<Integer, LinkedList<Integer>> edges = new HashMap<Integer, LinkedList<Integer>>();

		for (int i = 0; i < adjacentPairs.length; i++) {

			LinkedList<Integer> l = edges.getOrDefault(adjacentPairs[i][0], new LinkedList<Integer>());
			l.add(adjacentPairs[i][1]);
			edges.put(adjacentPairs[i][0], l);

			l = edges.getOrDefault(adjacentPairs[i][1], new LinkedList<Integer>());
			l.add(adjacentPairs[i][0]);
			edges.put(adjacentPairs[i][1], l);
		}

		Deque<Integer> stk = new ArrayDeque<Integer>();

		for (Entry<Integer, LinkedList<Integer>> e : edges.entrySet()) {

			if (e.getValue().size() == 1) {
				stk.offer(e.getKey());
				break;
			}
		}

		Set<Integer> visited = new HashSet<Integer>();
		int[] res = new int[adjacentPairs.length + 1];
		int i = 0;
		while (!stk.isEmpty()) {
			int curr = stk.poll();
			res[i++] = curr;
			for (Integer v : edges.get(curr)) {
				if (!visited.contains(v)) {
					stk.offer(v);
				}
			}

			visited.add(curr);

		}

		return res;
	}

	public static void main(String[] args) {

		// int[][] adjacentPairs = { { 2, 1 }, { 3, 4 }, { 3, 2 } };

		int[][] adjacentPairs = { { 4, -2 }, { 1, 4 }, { -3, 1 } };

		RestoreArray4mAdjascentPairs1743 ra = new RestoreArray4mAdjascentPairs1743();
		System.out.println(Arrays.toString(ra.restoreArray(adjacentPairs)));

	}

}
