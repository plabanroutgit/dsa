package lceasy.arrays;

public class BuySellStocksII2 {

	public static int maxProfit(int[] prices) {
		int total = 0;
		int peak = prices[0];
		int valley = peak;

		for (int i = 0; i < prices.length; i++) {

			if (prices[i] < peak) {

				total += peak - valley;

				peak = prices[i];
				valley = peak;
			} else {
				peak = prices[i];
			}
		}

		total += peak - valley;

		return total;
	}

	public static void main(String[] args) {

		int[] prices = { 1, 2, 3, 4, 5 };

		System.out.println(maxProfit(prices));

	}

}
