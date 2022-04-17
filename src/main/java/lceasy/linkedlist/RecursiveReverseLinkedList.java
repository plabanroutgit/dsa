package lceasy.linkedlist;

import alimir.ListNode;

//T: O(n)
//S: O(n)
public class RecursiveReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
}
// Test with 1 -> 2 -> NULL