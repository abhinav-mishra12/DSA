// Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

// To flip an image horizontally means that each row of the image is reversed.

// For example, flipping [1,1,0] horizontally results in [0,1,1].
// To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

// For example, inverting [0,1,1] results in [1,0,0].
 

// Example 1:

// Input: image = [[1,1,0],[1,0,1],[0,0,0]]
// Output: [[1,0,0],[0,1,0],[1,1,1]]
// Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
// Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
// Example 2:

// Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
// Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
// Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

import java.util.Arrays;
import java.util.Scanner;

public class flipAndInvertImage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the size of the matrix: ");
        int n = input.nextInt();
        int[][] image = new int[n][n];

        // Insert elements
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = input.nextInt();
            }
        }
        input.close();

        // Print Original Matrix
        System.out.println("Original Matrix:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(image[i]));
        }

        // Process the matrix
        int[][] ans = flipAndInvertImage(image);

        // Print Resulting Matrix
        System.out.println("Flipped and Inverted Matrix:");
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }

    static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length; // Get the actual size of the matrix
        for (int i = 0; i < n; i++) {
            reverseimage(image[i]); // Flip the row
            bitreverse(image[i]); // Invert the bits
        }
        return image;
    }

    static void reverseimage(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    static void bitreverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] ^ 1; // Invert bits
        }
    }
}



