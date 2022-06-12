package _20220517;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.util.Pair;

public class Racecar {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int racecar(int target) {

		int pos = 0;
		int speed = 1;

		Queue<Pair<Pair<Integer, Integer>, String>> q = new LinkedList();

		List<Pair<Integer, Integer>> visited = new LinkedList();

		q.offer(new Pair(new Pair(pos, speed), ""));

		while (!q.isEmpty()) {

			int size = q.size();

			while (size-- > 0) {
				Pair<Pair<Integer, Integer>, String> p = q.poll();

				if (!visited.contains(p.getKey())) {

					visited.add(p.getKey());

					if (p.getKey().getKey() == target) {
						return p.getValue().length();
					}

					q.offer(new Pair(new Pair(p.getKey().getKey() + p.getKey().getValue(), p.getKey().getValue() * 2),
							p.getValue() + "A"));
					q.offer(new Pair(new Pair(p.getKey().getKey(), p.getKey().getValue() > 0 ? -1 : 1),
							p.getValue() + "R"));
				}
			}

		}

		return 0;

	}

	public static void main(String[] args) {

		Racecar rc = new Racecar();

		System.out.println(rc.racecar(7));

	}

}
