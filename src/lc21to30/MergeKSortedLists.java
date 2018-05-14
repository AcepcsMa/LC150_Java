package lc21to30;

/**
 * @author Haoxiang Ma
 * Leetcode #23
 * Merge k Sorted Lists
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
		MergeKSortedLists solution = new MergeKSortedLists();
	}

	/**
	 * 思路: 使用MergeSort的思想, 不断划分成两半, 然后merge起来。 base case
	 * 是当length = 1的时候, 不用进行merge, 直接返回。
	 * @param lists lists
	 * @return merged list
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		return mergeSort(lists, 0, lists.length - 1);
	}

	public ListNode mergeSort(ListNode[] lists, int lower, int upper) {
		if(lower > upper) {
			return null;
		}
		if(lower == upper) {
			return lists[lower];
		}
		int mid = (lower + upper) / 2;
		ListNode left = mergeSort(lists, lower, mid);
		ListNode right = mergeSort(lists, mid + 1, upper);
		return merge(left, right);
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}

		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		if(l1 != null) {
			cur.next = l1;
		}
		if(l2 != null) {
			cur.next = l2;
		}
		return dummy.next;
	}
}
