package practice.lcmed.bst;

import lcmedium.TreeNode;

public class MinimumAbsDiffInBST {

	public int getMinimumDifference(TreeNode root) {

		int min = 0;

		if (root == null)
			return min;

		min = minfunc(root, min);

		return min;
	}

	public int minfunc(TreeNode root, int min) {

		if (root.left != null && root.right != null)
			min = Math.min(root.right.val - root.val, root.val - root.left.val);
		else if (root.left == null && root.right != null)
			min = Math.min(min, root.right.val - root.val);
		else if (root.left != null && root.right == null)
			min = Math.min(min, root.val - root.left.val);
		else
			return min;

		min = minfunc(root.left, min);
		min = minfunc(root.right, min);

		return min;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(6);

		root.left = new TreeNode(2);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);

		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		MinimumAbsDiffInBST rs = new MinimumAbsDiffInBST();
		System.out.println(rs.getMinimumDifference(root));

	}

}
