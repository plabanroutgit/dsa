package practice.lcmed.bst;

import lcmedium.TreeNode;

public class RangeSumInBST {

	int sum = 0;

	private int getSum(TreeNode root, int low, int high) {

		if (root == null)
			return 0;
		else if (root.val >= low && root.val <= high)
			sum += root.val;

		if (root.left != null && low < root.val)
			getSum(root.left, low, high);
		if (root.right != null && high > root.val)
			getSum(root.right, low, high);

		return sum;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);

		root.left = new TreeNode(5);
		root.right = new TreeNode(15);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);

		root.right.right = new TreeNode(18);

		RangeSumInBST rs = new RangeSumInBST();
		System.out.println(rs.getSum(root, 7, 15));

	}

}
