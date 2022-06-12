package _20220513;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lcmedium.TreeNode;

//https://www.youtube.com/watch?v=nZtrZPTTCAo
public class AllPossibleFBTs {

	Map<Integer, List<TreeNode>> memo = new HashMap<Integer, List<TreeNode>>();

	public List<TreeNode> allPossibleFBT(int n) {

		return backtrack(n);

	}

	List<TreeNode> backtrack(int n) {

		if (n == 0) {
			List<TreeNode> lt = new LinkedList<TreeNode>();
			memo.put(0, lt);
			return lt;
		}

		if (n == 1) {
			List<TreeNode> lt = new LinkedList<TreeNode>();
			lt.add(new TreeNode(0));
			memo.put(1, lt);
			return lt;
		}

		if (memo.containsKey(n)) {
			return memo.get(n);
		}

		List<TreeNode> res = new LinkedList<TreeNode>();
		for (int l = 0; l < n - 1; l++) {
			int r = n - 1 - l;
			List<TreeNode> ltrees = backtrack(l);
			List<TreeNode> rtrees = backtrack(r);

			for (TreeNode t1 : ltrees) {
				for (TreeNode t2 : rtrees) {
					TreeNode t = new TreeNode(0);
					t.left = t1;
					t.right = t2;

					res.add(t);
				}
			}
		}
		memo.put(n, res);
		return res;
	}

	void printTree(TreeNode root) {

		if (root == null)
			return;

		printTree(root.left);

		System.out.print(root.val + ", ");

		printTree(root.right);

	}

	public static void main(String[] args) {

		AllPossibleFBTs fbt = new AllPossibleFBTs();

		List<TreeNode> lt = fbt.allPossibleFBT(7);

		for (TreeNode treeNode : lt) {
			fbt.printTree(treeNode);
			System.out.println();
		}

	}
}
