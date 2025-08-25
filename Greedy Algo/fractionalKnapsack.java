import java.util.*;

class Item {
    int value, weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class fractionalKnapsack {
    public static double getMaxValue(Item[] items, int capacity) {
        // Sort items by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> 
            Double.compare((double)b.value / b.weight, (double)a.value / a.weight)
        );

        int curWeight = 0;
        double finalValue = 0.0;

        for (Item item : items) {
            if (curWeight + item.weight <= capacity) {
                // Take whole item
                curWeight += item.weight;
                finalValue += item.value;
            } else {
                // Take fraction
                int remain = capacity - curWeight;
                finalValue += item.value * ((double)remain / item.weight);
                break; // knapsack full
            }
        }

        return finalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        int capacity = 50;

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
