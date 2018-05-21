package lc31to40;

/**
 * @author Haoxiang Ma
 * Leetcode #38
 * Count and Say
 */
public class CountAndSay {

	public static void main(String[] args) {
		CountAndSay solution = new CountAndSay();
	}

	/**
	 * 思路: Base case是"1", 每次先从左边开始遍历, 记录相同字符的个数count,
	 * 直到遇到不一样的字符就将前面一段的count和该字符加入新字符串。
	 * @param n n
	 * @return count result
	 */
	public String countAndSay(int n) {
		if(n <= 0) {
			return "";
		}

		String base = "1";
		for(int i = 2;i <= n;i++) {
			StringBuilder temp = new  StringBuilder();
			char cur = base.charAt(0);
			int count = 0;
			for(int j = 0;j < base.length();j++) {
				if(base.charAt(j) == cur) {
					count++;	// 如果一直相同就一直计数
				} else {
					temp.append(String.valueOf(count) + cur);	// 如果遇到不同的字符就将前一段加上去, 重新计数
					cur = base.charAt(j);
					count = 1;
				}
			}
			temp.append(String.valueOf(count) + cur);	// 将最后一段写入temp
			base = temp.toString();	// 回写base
		}
		return base;
	}
}
