package _20220530;

import java.util.Stack;

public class MinimumAddToMakeParenValid {

	public int minAddToMakeValid(String s) {

		Stack<Character> stk = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {

			if (!stk.isEmpty()) {
				switch (stk.peek()) {
				case '(':
					if (s.charAt(i) == ')')
						stk.pop();
					else if (s.charAt(i) == '(')
						stk.push(s.charAt(i));
					break;

				case ')':
					stk.push(s.charAt(i));
					break;
				}
			} else {
				stk.push(s.charAt(i));
			}
		}

		return stk.size();

	}

	public static void main(String[] args) {

		MinimumAddToMakeParenValid mp = new MinimumAddToMakeParenValid();

		System.out.println(mp.minAddToMakeValid("()))(("));

	}

}
