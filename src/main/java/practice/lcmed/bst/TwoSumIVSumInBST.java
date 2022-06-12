package practice.lcmed.bst;

import java.util.LinkedList;
import java.util.List;

import lcmedium.TreeNode;

public class TwoSumIVSumInBST {

	List<Integer> e = new LinkedList<Integer>();

	public boolean findTarget(TreeNode root, int k) {

		if (root != null) {

			if (e.contains(root.val))
				return true;

			if (!e.contains(k - root.val)) {
				e.add(k - root.val);
			}

			if (findTarget(root.left, k))
				return true;
			if (findTarget(root.right, k))
				return true;
		}

		return false;

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(3);
		root.right = new TreeNode(6);

		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);

		root.right.right = new TreeNode(7);

		TwoSumIVSumInBST rs = new TwoSumIVSumInBST();
		System.out.println(rs.findTarget(root, 9));

	}

}
