package practice.lcmed.bst;

import lcmedium.TreeNode;

public class BstToGst {

	public int sum = 0;

	public TreeNode bstToGst(TreeNode root) {

		TreeNode org = root;

		inorder(root);

		return org;
	}

	public void inorder(TreeNode root) {

		if (root == null)
			return;

		inorder(root.right);

		root.val += sum;
		sum = root.val;

		inorder(root.left);

	}

	void printTree(TreeNode root) {

		if (root == null)
			return;

		printTree(root.left);

		System.out.print(root.val + ", ");

		printTree(root.right);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);

		root.left = new TreeNode(1);
		root.right = new TreeNode(6);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);

		root.left.right.right = new TreeNode(3);

		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);

		root.right.right.right = new TreeNode(8);

		BstToGst rs = new BstToGst();

		rs.printTree(root);

		System.out.println(rs.bstToGst(root).val);

		rs.printTree(root);

	}
}
