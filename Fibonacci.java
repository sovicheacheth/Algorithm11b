/* 
 * Author: Sovichea Cheth
 * ID: 985421
 */

public class Fibonacci {

	static int counter = 0;

	static int F[];

	/* Memoized Fibonacci */
	public static int memoizedFib(int n, int F[]) {
		
		counter++;

		if (F[n] < 0) {
			if (n == 0) {
				F[n] = 0;
			} else if (n == 1) {
				F[n] = 1;
			} else {
				F[n] = memoizedFib(n - 2, F) + memoizedFib(n - 1, F);
			}
		}

		return F[n];
	}

	/* Brute Force Fibonacci */
	public static int bruteforceFib(int n) {

		counter++;

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		return bruteforceFib(n - 2) + bruteforceFib(n - 1);

	}

	public static void main(String[] args) {

		counter = 0;
		int n = 30;

		bruteforceFib(n);
		System.out.println("Brute force fibonacci call is " + counter);

		/*
		 * There are 2692537 recursive calls are made by the non-memoized brute
		 * force version Fib(30)
		 */

		F = new int[n + 1];
		for (int i = 0;i <= n;i++) {
			F[i] = -1;
		}
		memoizedFib(n, F);
		System.out.println("Memoized fibonacci call is " + counter);

		/*
		 * Compare the two versions (based on the resulting counts). 
		 * The brute force fibonacci take more time to run when Fib(50).
		 * Memoized fibonacci Fib(30) call is 59.
		 */
	}

}
