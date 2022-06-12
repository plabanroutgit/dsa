package _20220601;

import java.util.ArrayDeque;

//https://www.youtube.com/watch?v=kVylYewnQ_k
public class SimplifyPath {

	public String simplifyPath(String path) {

		ArrayDeque<String> stk = new ArrayDeque<String>();

		String[] tokens = path.split("/+");
		for (int i = 0; i < tokens.length; i++) {

			if (tokens[i].equals("..")) {
				stk.pollLast();
				continue;
			}
			
			if (!tokens[i].equals(".") && !tokens[i].equals("") )
				stk.offer(tokens[i]);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("/");
		int len = stk.size();
		for (int i = 0; i < len; i++) {
			sb.append(stk.pollFirst());
			if (!stk.isEmpty()) {
				sb.append("/");
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		String path = "/a/../../b/../c//.//";

		SimplifyPath sp = new SimplifyPath();

		System.out.println(sp.simplifyPath(path));

	}
}
