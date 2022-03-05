package alimir;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet1 {

	private static int MAX_LEN = 10000;
	private List<Integer>[] set;

	@SuppressWarnings("unchecked")
	public MyHashSet1() {
		set = new ArrayList[MAX_LEN];
	}

	public int getIndex(int key) {
		return key % MAX_LEN;
	}

	public int getPos(int key, int index) {

		if (set[index] == null) {
			return -1;
		} else {
			for (int i = 0; i < set[index].size(); i++) {
				if (set[index].get(i) == key) {
					return i;
				}
			}
		}
		return -1;
	}

	public void add(int key) {
		int bucket = getIndex(key);
		int index = getPos(key, bucket);

		if (index == -1) {
			if (set[bucket] == null) {
				set[bucket] = new ArrayList<Integer>();
				set[bucket].add(key);
			} else {
				set[bucket].set(set[bucket].size(), key);
			}
		} else {
			return;
		}

	}

	public void remove(int key) {
		int bucket = getIndex(key);
		int index = getPos(key, bucket);

		if (index == -1) {
			return;
		} else {
			set[bucket].remove(index);
		}
	}

	public boolean contains(int key) {
		int bucket = getIndex(key);
		int index = getPos(key, bucket);

		if (index == -1) {
			return false;
		}
		return true;
	}

}
