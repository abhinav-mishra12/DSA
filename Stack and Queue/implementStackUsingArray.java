class stackImpl{
    int top = -1;
    int[] st = new int[10]; //Lets suppose we want a stack for maximum 10 elements

    public void push(int x){
        if(top>10){
            System.out.println("Stack is full");
        }
        top = top+1;
        st[top] = x;

    }

    public int top(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        return st[top];
    }

    public void pop(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        top = top - 1;
    }

    public int size(){
        if(top == -1){
            System.out.println("Stack is empty");
        }
        return top+1;
    }
}

public class implementStackUsingArray{
    public static void main(String[] args) {
        stackImpl stk = new stackImpl();
        stk.push(5);
        stk.push(4);
        stk.push(36);
        System.out.println(stk.top());
        System.out.println(stk.size());
        stk.pop();
        stk.pop();
        stk.push(89);
        System.out.println(stk.top());
        System.out.println(stk.size());


    }
}