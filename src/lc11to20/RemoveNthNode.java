package lc11to20;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

/**
 * @author Haoxiang Ma
 * Leetcode #19
 * Remove Nth Node From End of List
 */
public class RemoveNthNode {

	public static void main(String[] args) {
		RemoveNthNode solution = new RemoveNthNode();
	}

	/**
	 * 思路: 要删除倒数第N个节点。假设链长为X, 可先设置一个fast pointer先从头开始走N步,
	 * 然后让另一个slow pointer也从头开始走, 当fast pointer走到了链尾, slow pointer
	 * 也走了(X-N)步, 即slow pointer到达了该删除的节点处。
	 * @param head head
	 * @param n n
	 * @return removed linkedlist
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n <= 0) {
			return head;
		}

		ListNode fast = head;
		ListNode slow = head;

		// fast pointer先走N步
		for(int i = 0;i < n;i++) {
			fast = fast.next;
			if(fast == null) {
				return slow.next;
			}
		}

		// slow pointer开始走(X-N)步
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;
		return head;
	}
}
