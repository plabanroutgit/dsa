package _20220519;

import java.util.HashMap;
//https://leetcode.com/problems/snapshot-array/discuss/2049381/Java-HashMap-of-HashMap
public class SnapshotArray {

	HashMap<Integer, HashMap<Integer, Integer>> snaps;
	HashMap<Integer, Integer> currentData;
	int snapIndex;

	public SnapshotArray(int length) {
		currentData = new HashMap<>();
		snaps = new HashMap<>();
		snapIndex = 0;
	}

	public void set(int index, int val) {
		currentData.put(index, val);
	}

	public int snap() {
		snaps.put(snapIndex++, new HashMap<>(currentData));
		return snapIndex - 1;
	}

	public int get(int index, int snap_id) {
		if (!snaps.containsKey(snap_id))
			return 0;
		if (!snaps.get(snap_id).containsKey(index))
			return 0;

		return snaps.get(snap_id).get(index);
	}
}