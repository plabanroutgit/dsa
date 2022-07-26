package capitalone._20220724;

public class IntegerToRoman12 {

	public String intToRoman(int num) {

		StringBuilder b = new StringBuilder();

		int[] nums = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbols = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		while (num > 0) {

			for (int i = 0; i < nums.length; i++) {
				while (nums[i] <= num) {
					num -= nums[i];
					b.append(symbols[i]);
				}

			}

		}

		return b.toString();

	}

	public static void main(String[] args) {

		IntegerToRoman12 itr = new IntegerToRoman12();
		System.out.println(itr.intToRoman(21));

	}

}
