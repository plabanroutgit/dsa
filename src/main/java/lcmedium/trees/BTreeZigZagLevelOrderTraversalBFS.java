package lcmedium.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lcmedium.TreeNode;
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solution/
//TC:o(n) SC: o(n)
//Prefer this rather than DFS
class Btree {

	TreeNode rootNode;

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}

		List<List<Integer>> results = new ArrayList<List<Integer>>();

		// add the root element with a delimiter to kick off the BFS loop
		LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
		node_queue.addLast(root);
		node_queue.addLast(null);

		LinkedList<Integer> level_list = new LinkedList<Integer>();
		boolean is_order_left = true;

		while (node_queue.size() > 0) {
			TreeNode curr_node = node_queue.pollFirst();
			if (curr_node != null) {
				if (is_order_left)
					level_list.addLast(curr_node.val);
				else
					level_list.addFirst(curr_node.val);

				if (curr_node.left != null)
					node_queue.addLast(curr_node.left);
				if (curr_node.right != null)
					node_queue.addLast(curr_node.right);

			} else {
				// we finish the scan of one level
				results.add(level_list);
				level_list = new LinkedList<Integer>();
				// prepare for the next level
				if (node_queue.size() > 0)
					node_queue.addLast(null);
				is_order_left = !is_order_left;
			}
		}
		return results;
	}
}

public class BTreeZigZagLevelOrderTraversalBFS {

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