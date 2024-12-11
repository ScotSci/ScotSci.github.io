package assignment_8;

public class problem_3 {
    public static int coinChange(int[] coins, int amount) {
		int minCoin[] = new int[amount + 1];
		for (int i = 1; i < minCoin.length; i++) {
			minCoin[i] = Integer.MAX_VALUE;
		}

		for (int j = 1; j < minCoin.length; j++) {
			for (int i = 0; i < coins.length; i++) {
				if (coins[i] <= j) {
					int sub = minCoin[j - coins[i]];
					if (sub != Integer.MAX_VALUE)
						minCoin[j] = Math.min(sub + 1, minCoin[j]);
				}
			}
		}
		return minCoin[minCoin.length - 1];
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }
}
