package practice.lcmed.bst;

import java.util.ArrayList;
import java.util.List;

import lcmedium.TreeNode;

public class BalanceABst {

	List<TreeNode> nodes = new ArrayList<TreeNode>();

	public void collectNodes(TreeNode root) {
		if (root == null)
			return;
		collectNodes(root.left);
		nodes.add(root);
		collectNodes(root.right);
	}

	public TreeNode balanceBST(TreeNode root) {

		collectNodes(root);

		TreeNode New = callbalanceBST(nodes, 0, nodes.size() - 1);

		return New;
	}

	public TreeNode callbalanceBST(List<TreeNode> nodes, int s, int e) {

		if (s > e)
			return null;

		int mid = s + (e - s) / 2;

		TreeNode nNode = nodes.get(mid);

		nNode.left = callbalanceBST(nodes, s, mid - 1);
		nNode.right = callbalanceBST(nodes, mid + 1, e);

		return nNode;

	}

	public int height(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int lheight = height(root.left);
		int rheight = height(root.right);

		return lheight > rheight ? lheight + 1 : rheight + 1;

	}

	void printTree(TreeNode root) {

		if (root == null)
			return;

		printTree(root.left);

		System.out.print(root.val + ", ");

		printTree(root.right);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);

		root.right = new TreeNode(2);

		root.right.right = new TreeNode(3);

		root.right.right.right = new TreeNode(4);

		BalanceABst rs = new BalanceABst();

		// rs.printTree(root);

		rs.balanceBST(root);

		// rs.printTree(root);

	}
}
