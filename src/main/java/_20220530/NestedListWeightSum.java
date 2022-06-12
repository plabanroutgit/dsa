package _20220530;

import java.util.List;

public class NestedListWeightSum {

	public int depthSum(List<NestedInteger> nestedList) {
		int sum = 0;

		sum = getSum(nestedList, 1);
		return sum;
	}


	public int getSum(List<NestedInteger> nl, int depth) {

		int sum = 0;
		for (NestedInteger ni : nl) {

			if (ni.isInteger()) {
				sum += ni.getInteger() * depth;
			} else {
				sum += getSum(ni.getList(), depth + 1);
			}
		}

		return sum;
	}

}
