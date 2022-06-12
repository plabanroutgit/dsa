package practice.lcmed.bst;

import lcmedium.TreeNode;

public class ClosestBSTvalue {

	public int cvalue = 0;

	public int closestValue(TreeNode root, double target) {

		double closest = Double.MAX_VALUE;

		inorder(root, target, closest);

		return cvalue;
	}

	void inorder(TreeNode root, double target, double closest) {

		if (root == null)
			return;

		if (Math.abs(root.val - target) < closest) {
			cvalue = root.val;
			closest = Math.abs(root.val - target);
		}

		inorder(root.left, target, closest);
		inorder(root.right, target, closest);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);

		root.left = new TreeNode(2);
		root.right = new TreeNode(5);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		ClosestBSTvalue rs = new ClosestBSTvalue();
		System.out.println(rs.closestValue(root, 3.714286));

	}

}
