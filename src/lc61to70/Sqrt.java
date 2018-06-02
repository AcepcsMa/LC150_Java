package lc61to70;

/**
 * @author Haoxiang Ma
 * Leetcode #69
 * Sqrt(x)
 */
public class Sqrt {

	public static void main(String[] args) {
		Sqrt solution = new Sqrt();
	}

	/**
	 * 思路: 牛顿迭代法。每次迭代下降一点点, 直到得到sqrt(x)。
	 * @param x x
	 * @return sqrt(x)
	 */
	public int mySqrt(int x) {
		long y = (long)x;
		while(y * y > x) {
			y = (y + x / y) / 2;	// y*y > x 说明 x/y是小于y的, 那么(x + x/y)的平均数会缩小一点点
		}
		return (int)y;
	}
}
