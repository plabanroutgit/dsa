package lcmedium.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lcmedium.TreeNode;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solution/
//TC:o(n) SC: o(H) h height of the tree
class Btree1 {

	TreeNode rootNode;

	protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
		if (level >= results.size()) {
			LinkedList<Integer> newLevel = new LinkedList<Integer>();
			newLevel.add(node.val);
			results.add(newLevel);
		} else {
			if (level % 2 == 0)
				results.get(level).add(node.val);
			else
				results.get(level).add(0, node.val);
		}

		if (node.left != null)
			DFS(node.left, level + 1, results);
		if (node.right != null)
			DFS(node.right, level + 1, results);
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		DFS(root, 0, results);
		return results;
	}
}

public class BTreeZigZagLevelOrderTraversalDFS {

	public static void main(String[] args) {
		Btree1 tree = new Btree1();
		tree.rootNode = new TreeNode(1);
		tree.rootNode.left = new TreeNode(2);
		tree.rootNode.right = new TreeNode(3);
		tree.rootNode.left.left = new TreeNode(7);
		tree.rootNode.left.right = new TreeNode(6);
		tree.rootNode.right.left = new TreeNode(5);
		tree.rootNode.right.right = new TreeNode(4);

		System.out.println("ZigZag Order traversal of binary tree is");
		List<List<Integer>> al = tree.zigzagLevelOrder(tree.rootNode);
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}

	}
}
