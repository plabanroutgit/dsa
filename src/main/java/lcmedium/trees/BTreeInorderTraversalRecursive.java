package lcmedium.trees;

import java.util.ArrayList;
import java.util.List;

import lcmedium.TreeNode;
//TC: O(n) SC: O(n)
public class BTreeInorderTraversalRecursive {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}

	public void helper(TreeNode root, List<Integer> res) {
		if (root != null) {
			helper(root.left, res);
			res.add(root.val);
			helper(root.right, res);
		}
	}
}
