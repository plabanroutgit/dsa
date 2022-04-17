package lchard.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

import alimir.ListNode;


//https://www.programcreek.com/2013/02/leetcode-merge-k-sorted-lists-java/
public class MergekSortedLists {

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});

		ListNode head = new ListNode(0);
		ListNode p = head;

		for (ListNode list : lists) {
			if (list != null)
				queue.offer(list);
		}

		while (!queue.isEmpty()) {
			ListNode n = queue.poll();
			p.next = n;
			p = p.next;

			if (n.next != null)
				queue.offer(n.next);
		}

		return head.next;

	}

	public static void main(String[] args) {

		ListNode l1 = new ListNode();
		l1.val = 1;
		ListNode l2 = new ListNode();
		l2.val = 4;
		ListNode l3 = new ListNode();
		l3.val = 5;
		l1.next = l2;
		l2.next = l3;

		ListNode n1 = new ListNode();
		n1.val = 1;
		ListNode n2 = new ListNode();
		n2.val = 3;
		ListNode n3 = new ListNode();
		n3.val = 4;
		n1.next = n2;
		n2.next = n3;

		ListNode m1 = new ListNode();
		m1.val = 2;
		ListNode m2 = new ListNode();
		m2.val = 6;
		m1.next = m2;

		ListNode[] lists = { l1, n1, m1 };

		
		ListNode r = mergeKLists(lists);
		
		// {[1,4,5],[1,3,4],[2,6]};
	}

}
