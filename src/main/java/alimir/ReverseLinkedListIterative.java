package alimir;


//T: O(n)
//S: O(1) Good compared to Recursive approach
public class ReverseLinkedListIterative {
	public ListNode reverseList(ListNode head) {
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
}
