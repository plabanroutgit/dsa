package _20220520;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestStringChain_Plaban {

	public int longestStrChain(String[] words) {

		Arrays.sort(words, (a1, a2) -> a1.length() - a2.length());

		int max = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = 1; j < words.length; j++) {
				List<String> s = new ArrayList<String>();
				int ii = i, jj = j;
				while (jj != words.length) {

					if (words[jj].length() == words[ii].length()) {
						jj++;
					} else if (words[jj].length() == words[ii].length() + 1) {

						if (!s.contains(words[ii])) {
							s.add(words[ii]);
						}
						if (isPredecissor(words[ii], words[jj])) {

							if (!s.contains(words[jj])) {
								s.add(words[jj]);
							}
							ii = jj;
						}
						jj++;
					} else {
						jj++;
					}

				}
				max = Math.max(max, s.size());
			}
		}

		return max;
	}

	boolean isPredecissor(String f, String s) {

		if (s.length() != f.length() + 1)
			return false;

		if (s.contains(f))
			return true;

		if (f.length() > 1) {
			int i = 0, j = 1;
			while (j != f.length()) {
				if (s.indexOf(f.charAt(i)) > s.indexOf(f.charAt(j)))
					return false;
				if (s.indexOf(f.charAt(i)) == -1)
					return false;
				i++;
				j++;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		// String[] words = { "a", "ab", "ac", "bd", "abc", "abd", "abdd" };
		String[] words = { "sgtnz", "sgtz", "sgz", "ikrcyoglz", "ajelpkpx", "ajelpkpxm", "srqgtnz", "srqgotnz",
				"srgtnz", "ijkrcyoglz" };
		// String[] words = { "abcd", "dbqca" };

		LongestStringChain_Plaban lsc = new LongestStringChain_Plaban();

		System.out.println(lsc.longestStrChain(words));

	}

}
