package lc51to60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haoxiang Ma
 * Leetcode #57
 * Insert Interval
 */
public class InsertInterval {

	public static void main(String[] args) {
		InsertInterval solution = new InsertInterval();
	}

	/**
	 * 思路: 既要插入, 又要merge。插入的时候有3种情况: 1.待插入的interval在当前interval
	 * 的左边, 那就直接把两个都插入; 2. 待插入的interval在当前interval的右边, 那就只插入当前
	 * interval; 3. 待插入的interval与当前interval有重合, merge。
	 * @param intervals intervals
	 * @param newInterval newInterval
	 * @return intervals
	 */
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<>();
		for(Interval cur : intervals) {
			if(newInterval == null || newInterval.start > cur.end) {
				result.add(cur);	// 当前interval完全在待插入的interval的左边
			} else if(newInterval.end < cur.start) {
				result.add(newInterval);	// 当前interval完全在待插入的interval的右边
				result.add(cur);
				newInterval = null;
			} else {
				newInterval.start = Math.min(newInterval.start, cur.start);	// 当前interval与待插入的interval有重合
				newInterval.end = Math.max(newInterval.end, cur.end);
			}
		}
		if(newInterval != null) {
			result.add(newInterval);
		}
		return result;
	}
}
