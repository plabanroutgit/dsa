package lcmedium.trees;

import java.util.HashMap;
import java.util.Map;

import lcmedium.TreeNode;

class Btree2 {

	int preorderIndex;
	Map<Integer, Integer> inorderIndexMap;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		preorderIndex = 0;
		// build a hashmap to store value -> its index relations
		inorderIndexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}

		return arrayToTree(preorder, 0, preorder.length - 1);
	}

	private TreeNode arrayToTree(int[] preorder, int left, int right) {
		// if there are no elements to construct the tree
		if (left > right)
			return null;

		// select the preorder_index element as the root and increment it
		int rootValue = preorder[preorderIndex++];
		TreeNode root = new TreeNode(rootValue);

		// build left and right subtree
		// excluding inorderIndexMap[rootValue] element because it's the root
		root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
		root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
		return root;
	}
}

public class BTreeFromPreAndInOrderTraversal {

	public static void main(String[] args) {
		Btree2 tree = new Btree2();

		int[] preorder = { 3, 9, 1, 2, 20, 15, 7 }, inorder = { 1, 9, 2, 3, 15, 20, 7 };

		System.out.println("binary tree is");

		TreeNode rootNode = tree.buildTree(preorder, inorder);

	}

}
