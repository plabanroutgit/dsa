package practice.lcmed.bst;

import java.util.Stack;

import lcmedium.TreeNode;
//https://leetcode.com/problems/binary-search-tree-iterator-ii/solution/
public class BstIteratorII {

	TreeNode cur = null;
	public Stack<TreeNode> s;

	public BstIteratorII(TreeNode root) {

		s = new Stack<TreeNode>();

		if (root != null) {
			s.add(root);
			cur = root.left;

			while (cur != null) {
				s.add(cur);
				cur = cur.left;
			}
		}
	}

	public boolean hasNext() {

		return !s.isEmpty();

	}

	public int next() {

		TreeNode nxtNode = s.pop();

		cur = nxtNode.right;
		while (cur != null) {
			s.add(cur);
			cur = cur.left;
		}

		return nxtNode.val;
	}

	void printTree(TreeNode root) {

		if (root == null)
			return;

		printTree(root.left);

		System.out.print(root.val + ", ");

		printTree(root.right);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);

		root.left = new TreeNode(1);
		root.right = new TreeNode(33);

		root.left.left = new TreeNode(0);

		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(40);

		root.right.left.left = new TreeNode(11);
		root.right.right.left = new TreeNode(34);

		root.right.left.left.left = new TreeNode(7);
		root.right.left.left.right = new TreeNode(12);

		root.right.left.left.right.right = new TreeNode(13);

		root.right.right.left.right = new TreeNode(36);

		BstIteratorII rs = new BstIteratorII(root);

		rs.printTree(root);

		System.out.println(rs.next());

		System.out.println(rs.next());

		System.out.println(rs.next());
		System.out.println(rs.next());
		System.out.println(rs.next());
		System.out.println(rs.next());

		System.out.println(rs.hasNext());

		System.out.println(rs.next());
		System.out.println(rs.next());
		System.out.println(rs.next());
		System.out.println(rs.next());

	}
}
