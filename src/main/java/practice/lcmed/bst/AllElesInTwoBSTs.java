package practice.lcmed.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lcmedium.TreeNode;

//https://www.youtube.com/watch?v=B97Hk1H2x2s
public class AllElesInTwoBSTs {

	List<Integer> ls = new ArrayList<Integer>();

	void printTree(TreeNode root) {

		if (root == null)
			return;

		printTree(root.left);

		System.out.print(root.val + ", ");

		printTree(root.right);

	}

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		List<Integer> ls = new ArrayList<Integer>();

		TreeNode cur1 = root1;
		TreeNode cur2 = root2;

		while (cur1 != null || cur2 != null || !s1.isEmpty() || !s2.isEmpty()) {

			while (cur1 != null) {
				s1.push(cur1);
				cur1 = cur1.left;
			}

			while (cur2 != null) {
				s2.push(cur2);
				cur2 = cur2.left;
			}

			if (!s1.isEmpty() && !s2.isEmpty()) {

				TreeNode val1 = s1.peek();
				TreeNode val2 = s2.peek();

				if (val1.val < val2.val) {
					ls.add(val1.val);
					cur1 = s1.pop();
					cur1 = cur1.right;

				} else {
					ls.add(val2.val);
					cur2 = s2.pop();
					cur2 = cur2.right;

				}
			} else if (!s1.isEmpty() && s2.isEmpty()) {
				TreeNode val1 = s1.peek();
				ls.add(val1.val);
				cur1 = s1.pop();
				cur1 = cur1.right;

			} else if (!s2.isEmpty() && s1.isEmpty()) {
				TreeNode val2 = s2.peek();
				ls.add(val2.val);
				cur2 = s2.pop();
				cur2 = cur2.right;
			}

		}
		return ls;
	}

	public static void main(String[] args) {

		TreeNode root1 = new TreeNode(20);

		root1.left = new TreeNode(11);
		root1.right = new TreeNode(22);

		TreeNode root2 = new TreeNode(13);

		root2.left = new TreeNode(8);
		root2.right = new TreeNode(15);

		root2.left.left = new TreeNode(5);
		root2.left.right = new TreeNode(10);

		root2.left.right.left = new TreeNode(9);

		AllElesInTwoBSTs rs = new AllElesInTwoBSTs();

		List<Integer> lst = rs.getAllElements(root1, root2);

		System.out.println(lst);

	}
}
