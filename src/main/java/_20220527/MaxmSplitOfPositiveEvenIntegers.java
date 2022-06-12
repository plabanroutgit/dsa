package _20220527;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxmSplitOfPositiveEvenIntegers {
	public List<Long> maximumEvenSplit(long finalsum) {
		if (finalsum % 2 == 1 || finalsum < 2)
			return new ArrayList<>();
		List<Long> ans = new LinkedList<>();
		long sum = finalsum;
		for (long i = 2; i <= finalsum; i += 2) {
			if (sum <= i * 2) {
				ans.add(sum);
				sum = 0;
			} else {
				ans.add(i);
				sum -= i;
			}
			if (sum == 0) {
				return ans;
			}
		}
		return ans;
	}

	public static void main(String[] args) {

		MaxmSplitOfPositiveEvenIntegers m = new MaxmSplitOfPositiveEvenIntegers();

		System.out.println(m.maximumEvenSplit(28));

	}

}
