package practice.lcmed.bt;

import lcmedium.TreeNode;
//https://www.youtube.com/watch?v=FX4cov9hWu0
public class SumNodesWithEvenGP {

	int sum = 0;

	public int sumEvenGrandparent(TreeNode root) {

		if (root == null)
			return 0;

		getsum(root, null, null);

		return sum;
	}

	public void getsum(TreeNode cur, TreeNode p, TreeNode gp) {

		if (cur == null)
			return;

		if (gp != null && gp.val % 2 == 0 ) {
			sum += cur.val;
		}

		if (cur.left != null)
			getsum(cur.left, cur, p);
		if (cur.right != null)
			getsum(cur.right, cur, p);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(6);

		root.left = new TreeNode(7);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);

		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(3);

		root.left.left.left = new TreeNode(9);

		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(4);

		root.right.right.right = new TreeNode(5);

		SumNodesWithEvenGP rs = new SumNodesWithEvenGP();

		// rs.printTree(root);

		System.out.println(rs.sumEvenGrandparent(root));

		// rs.printTree(root);

	}
}
