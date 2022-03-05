package alimir;

public class ReverseLinkedListIterativePractice {

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;

		while (cur != null) {

			cur.next = prev;
			prev = cur;
			cur = cur.next;
		}
		return prev;
	}

}
