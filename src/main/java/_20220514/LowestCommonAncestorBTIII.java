package _20220514;

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node parent;

	Node(int val) {
		this.val = val;
		left = null;
		right = null;
		parent = null;
	}

}

public class LowestCommonAncestorBTIII {

	public Node lowestCommonAncestor(Node p, Node q) {

		int pHeight = heightFromRoot(p);
		int qHeight = heightFromRoot(q);

		while (pHeight != qHeight) {
			if (pHeight > qHeight) {
				p = p.parent;
				pHeight -= 1;
			} else {
				q = q.parent;
				qHeight -= 1;
			}
		}

		while (p != q) {
			p = p.parent;
			q = q.parent;
		}

		return p;
	}

	int heightFromRoot(Node root) {

		if (root == null)
			return 0;

		return heightFromRoot(root.parent) + 1;
	}

	void printTree(Node root) {

		if (root == null)
			return;

		printTree(root.left);

		System.out.print(root.val + ", ");

		printTree(root.right);

	}

	public static void main(String[] args) {

		Node root = new Node(3);
		root.parent = null;

		root.left = new Node(5);
		root.left.parent = root;
		root.right = new Node(1);
		root.right.parent = root;

		root.left.left = new Node(6);
		root.left.left.parent = root.left;
		root.left.right = new Node(2);
		root.left.right.parent = root.left;

		root.right.left = new Node(0);
		root.right.left.parent = root.right;
		root.right.right = new Node(8);
		root.right.right.parent = root.right;

		root.left.right.left = new Node(7);
		root.left.right.left.parent = root.left.right;
		root.left.right.right = new Node(4);
		root.left.right.right.parent = root.left.right;

		LowestCommonAncestorBTIII rs = new LowestCommonAncestorBTIII();

		// rs.printTree(root);

		System.out.println(rs.lowestCommonAncestor(root.right.right, root.left.right.right).val);

	}
}
