package _20220527;

import java.util.LinkedList;
import java.util.List;

public class MaxmSplitOfPositiveEvenIntegers2 {

	public List<Long> maximumEvenSplit(long finalSum) {

		List<Long> res = new LinkedList<Long>();

		if (finalSum % 2 != 0)
			return res;

		collectnums(2, res, finalSum - 2);

		return res;
	}

	void collectnums(long num, List<Long> res, long rem) {

		if (res.contains(num))
			return;

		res.add(num);

		if (rem - num - 2 == 0 || rem - num - 2 == num + 2) {
			res.add(rem);
			return;
		}
		collectnums(num + 2, res, rem - num - 2);

	}

	public static void main(String[] args) {

		MaxmSplitOfPositiveEvenIntegers2 m = new MaxmSplitOfPositiveEvenIntegers2();

		System.out.println(m.maximumEvenSplit(7));

	}

}
