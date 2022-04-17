package lcmedium.arrays;

public class LongestSubStringWOrepeat {

	private static int lengthOfLongestSubstring(String s) {
		int max = 0;
		if (s.length() == 0) {
			max = 0;
		} else if (s.length() == 1) {
			max = 1;
		} else {
			for (int i = 0; i <= s.length() - 2; i++) {

				int curMax = 0;
				int beginIdx = i;
				int curIdx = i;
				int curNxtIdx = i + 1;
				while (curNxtIdx != (s.length())) {
					if (s.charAt(curIdx) == s.charAt(curNxtIdx)) {
						max = Math.max(curMax, max);
						break;
					} else if (s.charAt(curIdx) != s.charAt(curNxtIdx)) {
						if (!s.substring(beginIdx, curIdx).contains(Character.toString(s.charAt(curNxtIdx)))) {
							curIdx++;
							curNxtIdx++;
							curMax++;
							max = Math.max(curMax, max);
						} else {
							max = Math.max(curMax, max);
							break;
						}
					}
				}

			}
			max++;
		}
		return max;
	}

	public static void main(String[] args) {
		String str = "pwwkew";

		System.out.println(lengthOfLongestSubstring(str));
	}

}
