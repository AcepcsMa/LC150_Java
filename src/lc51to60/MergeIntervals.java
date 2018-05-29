package lc51to60;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

/**
 * @author Haoxiang Ma
 * Leetcode #56
 * Merge Intervals
 */
public class MergeIntervals {

	public static void main(String[] args) {
		MergeIntervals solution = new MergeIntervals();
	}

	/**
	 * 思路: 从左到右遍历, 遇到跟前一个interval有重合的就跟其merge, 遇到没重合的
	 * 就直接insert前一个interval。
	 * @param intervals intervals
	 * @return intervals
	 */
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		if(intervals == null || intervals.size() == 0) {
			return result;
		}

		// 先按start升序排序
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		Interval prev = intervals.get(0);
		for(Interval cur : intervals) {
			if(cur.start >= prev.start && cur.start <= prev.end) {
				prev.end = Math.max(prev.end, cur.end);	// 如果跟前一个有重合, merge到一起
			} else {
				result.add(prev);	// 如果没有重合, 插入前一个
				prev = cur;
			}
		}
		result.add(prev);
		return result;
	}
}
