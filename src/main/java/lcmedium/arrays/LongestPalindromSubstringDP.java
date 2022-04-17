package lcmedium.arrays;

//Read this first: https://www.youtube.com/watch?v=UflHuQj6MVA
//https://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
//Time O(n^2) Space O(n^2)
public class LongestPalindromSubstringDP {

	public static String longestPalindrome(String s) {
		if (s == null || s.length() <= 1)
			return s;

		int len = s.length();
		int maxLen = 1;
		boolean[][] dp = new boolean[len][len];

		String longest = null;
		for (int l = 0; l < s.length(); l++) {
			for (int i = 0; i < len - l; i++) {
				int j = i + l;
				if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;

					if (j - i + 1 > maxLen) {
						maxLen = j - i + 1;
						longest = s.substring(i, j + 1);
					}
				}
			}
		}

		return longest;
	}

	public static void main(String[] args) {
		String s = "dabcba";

		System.out.println(longestPalindrome(s));
	}

}
