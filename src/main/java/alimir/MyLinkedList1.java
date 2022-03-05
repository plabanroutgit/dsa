package alimir;

public class MyLinkedList1 {

	private static ListNode head;

	public MyLinkedList1() {
		head = null;
	}

	/** Helper function to return the index-th node in the linked list. */
	ListNode getNode(int index) {
		ListNode cur = head;

		if (cur == null)
			return cur;

		for (int i = 0; i < index && cur != null; i++) {
			cur = cur.next;
		}

		return cur;
	}

	/** Helper function to return the last node in the linked list. */
	private ListNode getTail() {
		ListNode cur = head;

		if (cur == null)
			return cur;

		while (cur.next != null)
			cur = cur.next;

		return cur;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {

		ListNode cur = getNode(index);

		return cur == null ? -1 : cur.val;

	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		ListNode cur = new ListNode(val);

		if (head == null) {
			head = cur;
		} else {
			cur.next = head;
			head = cur;
		}

	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		ListNode n = new ListNode(val);

		ListNode cur = getTail();

		if (cur == null)
			head = n;
		else {
			cur.next = n;
		}
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		ListNode n = new ListNode(val);
		ListNode prev = getNode(index - 1);

		if (index == 0) {
			n.next = head;
			head = n;
		} else {
			n.next = prev.next;
			prev.next = n;
		}

	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {

		if (index == 0) {
			head = head.next;
		} else {
			ListNode prev = getNode(index - 1);
			prev.next = prev.next.next;
		}

	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode tmp = cur.next;

			cur.next = prev;
			prev = cur;
			cur = tmp;
		}
		return prev;
	}

	public static void main(String[] args) {
		MyLinkedList1 mll1 = new MyLinkedList1();

		mll1.addAtHead(10);
		mll1.addAtTail(20);
		mll1.addAtHead(30);
		mll1.addAtHead(400);
		mll1.addAtIndex(1, 70);
		mll1.deleteAtIndex(2);

		System.out.println(mll1.get(0));

		head = reverseList(head);

		System.out.println(mll1.get(0));
	}

}
