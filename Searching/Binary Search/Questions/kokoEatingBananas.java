// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

// Return the minimum integer k such that she can eat all the bananas within h hours.
public class kokoEatingBananas {
    public static void main(String[] args) {
        class Solution {
            public int minEatingSpeed(int[] piles, int h) {
                int low=1;
                int high=getMax(piles); //Max banana in a pile
        
                while(low<high){
                    int mid = low + (high - low) / 2;
                    if(calculateHours(piles, mid)<=h){
                        high = mid;  // Try smaller speed
                    }
                    else{
                        low=mid+1;
                    }
                }
                return low;
            }
        
            // Calculates total hours needed at given eating speed
            public int calculateHours(int[] piles, int speed) {
                int totalHours = 0;
                for (int pile : piles) {
                    totalHours += (int) Math.ceil((double) pile / speed);
                }
                return totalHours;
            }
            
            // Get maximum pile value
            public int getMax(int[] piles) {
                int max = piles[0];
                for (int pile : piles) {
                    if (pile > max) max = pile;
                }
                return max;
            }
        }
    }
}



