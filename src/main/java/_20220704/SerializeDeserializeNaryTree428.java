package _20220704;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//https://www.youtube.com/watch?v=MKZwpFtpmmM&t=313s
class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};

public class SerializeDeserializeNaryTree428 {

	final String X = "X";
	final String COMMA = ",";

	StringBuilder sb = new StringBuilder();

	public String serialize(Node root) {

		if (root == null)
			return X;

		encode(root);

		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();

	}

	private void encode(Node root) {

		sb.append(root.val);
		sb.append(COMMA);

		List<Node> l = root.children;

		if (l != null) {
			for (Node node : l) {
				encode(node);
			}
		}

		sb.append(X);
		sb.append(COMMA);
	}

	String[] varr;
	int index = 0;

	public Node deserialize(String s) {

		final String X = "X";
		final String COMMA = ",";

		varr = s.split(COMMA);

		return decode();
	}

	public Node decode() {

		String currItem = varr[index++];

		if (currItem == X)
			return null;

		List<Node> children = new LinkedList<Node>();
		while (index < varr.length) {
			Node child = decode();
			if (child != null) {
				children.add(child);
			} else {
				break;
			}
		}

		Node node = new Node(Integer.parseInt(currItem), children);
		return node;
	}

	public static void main(String[] args) {

		Node n5 = new Node(5, null);
		Node n6 = new Node(6, null);

		List<Node> l3 = new ArrayList<Node>();
		l3.add(n5);
		l3.add(n6);
		Node n3 = new Node(3, l3);

		Node n2 = new Node(2, null);
		Node n4 = new Node(4, null);

		List<Node> l1 = new ArrayList<Node>();
		l1.add(n3);
		l1.add(n2);
		l1.add(n4);
		Node root = new Node(1, l1);

		SerializeDeserializeNaryTree428 ser = new SerializeDeserializeNaryTree428();

		System.out.println(ser.serialize(root));

	}

}
