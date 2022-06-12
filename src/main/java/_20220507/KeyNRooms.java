package _20220507;

import java.util.ArrayList;
import java.util.List;

public class KeyNRooms {

	boolean[] visited = null;

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {

		visited = new boolean[rooms.size()];

		visitRoom(0, rooms);
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i])
				return false;
		}

		return true;
	}

	private void visitRoom(int k, List<List<Integer>> rooms) {

		visited[k] = true;
		System.out.println("room-> " + k);
		if (!rooms.get(k).isEmpty()) {

			for (Integer roomkey : rooms.get(k)) {
				if (!visited[roomkey])
					visitRoom(roomkey, rooms);
			}
		} else {
			return;
		}

	}

	public static void main(String[] args) {

		List<List<Integer>> rooms = new ArrayList<List<Integer>>();

		List<Integer> curr = new ArrayList<Integer>();
		curr.add(1);
		curr.add(3);
		rooms.add(curr);

		curr = new ArrayList<Integer>();
		curr.add(3);
		curr.add(0);
		curr.add(1);
		rooms.add(curr);

		curr = new ArrayList<Integer>();
		curr.add(2);
		rooms.add(curr);

		curr = new ArrayList<Integer>();
		curr.add(0);
		rooms.add(curr);

		KeyNRooms kr = new KeyNRooms();

		System.out.println(kr.canVisitAllRooms(rooms));

	}

}
