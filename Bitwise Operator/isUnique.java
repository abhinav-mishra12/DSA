public class isUnique {
    public static void main(String[] args) {
        int[] arr={2,3,3,4,2,6,4};
        System.out.println(ans(arr));
    }
    public static int ans(int[] arr){
        int unique=0;
        for(int n : arr) {
            unique ^= n;
        }
        return unique;
    }
}
//XOR is both commutative (order doesn't matter) and associative (grouping doesn't matter).
//0 ^ x = x (any number XOR'd with 0 is the number itself)
//x ^ x = 0 (any number XOR'd with itself results in 0)