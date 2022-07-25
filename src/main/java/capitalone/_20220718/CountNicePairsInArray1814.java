package capitalone._20220718;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInArray1814 {

	
	final long MOD = (long)Math.pow(10 , 9)+7;
	
	public int rev(int x) {

		int sum = 0;
		while (x > 0) {
			int rem = x % 10;
			sum = sum * 10 + rem;
			x = x / 10;
		}

		return sum;
	}

	public int countNicePairs(int[] nums) {

		long count = 0;
		int[] diff = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			diff[i] = nums[i] - rev(nums[i]);
		}
		Map<Integer, Integer> card = new HashMap<Integer, Integer>();

		for (int i = 0; i < diff.length; i++) {
			int cntval = card.getOrDefault(diff[i], 0);
			card.put(diff[i], cntval + 1);
		}

		for (int i : card.keySet()) {

			if (card.get(i) == 2) {
				count++;
			} else if (card.get(i) > 2) {
				int n = card.get(i);
				count+=((n*(n-1L))/(2L))%MOD;
			}

		}

		return (int)(count%MOD);
	}

	public static void main(String[] args) {
		int[] nums = { 13, 10, 35, 24, 76 };

		//int[] nums = { 42, 11, 1, 97 };

		CountNicePairsInArray1814 cn = new CountNicePairsInArray1814();
		System.out.println(cn.countNicePairs(nums));

	}

}
