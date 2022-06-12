package _20220531;

import java.util.ArrayDeque;

public class BasicCalculatorII {

	public int calculate(String s) {

		if (s.length() == 0)
			return 0;

		ArrayDeque<Integer> stk = new ArrayDeque<Integer>();

		int currNum = 0;
		char op = '+';
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);

			if (Character.isDigit(currChar)) {
				currNum = currNum * 10 + Character.getNumericValue(currChar);
			}
			if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == s.length() - 1) {
				switch (op) {

				case '-':
					stk.push(-1 * currNum);
					break;
				case '+':
					stk.push(currNum);
					break;
				case '*':
					stk.push(stk.poll() * currNum);
					break;
				case '/':
					stk.push(stk.poll() / currNum);
					break;

				}
				op = currChar;
				currNum = 0;
			}

		}
		int result = 0;
		while (!stk.isEmpty()) {
			result += stk.poll();
		}

		return result;
	}

	public static void main(String[] args) {
		String s = " 3/2 ";

		BasicCalculatorII bc = new BasicCalculatorII();
		System.out.println(bc.calculate(s));
	}
}
