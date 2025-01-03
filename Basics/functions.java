import java.util.Arrays;


public class functions {

    static int p = 90; // this will be shadowed at line 75


    static void fun() {
        System.out.println(p);
    }

    static void fun(int ...v){
        System.out.println(Arrays.toString(v));
    }

    static void swap(int num1, int num2){
        int temp=num1;
        num1=num2;
        num2=temp;
        System.out.println(num1+" "+num2); // Here we are not modifying we are creating a new object
    }

    static void change(int[] nums){
        nums[0]=99; // if u make a change a change to the object via this ref variable, same object will be change
    }

    static int func(int a, int b, int c){
        return a+b+c;
    }

    static int func(int a, int b){
        return a+b;
    }

    public static void main(String[] args) {
      

      
      
      // Swap the value
      int a = 10;
      int b = 20;
      swap(a,b);
      System.out.println(a + " " + b); // Pass by value in java not reference i.e.. copy of the value is given to the methods so any change in the method will not change the real value.
      // Thats why the value of a and b only changes in the scope of methods but didnt change in reality.
      // For primitive data types value is passed to the functions not reference.

      
      
      // In objects and references pass by value of that reference variable
      // Creating a array 
      int[] arr = {1,3,2,45,6};
      change(arr);
      System.out.println(Arrays.toString(arr));



      // Scope
      int x = 10;
      int y = 20;
      String name = "Abhinav";
      {
        //int a = 78; // already initialised outside the block in the same method, hence you cannot initialise again
        x = 100; // reassign the origin ref variable to some other value
        System.out.println(a);
        int c = 99;
        name = "Rahul";
        System.out.println(name);
        // values initialised in this block, will remain in block
        }

        int c = 900;
        System.out.println(x);
        System.out.println(name);
        System.out.println(c); // cannot use outside the block


        // scoping in for loops
        for (int i = 0; i < 4; i++) 
        {
        System.out.println(i);
        int num = 90;
        a = 10000;
        }
        // System.out.println(i);

        //Shadowing 
        System.out.println(p); // 90
        int p; // the class variable at line 6 is shadowed by this
        // System.out.println(p); // scope will begin when value is initialised
        p = 40;
        System.out.println(p); // 40
        fun();

        // Variable Arguements
        fun(2,3,5,6,34,56,78,98,87,567,87);

        //Method Overloading
        //Method overloading means having same function call but different arguements
        func(2,3,4);
        func(1,2);
    }
}
