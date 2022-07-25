package _20220704;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Pos {
	int x;
	int y;
	TreeNode tn;

	Pos(int x, int y, TreeNode tn) {
		this.x = x;
		this.y = y;
		this.tn = tn;
	}
}

public class VerticalOrderTraversalOfaBT {

	public List<List<Integer>> verticalTraversal(TreeNode root) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		List<Pos> p = new ArrayList<Pos>();
		visitNode(new Pos(0, 0, root), p);

		Collections.sort(p, new Comparator<Pos>() {
			@Override
			public int compare(Pos p1, Pos p2) {
				if (p1.y == p2.y) {
					if (p1.x == p2.x) {
						return p1.tn.val - p2.tn.val;
					} else {
						return p1.x - p2.x;
					}
				} else {
					return p1.y - p2.y;
				}
			}
		});

		int firstcol = p.get(0).y;
		List<Integer> t = new ArrayList<Integer>();
		for (Pos pos : p) {

			System.out.println(pos.tn.val);

			if (firstcol == pos.y) {
				t.add(pos.tn.val);
			} else {
				firstcol = pos.y;
				res.add(t);
				t = new ArrayList<Integer>();
				t.add(pos.tn.val);
			}

		}
		res.add(t);
		return res;
	}

	void visitNode(Pos r, List<Pos> pos) {

		if (r.tn == null)
			return;

		pos.add(r);
		visitNode(new Pos(r.x + 1, r.y - 1, r.tn.left), pos);
		visitNode(new Pos(r.x + 1, r.y + 1, r.tn.right), pos);
	}

	void printTree(TreeNode root) {

		if (root == null)
			return;

		printTree(root.left);
		System.out.print(root.val + ", ");
		printTree(root.right);

		System.out.println();

	}

	public static void main(String[] args) {

		VerticalOrderTraversalOfaBT vo = new VerticalOrderTraversalOfaBT();

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println("Next pointer binary tree is");
		vo.printTree(root);

		System.out.println(vo.verticalTraversal(root));

	}

}
