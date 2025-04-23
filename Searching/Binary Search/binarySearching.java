import java.util.Scanner;

public class binarySearching{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=input.nextInt();
        }

        System.out.println("Enter the target element: ");
        int target = input.nextInt();

        int ans = binarySearch(nums, target);
        System.out.println(ans);
        input.close();
    }

    public static int binarySearch(int[] nums, int target){  //Array need to be sorted for searching in binary search 
        int start = 0;
        int end = nums.length-1;
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if (target<nums[mid]) {
                end = mid-1;
            }
            else if (target>nums[mid]) {
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
        
    }
}
