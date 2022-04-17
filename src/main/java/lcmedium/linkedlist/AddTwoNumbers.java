package lcmedium.linkedlist;

import alimir.ListNode;
import alimir.MyLinkedList1;

public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode fake = new ListNode(0);
		ListNode p = fake;

		ListNode p1 = l1;
		ListNode p2 = l2;

		int carry = 0;
		while (p1 != null || p2 != null) {
			int sum = carry;
			if (p1 != null) {
				sum += p1.val;
				p1 = p1.next;
			}

			if (p2 != null) {
				sum += p2.val;
				p2 = p2.next;
			}

			if (sum > 9) {
				carry = 1;
				sum = sum - 10;
			} else {
				carry = 0;
			}

			ListNode l = new ListNode(sum);
			p.next = l;
			p = p.next;
		}

		// don't forget check the carry value at the end
		if (carry > 0) {
			ListNode l = new ListNode(carry);
			p.next = l;
		}
		return fake.next;
	}

	static void printList(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + " -> ");
			cur = cur.next;
		}
		System.out.println();
	};

	public static void main(String[] args) {
		
		MyLinkedList1 l1 = new MyLinkedList1();

		l1.addAtHead(2);
		l1.addAtTail(4);
		l1.addAtTail(3);

		printList(l1.getHead());

		MyLinkedList1 l2 = new MyLinkedList1();

		l2.addAtHead(5);
		l2.addAtTail(6);
		l2.addAtTail(4);

		printList(l2.getHead());
		
		System.out.println(l1.getHead().val);
		System.out.println(l2.getHead().val);

		ListNode res = addTwoNumbers(l1.getHead(), l2.getHead());

		printList(res);

	}

}
