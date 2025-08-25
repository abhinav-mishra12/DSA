import java.util.*;

public class minimumCoins {
    public static void findMinCoins(int amount) {
        int[] coins = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        List<Integer> result = new ArrayList<>();

        for (int coin : coins) {
            while (amount >= coin) {
                amount -= coin;
                result.add(coin);
            }
        }

        // Print result
        System.out.println("Coins used: " + result);
        System.out.println("Minimum number of coins = " + result.size());
    }

    public static void main(String[] args) {
        int amount = 2758;

        findMinCoins(amount);
    }
}
