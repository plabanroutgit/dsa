package _20220601;

public class CustomSortString {

	public String customSortString(String order, String s) {

		StringBuilder sb = new StringBuilder();
		char[] sarr = s.toCharArray();

		for (int i = 0; i < order.length(); i++) {

			int cIdx = s.indexOf(order.charAt(i));
			if (cIdx != -1) {
				sb.append(order.charAt(i));
				sarr[cIdx] = '#';
			}

			int k = cIdx + 1;
			while (k < s.length()) {
				cIdx = s.indexOf(order.charAt(i), k);
				if (cIdx != -1) {
					sb.append(order.charAt(i));
					sarr[cIdx] = '#';
					k = cIdx + 1;
				} else {
					break;
				}

			}
		}

		for (int j = 0; j < sarr.length; j++) {
			if (sarr[j] != '#') {
				sb.append(sarr[j]);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		String order = "kqep";
		String s = "pekeq";

		CustomSortString css = new CustomSortString();

		System.out.println(css.customSortString(order, s));

	}

}
