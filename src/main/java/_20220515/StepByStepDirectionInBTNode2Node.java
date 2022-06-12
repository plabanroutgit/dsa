package _20220515;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;
import lcmedium.TreeNode;

public class StepByStepDirectionInBTNode2Node {

	@SuppressWarnings("unchecked")
	public String getDirections(TreeNode root, int startValue, int destValue) {

		Map<Integer, LinkedList<Pair<Integer, String>>> bt = new HashMap<Integer, LinkedList<Pair<Integer, String>>>();

		convertToMap(null, root, bt);

		Queue<Pair<Integer, String>> q = new LinkedList<>();
		List<Integer> visited = new LinkedList<Integer>();

		q.offer(new Pair<Integer, String>(startValue, ""));

		while (!q.isEmpty()) {

			Pair<Integer, String> curr = q.poll();
			if (!visited.contains(curr.getKey())) {

				visited.add(curr.getKey());

				if (curr.getKey() == destValue) {
					return curr.getValue();
				} else {
					LinkedList<Pair<Integer, String>> dirs = bt.get(curr.getKey());

					for (Pair<Integer, String> p : dirs) {

						q.offer(new Pair(p.getKey(), curr.getValue() + p.getValue()));
					}
				}

			}

		}
		return "";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	void convertToMap(TreeNode par, TreeNode root, Map<Integer, LinkedList<Pair<Integer, String>>> bt) {

		if (root == null)
			return;

		if (root.left != null) {
			if (!bt.containsKey(root.val)) {
				bt.put(root.val, new LinkedList<Pair<Integer, String>>());
				bt.get(root.val).add(new Pair(root.left.val, "L"));
			} else {
				bt.get(root.val).add(new Pair(root.left.val, "L"));
			}
			convertToMap(root, root.left, bt);
		}

		if (root.right != null) {
			if (!bt.containsKey(root.val)) {
				bt.put(root.val, new LinkedList<Pair<Integer, String>>());
				bt.get(root.val).add(new Pair(root.right.val, "R"));
			} else {
				bt.get(root.val).add(new Pair(root.right.val, "R"));
			}
			convertToMap(root, root.right, bt);
		}

		if (par != null) {
			if (!bt.containsKey(root.val)) {
				bt.put(root.val, new LinkedList<Pair<Integer, String>>());
				bt.get(root.val).add(new Pair(par.val, "U"));
			} else {
				bt.get(root.val).add(new Pair(par.val, "U"));
			}
		}
	}

	void printTree(TreeNode root) {

		if (root == null)
			return;

		printTree(root.left);

		System.out.print(root.val + ", ");

		printTree(root.right);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(1);
		root.right = new TreeNode(2);

		root.left.left = new TreeNode(3);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(4);

		StepByStepDirectionInBTNode2Node rs = new StepByStepDirectionInBTNode2Node();

		rs.printTree(root);

		System.out.println(rs.getDirections(root, 3, 6));

	}

}
