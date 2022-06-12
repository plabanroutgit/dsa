package _20220606;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Node {
	public int val;
	public Node left;
	public Node right;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right) {
		val = _val;
		left = _left;
		right = _right;
	}
};

public class ConvertBTtoSortedDoubleLL426 {

	public Node treeToDoublyList(Node root) {

		Deque<Node> stack = new ArrayDeque<Node>();

		inorder(root, stack);

		Node head = null, tail = null, curr;
		if (!stack.isEmpty()) {
			tail = stack.pollLast();
		} else {
			return head;
		}
		
		head = tail;
		while (!stack.isEmpty()) {

			curr = stack.pollLast();
			head.left = curr;
			curr.right = head;
			head = curr;

		}

		head.left = tail;
		tail.right = head;

		return head;
	}

	void inorder(Node root, Deque<Node> stack) {

		if (root == null)
			return;
		inorder(root.left, stack);
		stack.offer(root);
		inorder(root.right, stack);
	}

	public static void main(String[] args) {

		Node root = new Node(4);

		root.left = new Node(2);
		root.right = new Node(5);

		root.left.left = new Node(1);
		root.left.right = new Node(3);

		ConvertBTtoSortedDoubleLL426 rs = new ConvertBTtoSortedDoubleLL426();

		// rs.printTree(root);

		System.out.println(rs.treeToDoublyList(root).val);

	}

}
