/**
 * 
 */
package javaPractice;

/**
 * @author Raushan
 *
 */
public class FibonacciSeries {

	/**
	 * Example of ficobanacci series-- 0,1,1,2,3,5,8,13....
	 */
	public static void main(String[] args) {
		
		int a = 0, b=1;
		int c;
				
		for (int i=1; i<=10; i++) {
			c=a+b;
			System.out.println(c);
			a=b;
			b=c;
		}

	}

}
