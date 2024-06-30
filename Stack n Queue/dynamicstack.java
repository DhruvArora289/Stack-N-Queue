import java.util.*;
public class dynamicstack {
    public static class CustomStack{
        int data[];
        int tos;
        public CustomStack(int cap){
            data=new int[cap];
            tos=-1;
        }
        int size(){
            return this.tos+1;
        }
        void push(int val){
            if(this.size()==data.length){
                int newData[]=new int[2*data.length];
                for(int i=0;i<data.length;i++){
                    newData[i]=data[i];
                }
                this.data=newData;
            }
            tos++;
            data[tos]=val;
        }
        int pop(){
            if(tos==-1){
                System.out.println("stack underflow");
                return -1;
            }else{
                int val=this.data[tos];
                this.data[tos]=0;
                this.tos--;
                return val;
            }
        }
        int top(){
            return this.data[this.tos];
        }
        void display(){
            for(int i=this.tos;i>=0;i--){
                System.out.println(this.data[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        CustomStack st=new CustomStack(n);
        while(true){
            System.out.println("please enter your choice");
            System.out.println("1.push");
            System.out.println("2.pop");
            System.out.println("3.top");
            System.out.println("4.size");
            System.out.println("5.display");
            System.out.println("6.Exit");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter val to push:");
                    int val=sc.nextInt();
                    st.push(val);
                    break;
                case 2:
                    System.out.println("popped val is: "+st.pop());
                    break;
                case 3:
                    System.out.println("top of the stack is: "+st.top());
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
