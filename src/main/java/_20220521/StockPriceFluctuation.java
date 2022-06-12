package _20220521;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPriceFluctuation {

	Map<Integer, Integer> tp;
	TreeMap<Integer, Integer> priceCount;

	int currTime;

	public StockPriceFluctuation() {
		tp = new HashMap<Integer, Integer>();
		currTime = 0;
		priceCount = new TreeMap<Integer, Integer>();
	}

	public void update(int timestamp, int price) {

		if (!tp.containsKey(timestamp)) {

			if (priceCount.get(price) != null) {
				priceCount.put(price, priceCount.get(price) + 1);
			} else {
				priceCount.put(price, 1);
			}

			tp.put(timestamp, price);

		} else {

			int oldPrice = tp.get(timestamp);

			if (priceCount.get(oldPrice) != null) {
				int cnt = priceCount.get(oldPrice);

				if (cnt > 1) {
					priceCount.put(oldPrice, cnt - 1);
				} else if (cnt == 1) {
					priceCount.remove(oldPrice);
				}
			}

			tp.replace(timestamp, price);
		}

		currTime = Math.max(currTime, timestamp);
	}

	public int current() {
		return tp.get(currTime);
	}

	public int maximum() {
		return priceCount.lastKey();
	}

	public int minimum() {
		return priceCount.firstKey();
	}

	public static void main(String[] args) {

	}
}
