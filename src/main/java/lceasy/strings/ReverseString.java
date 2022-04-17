package lceasy.strings;

import java.util.Arrays;

public class ReverseString {

	private static char[] reverseString(char[] s) {

		int start = 0, end = s.length - 1;

		while (start <= end) {
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}

		return s;
	}

	public static void main(String[] args) {

		char[] s = { 'h', 'e', 'l', 'l' };

		System.out.println(Arrays.toString(reverseString(s)));
	}

}
