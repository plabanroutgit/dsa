package alimir;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class MyHashMap1 {
	private static int MAX_LEN = 10000;
	private List<Pair<Integer, Integer>>[] map;

	@SuppressWarnings("unchecked")
	public MyHashMap1() {

		map = (List<Pair<Integer, Integer>>[]) new ArrayList[MAX_LEN];
	}

	public int getIndex(int key) {
		return key % MAX_LEN;
	}

	public int getPos(int key, int index) {
		int bucket = getIndex(key);

		if (map[bucket] == null) {
			return -1;
		} else {
			for (int i = 0; i < map[bucket].size(); i++) {
				if (map[bucket].get(i).getKey() == key) {
					return i;
				}
			}
		}
		return -1;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add(int key, int val) {
		int bucket = getIndex(key);
		int pos = getPos(key, bucket);

		if (pos < 0) {
			if (map[bucket] == null) {
				map[bucket] = new ArrayList<Pair<Integer, Integer>>();
			}
			map[bucket].add(new Pair(key, val));
		} else {
			map[bucket].set(pos, new Pair(key, val));
		}

	}

	public void remove(int key) {
		int bucket = getIndex(key);
		int pos = getPos(key, bucket);

		if (pos < 0) {
			return;
		} else {
			map[bucket].remove(pos);
		}
	}

	public int get(int key) {
		int bucket = getIndex(key);
		int pos = getPos(key, bucket);

		if (pos < 0) {
			return -1;
		} else {
			return map[bucket].get(pos).getValue();
		}
	}

}
