package capitalone._20220723;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman12 {

	public static final Map<Integer, String> rmap = new HashMap<Integer, String>() {
		{
			put(1, "I");
			put(5, "V");
			put(10, "X");
			put(50, "L");
			put(100, "C");
			put(500, "D");
			put(1000, "M");
		}
	};

	public String intToRoman(int num) {

		String[] dp = new String[num + 1];

		for (int i = 1; i < dp.length; i++) {
			if (rmap.containsKey(i)) {
				dp[i] = rmap.get(i);
			} else if (i == 4) {
				dp[i] = "IV";
			} else if (i == 9) {
				dp[i] = "IX";
			} else if (i == 40) {
				dp[i] = "XL";
			} else if (i == 90) {
				dp[i] = "XC";
			} else if (i == 400) {
				dp[i] = "CD";
			} else if (i == 900) {
				dp[i] = "CM";
			}
		}

		return "";
	}

	public static void main(String[] args) {
		int num = 58;

		IntegerToRoman12 itr = new IntegerToRoman12();
		System.out.println(itr.intToRoman(num));

	}

}
