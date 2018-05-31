package lc51to60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #60
 * Permutation Sequence
 */
public class PermutationSequence {

	public static void main(String[] args) {
		PermutationSequence solution = new PermutationSequence();
	}

	/**
	 * 思路: 当有n个数时, permutation总可能性有n!种, 确定了最高位之后, 总可能性有(n-1)!种。
	 * 依此类推, 每次选定一个数, 最后可算出k在哪个具体区间内。
	 * @param n n
	 * @param k k
	 * @return kth permutation
	 */
	public String getPermutation(int n, int k) {
		if(n <= 0 || k <= 0) {
			return "";
		}

		if(n == 1) {
			return "1";
		}

		List<Integer> nums = new ArrayList<>();
		for(int i = 1;i <= n;i++) {
			nums.add(i);
		}

		int[] factorial = new int[n];
		factorial[1] = 1;
		for(int i = 2;i < n;i++) {
			factorial[i] = factorial[i - 1] * i;	// 构造阶乘数组
		}

		k--;	// k--为了使index和k都从0开始, 统一起来
		StringBuilder sb = new StringBuilder();
		for(int i = n - 1;i > 0;i--) {
			int index = k / factorial[i];	// 求出当前是第几个数字
			sb.append(nums.get(index));
			nums.remove(index);	// 用完之后从备选集里删除
			k = k % factorial[i];	// 更新k
		}
		sb.append(nums.get(0));
		return sb.toString();
	}
}
