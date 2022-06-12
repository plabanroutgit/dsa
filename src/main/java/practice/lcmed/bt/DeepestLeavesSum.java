package practice.lcmed.bt;

import java.util.ArrayDeque;
import java.util.Deque;

import javafx.util.Pair;
import lcmedium.TreeNode;

public class DeepestLeavesSum {

	@SuppressWarnings("unchecked")
	public int deepestLeavesSum(TreeNode root) {

		Deque<Pair<TreeNode, Integer>> s = new ArrayDeque<Pair<TreeNode, Integer>>();
		int deepestL = 0;
		int deepestSum = 0;

		if (root != null) {
			s.push(new Pair<TreeNode, Integer>(root, 0));
		}

		while (!s.isEmpty()) {
			Pair<TreeNode, Integer> t = s.pop();
			TreeNode cur = t.getKey();
			int curdeep = t.getValue();

			if (cur.left == null && cur.right == null) {

				if (deepestL == curdeep) {
					deepestSum += cur.val;
				}

				if (deepestL < curdeep) {
					deepestL = curdeep;
					deepestSum = cur.val;
				}

			} else {

				if (cur.left != null) {
					s.push(new Pair<TreeNode, Integer>(cur.left, curdeep + 1));
				}

				if (cur.right != null) {
					s.push(new Pair<TreeNode, Integer>(cur.right, curdeep + 1));
				}

			}

		}

		return deepestSum;
	}

	void printTree(TreeNode root) {

		if (root == null)
			return;

		printTree(root.left);

		System.out.print(root.val + ", ");

		printTree(root.right);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.left.left.left = new TreeNode(7);

		root.right.right = new TreeNode(6);

		root.right.right.right = new TreeNode(8);

		DeepestLeavesSum rs = new DeepestLeavesSum();

		// rs.printTree(root);

		System.out.println(rs.deepestLeavesSum(root));

		// rs.printTree(root);

	}
}
