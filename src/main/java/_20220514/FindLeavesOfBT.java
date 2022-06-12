package _20220514;

import java.util.LinkedList;
import java.util.List;

import lcmedium.TreeNode;

public class FindLeavesOfBT {

	List<List<Integer>> lleaves = new LinkedList<List<Integer>>();

	public List<List<Integer>> findLeaves(TreeNode root) {

		while (root != null) {
			List<Integer> leaves = new LinkedList<Integer>();

			if (root.left == null && root.right == null) {
				leaves.add(root.val);
				root = null;
			}
			removeNreturnleaves(null, root, leaves);
			lleaves.add(leaves);
		}
		return lleaves;
	}

	void removeNreturnleaves(TreeNode parent, TreeNode root, List<Integer> leaves) {

		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			leaves.add(root.val);

			if (parent.left == root)
				parent.left = null;

			if (parent.right == root)
				parent.right = null;

		}

		removeNreturnleaves(root, root.left, leaves);
		removeNreturnleaves(root, root.right, leaves);

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

		FindLeavesOfBT rs = new FindLeavesOfBT();

		rs.printTree(root);

		System.out.println(rs.findLeaves(root));

	}

}
