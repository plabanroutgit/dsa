package lcmedium.arrays;

import java.util.HashMap;

public class LongestSubStringWOrepeat2 {

	private static int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}
		if (s.length() <= 1) {
			return s.length();
		}
		HashMap<Character, Integer> map = new HashMap<>();
		int res = 1;
		for (int i = 0, j = 0; j < s.length(); j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(i, map.get(s.charAt(j)) + 1);
			}
			map.put(s.charAt(j), j);
			res = Math.max(res, j - i + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		String str = "pwwkew";

		System.out.println(lengthOfLongestSubstring(str));
	}

}
