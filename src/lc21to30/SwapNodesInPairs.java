package lc21to30;

/**
 * @author Haoxiang Ma
 * Leetcode #24
 * Swap Nodes in Pairs
 */
public class SwapNodesInPairs {

	public static void main(String[] args) {
		SwapNodesInPairs solution = new SwapNodesInPairs();
	}

	/**
	 * 思路1: 另外实现一个reverse链表的方法, 遍历原链表, 每走过2个节点就调用一次
	 * reverse方法, 局部翻转。
	 * @param head head
	 * @return linkedlist after swap
	 */
	public ListNode swapPairs1(ListNode head) {
		if(head == null) {
			return head;
		}

		int count = 0;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode begin = dummy;
		ListNode cur = head;

		while(cur != null) {
			count++;
			if(count % 2 == 0) {	// 每走过2个节点, 翻转刚走过的那2个节点
				begin = reverse(begin, cur.next);
				cur = begin.next;
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}

	/**
	 * 思路2: 复杂的指针操作, 在遍历的过程中原地翻转。
	 * @param head head
	 * @return linkedlist after swap
	 */
	public ListNode swapPairs2(ListNode head) {
		if(head == null) {
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;

		// 原地操作指针进行翻转
		while(cur != null && cur.next != null) {
			ListNode next = cur.next;
			cur.next = next.next;
			prev.next = next;
			next.next = cur;
			prev = cur;
			cur = cur.next;
		}
		return dummy.next;
	}

	/**
	 * 原地翻转head和end之间的节点(不包括head和end)
	 * @param head head
	 * @param end end
	 * @return reversed linkedlist
	 */
	public ListNode reverse(ListNode head, ListNode end) {
		ListNode prev = head;
		ListNode backup = head.next;
		head = head.next;
		ListNode newHead = end;
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
