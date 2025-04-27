// How can we find a element in an infinite array
// // Here we cant use end=arr.length-1
// So in order to find the position of the key, first we find bounds and then apply a binary search algorithm. Let the low be pointing to the 1st element and the high pointing to the 2nd element of the array, Now compare the key with the high index element.


// if it is greater than the high index element then copy the high index in the low index and double the high index. 
// if it is smaller, then apply binary search on high and low indices found.
// low and high will follow following kind of pattern:


// l = 0, h = 1
// l = 1, h = 2
// l = 2, h = 4
// l = 4, h = 8
// So we can observe that over range is doubling every turn so it will take at most log(k) time.


public class infiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90,
            100, 130, 140, 160, 170};  // We dont know the end of this array
        int target = 10;
        int ans = search(arr, target);
        System.out.println("The index of this element is: "+ ans);
    }

    public static int search(int[] arr, int target){
        int start = 0;
        int end = 1;
        while (target>arr[end]) {
            int temp = end+1;
            end = end + (end-start+1) *2;
            start = temp;

        }
        return binarySearch(arr, target, start, end);
    }

    public static int binarySearch(int[] arr, int target, int start, int end){
        while (start<=end) {
            int mid = start + (end-start) /2;
            if (target<arr[mid]) {
                end=mid-1;
            }
            else if (target>arr[mid]) {
                start=mid+1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }
}
