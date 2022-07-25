package capitalone._20220716;

import lcmedium.TreeNode;
//https://www.youtube.com/watch?v=EW_eWjP2pAM&t=893s
public class BinaryTreePruning814 {

	public TreeNode pruneTree(TreeNode root) {
		return dfs(root);
	}

	TreeNode dfs(TreeNode root) {

		if (root == null)
			return null;

		root.left = dfs(root.left);
		root.right = dfs(root.right);

		if (root.left != null || root.right != null)
			return root;

		if (root.val == 0)
			return null;

		return root;
	}

	void printTree(TreeNode root) {

		if (root == null)
			return;

		printTree(root.left);
		System.out.print(root.val + ", ");
		printTree(root.right);

	}

	public static void main(String[] args) {

		// Ex1
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(0);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(0);

		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);

		BinaryTreePruning814 btp = new BinaryTreePruning814();
		btp.printTree(root);
		System.out.println();
		btp.pruneTree(root);

		btp.printTree(root);

		// Ex2
		System.out.println();
		TreeNode root1 = new TreeNode(1);

		root1.right = new TreeNode(0);

		root1.right.left = new TreeNode(0);
		root1.right.right = new TreeNode(1);

		btp.printTree(root1);
		System.out.println();
		btp.pruneTree(root1);

		btp.printTree(root1);

	}

}
