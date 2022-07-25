package _20220703;

//https://www.youtube.com/watch?v=0qac3ngAZmE
public class ValidNumber65 {

	public boolean isNumber(String s) {

		boolean digitSeen = false, eSeen = false;
		int plusMinusCnt = 0;
		boolean dotSeen = false;

		for (int i = 0; i < s.length(); i++) {

			if (Character.isDigit(s.charAt(i))) {
				digitSeen = true;
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {

				if (i > 0 && (s.charAt(i - 1) != 'e' || s.charAt(i - 1) != 'E'))
					return false;

			} else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E')) {

				if (eSeen == true || !digitSeen)
					return false;

				eSeen = true;
				digitSeen = false;
			} else if (s.charAt(i) == '.') {

				if (dotSeen || eSeen)
					return false;
				dotSeen = true;
			} else
				return false;
		}

		return digitSeen;
	}

	public boolean isNumber1(String s) {

		boolean digitSeen = false, eSeen = false;
		int plusMinusCnt = 0;
		boolean dotSeen = false;

		for (int i = 0; i < s.length(); i++) {

			if (Character.isDigit(s.charAt(i))) {
				digitSeen = true;
			} else if (i == s.length() - 1 && digitSeen == false) {
				return false;
			} else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (plusMinusCnt == 2)) {
				return false;
			} else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == s.length() - 1)) {
				return false;
			} else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && i > 0
					&& (s.charAt(i - 1) != 'e' || s.charAt(i - 1) != 'E')) {
				return false;
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				plusMinusCnt++;
			} else if (s.charAt(i) == '.' && (dotSeen == true || eSeen == true)) {
				return false;
			} else if (s.charAt(i) == '.' && s.length() == 1) {
				return false;
			} else if (s.charAt(i) == '.') {
				dotSeen = true;
			} else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && (eSeen == true)) {
				return false;
			} else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && i > 0
					&& (s.charAt(i - 1) == '.' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-')) {
				return false;
			} else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && (i == s.length() - 1)) {
				return false;
			} else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && i == 0) {
				return false;
			} else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
				eSeen = true;
			} else if (Character.isLetter(s.charAt(i)) && (s.charAt(i) != 'e' || s.charAt(i) != 'E')) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		ValidNumber65 vn = new ValidNumber65();
		System.out.println(vn.isNumber("-inf"));

	}

}
