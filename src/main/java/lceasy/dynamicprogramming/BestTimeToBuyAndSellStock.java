package lceasy.dynamicprogramming;

public class BestTimeToBuyAndSellStock {

	public static int maxProfit(int prices[]) {
		int minSofar = Integer.MAX_VALUE;
		int largestDiffrence = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minSofar)
				minSofar = prices[i];
			else {
				largestDiffrence = Math.max(largestDiffrence, (prices[i] - minSofar));
			}
		}
		return largestDiffrence;
	}

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };

		System.out.println(maxProfit(prices));

	}
}
