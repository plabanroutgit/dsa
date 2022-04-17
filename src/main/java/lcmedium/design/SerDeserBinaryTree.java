package lcmedium.design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import lcmedium.TreeNode;

public class SerDeserBinaryTree {

	public String rserialize(TreeNode root, String str) {
		// Recursive serialization.
		if (root == null) {
			str += "null,";
		} else {
			str += str.valueOf(root.val) + ",";
			str = rserialize(root.left, str);
			str = rserialize(root.right, str);
		}
		return str;
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return rserialize(root, "");
	}

	public TreeNode rdeserialize(List<String> l) {
		// Recursive deserialization.
		if (l.get(0).equals("null")) {
			l.remove(0);
			return null;
		}

		TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
		l.remove(0);
		root.left = rdeserialize(l);
		root.right = rdeserialize(l);

		return root;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] data_array = data.split(",");
		List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
		return rdeserialize(data_list);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		
		// Your Codec object will be instantiated and called as such:
		SerDeserBinaryTree ser = new SerDeserBinaryTree();
		SerDeserBinaryTree deser = new SerDeserBinaryTree();
		TreeNode ans = deser.deserialize(ser.serialize(root));
	}
}
