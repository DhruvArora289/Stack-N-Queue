import java.util.*;
public class normalqueue {
    public static class CustomQueue {
    int data[];
    int front;
    int size;
    public CustomQueue(int cap){
        data = new int[cap];
        front=0;
        size=0;
    }
    int size(){
        return this.size;
    }
    void add(int val){
        if(this.size()==data.length){
            System.out.println("Queue overflow");
            return;
        }
        int idx=(this.front+this.size)%this.data.length;
        this.data[idx]=val;
        this.size++;
    }
    void display(){
        for(int i=0;i<this.size;i++){
            System.out.println(data[(this.front+i)%this.data.length]);
        }
    }
    int remove(){
        if(this.size==0){
            System.out.println("queue underflow");
            return -1;
        }
        int val=this.data[this.front];
        this.data[this.front]=0;
        this.front=(this.front+1)%this.data.length;
        this.size--;
        return val;
    }
    int peek(){
        if(this.size==0){
            System.out.println("queue underflow");
            return -1;
        }
        return this.data[this.front];
    }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        CustomQueue st=new CustomQueue(n);
        while(true){
        System.out.println("Choose a option:");
        System.out.println("1.add");
        System.out.println("2.peek");
        System.out.println("3.remove");
        System.out.println("4.size");
        System.out.println("5.display");
        System.out.println("6.Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
            System.out.println("Enter val to add: ");
                int val=sc.nextInt();
                st.add(val);
                break;
            case 2:
                System.out.println("peek element is: "+st.peek());
                break;
            case 3:
                System.out.println("value that was removed: "+st.remove());
                break;
            case 4:
                System.out.println("size of queue is: "+st.size());
                break;
            case 5:
                System.out.println("queue is: ");
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
