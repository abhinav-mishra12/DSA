
import java.util.Scanner;

public class maxSubArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        System.out.println("Enter the elements of the array: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=input.nextInt();
        }
        int ans = maxSubArray(nums);
        System.out.println(ans);
        input.close();
    }

    public static int maxSubArray(int[] nums){
        int sum=0;
        int max=nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum=sum+nums[i];
            if (sum>max) {
                max=sum;
            }
            if (sum<0) {
                sum=0;
            }
            

        }

        return max;
    } 
}
