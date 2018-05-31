package lc61to70;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

/**
 * @author Haoxiang Ma
 * Leetcode #61
 * Rotate List
 */
public class RotateList {

	public static void main(String[] args) {
		RotateList solution = new RotateList();
	}

	/**
	 * 思路: 向右移动k位, 如果k > 链表长度, 则先让k % length求出实际位移。
	 * 然后再用快慢指针的思想, 定位到应该截断的位置, 进行链表的截断和重新拼接。
	 * @param head head
	 * @param k k
	 * @return list
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null || k <= 0 ) {
			return head;
		}

		int length = 0;
		ListNode cur = head;
		while(cur != null) {
			length++;	// 先求出链表长度
			cur = cur.next;
		}

		k = k % length;
		if(k == 0) {
			return head;	// 如果k == 0, 无需rotate
		}
		ListNode fast = head, slow = head;
		for(int i = 0;i < k;i++) {
			fast = fast.next;
		}

		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = head;
		head = slow.next;
		slow.next = null;
		return head;
	}
}
