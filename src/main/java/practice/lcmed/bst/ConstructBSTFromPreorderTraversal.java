package practice.lcmed.bst;

import lcmedium.TreeNode;

public class ConstructBSTFromPreorderTraversal {

	int idx = 0;
	int n = 0;
	int[] nodelist;

	void printTree(TreeNode root) {

		if (root == null)
			return;

		printTree(root.left);

		System.out.print(root.val + ", ");

		printTree(root.right);

	}

	public TreeNode bstFromPreorder(int[] preorder) {

		nodelist = preorder;
		n = nodelist.length;

		TreeNode root = helper(Integer.MIN_VALUE, Integer.MAX_VALUE);

		return root;
	}

	TreeNode helper(int lower, int upper) {

		if (idx == n)
			return null;

		int val = nodelist[idx];

		if (val < lower || val > upper)
			return null;
		
		idx++;
		TreeNode root = new TreeNode(val);

		root.left = helper(lower, val);
		root.right = helper(val, upper);

		return root;

	}

	public static void main(String[] args) {

		int[] preorder = { 7, 20, 19, 12 };

		ConstructBSTFromPreorderTraversal rs = new ConstructBSTFromPreorderTraversal();

		TreeNode root = rs.bstFromPreorder(preorder);

		rs.printTree(root);

	}
}
