package lceasy.trees;

import java.util.ArrayDeque;
import java.util.Deque;

import lcmedium.TreeNode;

public class ValidBinarySearchTreeIterativeInorderTraversal {

	public boolean isValidBST(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		Integer prev = null;

		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			// If next element in inorder traversal
			// is smaller than the previous one
			// that's not BST.
			if (prev != null && root.val <= prev) {
				return false;
			}
			prev = root.val;
			root = root.right;
		}
		return true;
	}

}
