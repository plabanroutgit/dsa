package capitalone._20220717;

import java.util.Comparator;
import java.util.PriorityQueue;

class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {

		if (s1.length() > s2.length())
			return -1;
		else if (s1.length() < s2.length())
			return 1;
		return 0;
	}

}

public class GreatestCommonDivisorOfStrings1071 {

	public String gcdOfStrings(String str1, String str2) {

		PriorityQueue<String> pq = new PriorityQueue<String>(new StringLengthComparator());

		if (str1.length() >= str2.length()) {
			for (int i = 0; i < str2.length(); i++) {
				String t = str2.substring(0, i + 1);
				String s1 = str1.replaceAll(t, "");
				String s2 = str2.replaceAll(t, "");

				if (s1.length() == s2.length() && s2.length() == 0) {
					pq.offer(t);
				}
			}
		} else {
			for (int i = 0; i < str1.length(); i++) {
				String t = str1.substring(0, i);
				String s1 = str1.replaceAll(t, "");
				String s2 = str2.replaceAll(t, "");

				if (s1.length() == s2.length() && s2.length() == 0) {
					pq.offer(t);
				}
			}
		}

		if (pq.size() != 0)
			return pq.poll();

		return "";
	}

	public static void main(String[] args) {

		String str1 = "ABABABAB", str2 = "ABAB";

		GreatestCommonDivisorOfStrings1071 gc = new GreatestCommonDivisorOfStrings1071();
		System.out.println(gc.gcdOfStrings(str1, str2));

	}

}
