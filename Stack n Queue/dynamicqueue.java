import java.util.*;
public class dynamicqueue {
    public static class CustomQueue{
        int data[];
        int size;
        int front;
        public CustomQueue(int cap){
            data=new int[cap];
            int size=0;
            int front=0;
        }
        int size(){
            return this.size;
        }
        void add(int val){
            if(this.size==this.data.length){
                int[] newData=new int[2*this.data.length];
                for(int i=0;i<this.data.length;i++){
                    newData[i]=data[i];
                }
                this.data=newData;
            }
            int idx=(this.front+this.size)%this.data.length;
            this.data[idx]=val;
            this.size++;
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
        void display(){
            for(int i=0;i<this.size;i++){
                System.out.println(data[(this.front+i)%this.data.length]+" ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        CustomQueue st=new CustomQueue(n);
        while(true){
            System.out.println("please enter your choice");
            System.out.println("1.add");
            System.out.println("2.remove");
            System.out.println("3.peek");
            System.out.println("4.size");
            System.out.println("5.display");
            System.out.println("6.Exit");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter val to add:");
                    int val=sc.nextInt();
                    st.add(val);
                    break;
                case 2:
                    System.out.println("removed val is: "+st.remove());
                    break;
                case 3:
                    System.out.println("peek of the stack is: "+st.peek());
                    break;
                case 4:
                    System.out.println("size of the stack is: "+st.size());
                    break;
                case 5:
                    System.out.println("elements of stack are: ");
                    st.display();
                    break;
                case 6:
                    System.out.println("exiting.....");
                    return;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
    }
}

