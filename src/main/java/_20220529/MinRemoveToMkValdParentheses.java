package _20220529;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import javafx.util.Pair;

public class MinRemoveToMkValdParentheses {

	public String minRemoveToMakeValid(String s) {

		Stack<Pair<Integer, Character>> stk = new Stack<Pair<Integer, Character>>();
		StringBuilder sb = new StringBuilder();
		Set<Integer> removeParen = new HashSet<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stk.push(new Pair<Integer, Character>(i, s.charAt(i)));
			} else if (s.charAt(i) == ')') {

				if (stk.isEmpty()) {
					removeParen.add(i);
					continue;
				}
				if (stk.peek().getValue() != '(') {
					removeParen.add(i);
				} else {
					stk.pop();
				}
			}
		}

		if (!stk.isEmpty()) {
			while (!stk.isEmpty()) {
				Pair<Integer, Character> p = stk.pop();
				removeParen.add(p.getKey());
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (!removeParen.contains(i)) {
				sb.append(s.charAt(i));
			}

		}
		return sb.toString();
	}

	public static void main(String[] args) {

		MinRemoveToMkValdParentheses mr = new MinRemoveToMkValdParentheses();

		System.out.println(mr.minRemoveToMakeValid("))(("));

	}

}
