package practice.lcmed.bst;

import lcmedium.TreeNode;

public class IncreasingOrderSearchTree {

	TreeNode cur = null;

	public void printTree(TreeNode root) {

		if (root == null) {
			System.out.print("$$");
			return;
		} else {
			System.out.print(root.val + " ");
		}

		printTree(root.left);
		printTree(root.right);

	}

	private void inorder(TreeNode node) {
		if (node == null)
			return;
		inorder(node.left);
		node.left = null;
		cur.right = node;
		cur = cur.right;
		inorder(node.right);

	}

	private TreeNode increasingBST(TreeNode root) {

		TreeNode ans = new TreeNode(0);
		cur = ans;
		inorder(root);
		return ans.right;

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);

		root.left = new TreeNode(1);
		root.right = new TreeNode(4);

		root.right.left = new TreeNode(3);

		IncreasingOrderSearchTree rs = new IncreasingOrderSearchTree();
		TreeNode rt = rs.increasingBST(root);

		System.out.println();
		rs.printTree(rt);
	}

}
