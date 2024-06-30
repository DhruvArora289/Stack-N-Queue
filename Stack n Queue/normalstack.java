import java.util.*;
public class normalstack {
    public static class CustomStack {
    int[] data;
    int tos;
    public CustomStack(int cap){
        data=new int[cap];
        tos=-1;
    }
    int size(){
        return this.tos+1;
    }
    void display(){
        for(int i=this.tos;i>=0;i--){
            System.out.println(this.data[i]);
        }
    }
    void push(int val){
        if(this.size()==data.length){
            System.out.println("stack overflow");
            return;
        }
        this.tos++;
        this.data[this.tos]=val;
    }
    int pop(){
        if(this.size()==0){
            System.out.println("Stack underflow");
            return -1;
        }
        int val=this.data[this.tos];
        this.data[this.tos]=0;
        this.tos--;
        return val;
    }
    int top(){
        if(this.size()==0){
            System.out.println("stack underflow");
            return -1;
        }
        return this.data[this.tos];
        }
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        CustomStack st=new CustomStack(n);
        while(true){
        System.out.println("Choose a option:");
        System.out.println("1.push");
        System.out.println("2.top");
        System.out.println("3.pop");
        System.out.println("4.size");
        System.out.println("5.display");
        System.out.println("6.Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
            System.out.println("Enter val to push: ");
                int val=sc.nextInt();
                st.push(val);
                break;
            case 2:
                System.out.println("top element is: "+st.top());
                break;
            case 3:
                System.out.println("value that was popped: "+st.pop());
                break;
            case 4:
                System.out.println("size of stack is: "+st.size());
                break;
            case 5:
                System.out.println("stack is: ");
                st.display();
                break;
            case 6:
                System.out.println("Exiting");
                return;
            default:
                System.out.println("invalid choice");
                break;
        }
        }
    }
}
