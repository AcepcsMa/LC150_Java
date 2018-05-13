package lc21to30;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

/**
 * @author Haoxiang Ma
 * Leetcode #21
 * Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {

	public static void main(String[] args) {
		MergeTwoSortedLists solution = new MergeTwoSortedLists();
	}

	/**
	 * 思路: 原链表已经有序, 可以应用two pointer的解法。两pointer分别置于两链表
	 * 开头, 互相比较当前节点的值的大小, 小的节点接到新链的末尾并向后挪动对应的pointer,
	 * 直到其中一条or两条链走到了尽头。最后再将没走到尽头的那条链接到新链的末尾。
	 * @param l1 l1
	 * @param l2 l2
	 * @return merged linkedlist
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}

		// 新链链头
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;

		// 没走到尽头就一直走
		while(l1 != null && l2 != null) {
			// 把小的节点接到新链的末尾
			if(l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		// 把没走完的链接到新链的末尾
		if(l1 != null) {
			cur.next = l1;
		}
		if(l2 != null) {
			cur.next = l2;
		}
		return dummy.next;
	}
}
