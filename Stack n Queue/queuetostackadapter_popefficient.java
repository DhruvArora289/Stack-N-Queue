import java.util.*;
public class queuetostackadapter_popefficient {
    public static class queuetostackadapter{
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;
        public queuetostackadapter(){
            mainQ=new ArrayDeque<>();
            helperQ=new ArrayDeque<>();
        }
        int size(){
            return this.mainQ.size();
        }
        void push(int val){
            this.helperQ.add(val);
            while(this.mainQ.size()>0){
                this.helperQ.add(this.mainQ.remove());
            }
            Queue<Integer> temp=helperQ;
            helperQ=mainQ;
            mainQ=temp;
        }
        int pop(){
            if(this.size()==0){
                System.out.println("stack undeflow");
                return -1;
            }
            int tme = this.mainQ.remove();
            return tme;
        }
        int peek(){
            if(this.size()==0){
                System.out.println("stack underflow");
                return -1;
            }
            return mainQ.peek();
        }
        void display(){
            System.out.println(mainQ);
        }
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            queuetostackadapter st=new queuetostackadapter();
            while(true){
            System.out.println("Choose a option:");
            System.out.println("1.push");
            System.out.println("2.peek");
            System.out.println("3.pop");
            System.out.println("4.size");
            System.out.println("5.display");
            System.out.println("6.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                System.out.println("Enter val to add: ");
                    int val=sc.nextInt();
                    st.push(val);
                    break;
                case 2:
                    System.out.println("peek element is: "+st.peek());
                    break;
                case 3:
                    System.out.println("value that was removed: "+st.pop());
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
}
