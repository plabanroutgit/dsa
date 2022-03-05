package alimir;

//T: O(n)
//S: O(n)
public class ReverseLinkedListRecursive {
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
//         head  p

