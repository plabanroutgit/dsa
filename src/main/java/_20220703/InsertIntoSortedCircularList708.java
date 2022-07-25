package _20220703;

//https://www.youtube.com/watch?v=8xKMP0kTnvU
class Node {
	int val;
	Node next;

	Node(int val) {
		this.val = val;
		next = null;
	}

	Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}
}

public class InsertIntoSortedCircularList708 {

	public Node insert(Node head, int insertVal) {

		if (head == null) {
			Node node = new Node(insertVal);
			node.next = node;
			return node;
		}

		Node cur = head;
		Node curNext = head.next;

		while (curNext != head) {

			if (insertVal >= cur.val && insertVal <= curNext.val) {
				break;
			}

			if (cur.val > curNext.val) {

				if (insertVal <= cur.val && insertVal <= curNext.val) {
					break;
				}

				if (insertVal >= cur.val && insertVal >= curNext.val) {
					break;
				}
			}
			cur = cur.next;
			curNext = cur.next;
		}

		Node tmp = curNext;
		Node n = new Node(insertVal);
		cur.next = n;
		n.next = tmp;
		return head;
	}

	public static void main(String[] args) {
		InsertIntoSortedCircularList708 in = new InsertIntoSortedCircularList708();

	}
}
