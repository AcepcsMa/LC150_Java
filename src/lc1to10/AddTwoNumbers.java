package lc1to10;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

/**
 * @author Haoxiang Ma
 * Leetcode #2
 * Add Two Numbers
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers solution = new AddTwoNumbers();
	}

	/**
	 * 思想: 线性表的顺序遍历, 注意处理进位
	 * @param l1 l1
	 * @param l2 l2
	 * @return new head
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}

		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		int carry = 0;

		// 其中一条链为空都可以继续加下去
		while(l1 != null || l2 != null) {
			int temp = 0;
			if(l1 != null && l2 != null) {
				temp = l1.val + l2.val + carry;
			} else if(l1 != null) {
				temp = l1.val + carry;
			} else {
				temp = l2.val + carry;
			}

			cur.next = new ListNode(temp % 10); // 当前位
			cur = cur.next;
			carry = temp / 10;	// 进位
			if(l1 != null) {
				l1 = l1.next;
			}
			if(l2 != null) {
				l2 = l2.next;
			}
		}

		if(carry > 0) {
			// 处理最后一个进位
			cur.next = new ListNode(carry);
		}
		return dummy.next;
	}
}
