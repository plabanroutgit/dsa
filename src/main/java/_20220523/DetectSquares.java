package _20220523;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;


//https://www.google.com/search?q=detect+squares+leetcode+solution&oq=detect+&aqs=chrome.0.69i59j69i57j35i39j0i433i512j0i512j69i61l2j69i60.3014j0j7&sourceid=chrome&ie=UTF-8#kpvalbx=_Ar6OYr_rHf2IytMPyZGxqAQ16
public class DetectSquares {

	Map<Pair<Integer, Integer>, Integer> pts = null;

	public DetectSquares() {
		pts = new HashMap<Pair<Integer, Integer>, Integer>();
	}

	public void add(int[] point) {
		Pair<Integer, Integer> p = new Pair<Integer, Integer>(point[0], point[1]);
		pts.merge(p, 1, (oldVal, newVal) -> oldVal + newVal);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int count(int[] point) {

		int res = 0;

		for (Pair<Integer, Integer> p : pts.keySet()) {

			if (Math.abs(point[0] - p.getKey()) != Math.abs(point[1] - p.getValue()) || (point[0] == p.getKey())
					|| (point[1] == p.getValue())) {
				continue;
			}

			if (pts.get(new Pair(p.getKey(), point[1])) != null && pts.get(new Pair(point[0], p.getValue())) != null)
				res += pts.get(new Pair(p.getKey(), point[1])) * pts.get(new Pair(point[0], p.getValue()));

		}
		return res;
	}

	public static void main(String[] args) {

		DetectSquares detectSquares = new DetectSquares();
		detectSquares.add(new int[] { 3, 10 });
		detectSquares.add(new int[] { 11, 2 });
		detectSquares.add(new int[] { 3, 2 });
		System.out.println(detectSquares.count(new int[] { 11, 10 }));
		System.out.println(detectSquares.count(new int[] { 14, 8 }));
		detectSquares.add(new int[] { 11, 2 });
		System.out.println(detectSquares.count(new int[] { 11, 10 }));
		;

	}

}