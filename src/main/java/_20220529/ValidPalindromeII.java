package _20220529;

public class ValidPalindromeII {

	boolean oneCharRemoved = false;

	public boolean validPalindrome(String s) {

		return checkPalin(s, 0, s.length() - 1);

	}

	boolean checkPalin(String s, int start, int end) {

		if (start == end)
			return true;

		if (end == start + 1 && !oneCharRemoved)
			return true;

		if (end == start + 1 && s.charAt(start) == s.charAt(end))
			return true;
		
		if (s.charAt(start) == s.charAt(end))
			return checkPalin(s, start + 1, end - 1);
		else if (!oneCharRemoved) {

			oneCharRemoved = true;
			if (checkPalin(s, start + 1, end)) {
				return true;
			}

			if (checkPalin(s, start, end - 1)) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		ValidPalindromeII vp = new ValidPalindromeII();

		System.out.println(vp.validPalindrome("deeee"));

	}

}
