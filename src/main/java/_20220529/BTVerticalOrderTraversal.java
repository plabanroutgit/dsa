package _20220529;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import lcmedium.TreeNode;

class Sort_Comparator implements Comparator<int[]> {

	@Override
	public int compare(int[] x, int[] y) {

		if (x[0] < y[0])
			return -1;
		if (x[0] > y[0])
			return 1;

		if (x[0] == y[0]) {
			if (x[2] < y[2])
				return -1;
			if (x[2] > y[2])
				return 1;

			if (x[2] == y[2]) {
				if (x[3] < y[3])
					return -1;
				if (x[3] > y[3])
					return 1;
			}
		}
		return 0;
	}
}

public class BTVerticalOrderTraversal {

	public List<List<Integer>> verticalOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<int[]> pq = new PriorityQueue<int[]>(new Sort_Comparator());

		dfs(pq, root, 0, 0, -1);

		int vLevel = Integer.MIN_VALUE;
		List<Integer> l = null;

		while (!pq.isEmpty()) {
			int[] p = pq.poll();
			if (vLevel != p[0]) {
				if (l != null)
					res.add(l);
				l = new ArrayList<Integer>();
			}
			l.add(p[1]);

			vLevel = p[0];
		}
		if (l != null)
			res.add(l);

		return res;
	}

	void dfs(Queue<int[]> p, TreeNode root, int vLevel, int height, int parentVLevel) {

		if (root == null)
			return;

		p.offer(new int[] { vLevel, root.val, height, parentVLevel });

		dfs(p, root.left, vLevel - 1, height + 1, vLevel);
		dfs(p, root.right, vLevel + 1, height + 1, vLevel);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);

		root.left = new TreeNode(9);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(0);

		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(7);

		root.left.right.left = new TreeNode(5);
		root.right.left.right = new TreeNode(2);

		BTVerticalOrderTraversal rs = new BTVerticalOrderTraversal();

		System.out.println(rs.verticalOrder(root));
	}

}
