package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int amt = 1; amt <= amount; amt++) {
            for (int j = 0; j < m; j++) {
                if (coins[j] <= amt) dp[amt] = Math.min(dp[amt], dp[amt - coins[j]] + 1);
            }
        }


        return dp[amount];

    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, amount));
    }
}
