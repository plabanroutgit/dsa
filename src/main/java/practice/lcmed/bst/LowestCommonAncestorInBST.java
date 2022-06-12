package practice.lcmed.bst;

import lcmedium.TreeNode;

public class LowestCommonAncestorInBST {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {

			return root;
		}

	}

	public boolean search(TreeNode root, TreeNode node) {

		if (root == null)
			return false;
		if (root.val == node.val)
			return true;
		if (search(root.left, node) || search(root.right, node))
			return true;

		return false;
	}

	public static void main(String[] args) {

		/*
		 * TreeNode root = new TreeNode(6);
		 * 
		 * root.left = new TreeNode(2); root.right = new TreeNode(8);
		 * 
		 * root.left.left = new TreeNode(0); root.left.right = new TreeNode(4);
		 * 
		 * root.left.right.left = new TreeNode(3); root.left.right.right = new
		 * TreeNode(5);
		 * 
		 * root.right.left = new TreeNode(7); root.right.right = new TreeNode(9);
		 * 
		 * LowestCommonAncestorInBST rs = new LowestCommonAncestorInBST();
		 * System.out.println(rs.lowestCommonAncestor(root, new TreeNode(8), new
		 * TreeNode(9)).val);
		 */

		TreeNode root = new TreeNode(2);

		root.left = new TreeNode(1);
		root.right = null;

		LowestCommonAncestorInBST rs = new LowestCommonAncestorInBST();
		System.out.println(rs.lowestCommonAncestor(root, new TreeNode(1), new TreeNode(2)).val);

	}

}
