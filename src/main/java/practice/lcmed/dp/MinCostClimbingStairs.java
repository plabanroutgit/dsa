package practice.lcmed.dp;

import java.util.HashMap;

public class MinCostClimbingStairs {

	private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int minCostClimbingStairs(int[] cost) {
        return minimumCost(cost.length, cost);
    }

    private int minimumCost(int i, int[] cost) {
        // Base case, we are allowed to start at either step 0 or step 1
        if (i <= 1) {
            return 0;
        }

        // Check if we have already calculated minimumCost(i)
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        // If not, cache the result in our hash map and return it
        int downOne = cost[i - 1] + minimumCost(i - 1, cost);
        int downTwo = cost[i - 2] + minimumCost(i - 2, cost);
        memo.put(i, Math.min(downOne, downTwo));
        return memo.get(i);
    }

	public static void main(String[] args) {

		MinCostClimbingStairs cb = new MinCostClimbingStairs();

		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };

		System.out.println(cb.minCostClimbingStairs(cost));

	}

}
