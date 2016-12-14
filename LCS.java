
/*
 * Author: Sovichea Cheth
 * ID: 985421
 */

public class LCS {

	static int counter;
	static int L[][];

	public static int bruteforceLCS(String S1, String S2, int m, int n) {
		counter++;

		if (n == 0) {
			return 0;
		} else if (m == 0) {
			return 0;
		} else if (S1.charAt(m - 1) == S2.charAt(n - 1)) {
			return bruteforceLCS(S1, S2, m - 1, n - 1) + 1;
		} else {
			return Math.max(bruteforceLCS(S1, S2, m, n - 1), bruteforceLCS(S1, S2, m - 1, n));
		}
	}

	public static int memoizeLCS(String S1, String S2, int m, int n) {
		counter++;

		if (L[m][n] < 0) {
			if (n == 0) {
				return 0;
			} else if (m == 0) {
				return 0;
			} else if (S1.charAt(m - 1) == S2.charAt(n - 1)) {
				L[m][n] = memoizeLCS(S1, S2, m - 1, n - 1) + 1;
			} else {
				L[m][n] = Math.max(memoizeLCS(S1, S2, m, n - 1), memoizeLCS(S1, S2, m - 1, n));
			}
		}

		return L[m][n];

	}

	public static void main(String[] args) {

		counter = 0;

		String S1 = "UNITEDSTATEOFAMERICA";
		String S2 = "USA";

		// Comment function when testing
		bruteforceLCS(S1, S2, S1.length(), S2.length());
		System.out.println("Brute Force LCS counter is " + counter);

		L = new int[S1.length() + 1][S2.length() + 1];
		for (int i = 0; i <= S1.length(); i++) {
			for (int j = 0; j <= S2.length(); j++) {
				L[i][j] = -1;
			}
		}

		memoizeLCS(S1, S2, S1.length(), S2.length());
		System.out.println("Memoize LCD counter is " + counter);
	}

}
