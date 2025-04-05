import java.util.ArrayList;

public class allDivisors {
    public static void main(String[] args) {
        int number=36;
        ArrayList<Integer> divisors = findDivisors(number);
        for (Integer divisor : divisors) {
            System.out.println(divisor);
        }

    }
    public static ArrayList<Integer> findDivisors(int n){
        ArrayList<Integer> divisors = new ArrayList<>();
        int sqrt=(int) Math.sqrt(n);
        for (int i = 1; i < sqrt; i++) {
            if (n%i==0) {
                divisors.add(i);
                if (i!=n/i) {
                    divisors.add(n/i);
                }
            }
            
        }
        return divisors;
    }
    
}
