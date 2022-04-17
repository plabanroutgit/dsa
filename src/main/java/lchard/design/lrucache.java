package lchard.design;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class lrucache extends LinkedHashMap<Integer, Integer> {
	private int capacity;

	public lrucache(int capacity) {
		super(capacity, 0.75F, true);
		this.capacity = capacity;
	}

	public int get(int key) {
		return super.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}

	public static void main(String[] args) {

		lrucache lcache = new lrucache(2);
		lcache.put(1, 1); // cache is {1=1}
		lcache.put(2, 2); // cache is {1=1, 2=2}
		lcache.get(1); // return 1
		lcache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		lcache.get(2); // returns -1 (not found)
		lcache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		lcache.get(1); // return -1 (not found)
		lcache.get(3); // return 3
		lcache.get(4); // return 4
	}

}