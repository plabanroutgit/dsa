package capitalone._20220716;

import alimir.ListNode;

public class ReverseNodesInKgrp25 {

	public ListNode reverseKGroup(ListNode head, int k) {

		ListNode p1 = head;
		ListNode newHead = null;
		ListNode tmpHead = null;
		boolean loopOne = false;
		ListNode p3 = null;
		while (p1 != null) {
			ListNode p2 = p1;

			int i = k;
			while (i > 0 && p2 != null) {
				p2 = p2.next;
				i--;
			}

			if (i <= 0) {
				if (!loopOne) {

					newHead = reverseSubgrp(p1, p2, k);
					loopOne = true;
				} else {
					tmpHead = reverseSubgrp(p1, p2, k);
					p3.next = tmpHead;
				}
				p3 = p1;
				p1 = p2;
			} else {
				break;
			}
		}

		return newHead;
	}

	ListNode reverseSubgrp(ListNode p1, ListNode p2, int k) {

		ListNode prev = p2;
		ListNode curr = p1;
		int i = k;

		while (i-- > 0) {
			ListNode tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}

		return prev;
	}

	public void printLL(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);

		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);

		ReverseNodesInKgrp25 rev = new ReverseNodesInKgrp25();

		rev.printLL(head);
		head = rev.reverseKGroup(head, 3);
		rev.printLL(head);

	}

}
