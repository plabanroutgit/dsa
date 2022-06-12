package practice.lcmed.bst;

import java.util.ArrayList;
import java.util.List;

import lcmedium.TreeNode;

public class CountNodesSumOfDescendants {

	List<Integer> ls = new ArrayList<Integer>();

	void printTree(TreeNode root) {

		if (root == null)
			return;

		printTree(root.left);

		System.out.print(root.val + ", ");

		printTree(root.right);

	}

	int count = 0;

	public int equalToDescendants(TreeNode root) {

		helper(root);

		return count;

	}

	public int helper(TreeNode root) {

		if (root == null)
			return 0;

		int lsum = helper(root.left);
		int rsum = helper(root.right);

		if (lsum + rsum == root.val)
			count++;

		return lsum + rsum + root.val;

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);

		root.left = new TreeNode(3);
		root.right = new TreeNode(4);

		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(1);

		CountNodesSumOfDescendants rs = new CountNodesSumOfDescendants();

		System.out.println(rs.equalToDescendants(root));

	}
}
