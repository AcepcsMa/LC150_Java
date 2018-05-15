package lc21to30;

/**
 * @author Haoxiang Ma
 * Leetcode #25
 * Reverse Nodes in k-Group
 */
public class ReverseNodesInKGroups {

	public static void main(String[] args) {
		ReverseNodesInKGroups solution = new ReverseNodesInKGroups();
	}

	/**
	 * 思路: 另外实现一个reverse方法用来翻转一段链表。遍历原链表,
	 * 每经过k个节点后, 就将刚刚经过的那k个节点进行翻转。
	 * @param head head
	 * @param k k
	 * @return linkedlist after reversal
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null) {
			return head;
		}

		int count = 0;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = head;
		ListNode begin = dummy;

		while(cur != null) {
			count++;
			if(count % k == 0) {
				begin = reverse(begin, cur.next);
				cur = begin.next;
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}

	/**
	 * 翻转head到end之间的链表(不包括head和end)
	 * @param head head
	 * @param end end
	 * @return reversed linkedlist
	 */
	public ListNode reverse(ListNode head, ListNode end) {
		ListNode backup = head.next;
		ListNode prev = head;
		ListNode newHead = end;
		head = head.next;
		while(head != end) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		prev.next = newHead;
		return backup;
	}
}
