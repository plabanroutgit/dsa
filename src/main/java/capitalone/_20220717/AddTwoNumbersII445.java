package capitalone._20220717;

import alimir.ListNode;

public class AddTwoNumbersII445 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		l1 = reverseList(l1);
		l2 = reverseList(l2);

		int carry = 0, sum = 0, nodeval = 0;
		ListNode head = null, curr = null;
		boolean loopOne = false;
		while (l1 != null && l2 != null) {

			sum = l1.val + l2.val + carry;
			carry = sum / 10;
			nodeval = sum % 10;
			if (!loopOne) {
				head = new ListNode(nodeval);
				curr = head;
				loopOne = true;
			} else {
				curr.next = new ListNode(nodeval);
				curr = curr.next;
			}
			l1 = l1.next;
			l2 = l2.next;
		}

		if (l1 != null) {
			while (l1 != null) {

				sum = l1.val + carry;
				carry = sum / 10;
				nodeval = sum % 10;
				if (!loopOne) {
					head = new ListNode(nodeval);
					curr = head;
				} else {
					curr.next = new ListNode(nodeval);
					curr = curr.next;
				}
				l1 = l1.next;
			}
		} else {
			while (l2 != null) {

				sum = l2.val + carry;
				carry = sum / 10;
				nodeval = sum % 10;
				if (!loopOne) {
					head = new ListNode(nodeval);
					curr = head;
				} else {
					curr.next = new ListNode(nodeval);
					curr = curr.next;
				}
				l2 = l2.next;
			}
		}

		if (carry != 0) {
			curr.next = new ListNode(carry);
		}

		head = reverseList(head);
		return head;
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
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

		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		AddTwoNumbersII445 at = new AddTwoNumbersII445();

		at.printLL(l1);
		at.printLL(l2);

		ListNode newHead = at.addTwoNumbers(l1, l2);

		at.printLL(newHead);

	}

}
