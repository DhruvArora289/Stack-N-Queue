import java.util.*;
public class stacktoqueueadapter_addefficient {
    public static class stacktoqueueadapter{
        Stack<Integer> mainS;
        Stack<Integer> helperS;
        public stacktoqueueadapter(){
            mainS=new Stack<>();
            helperS=new Stack<>();
        }
        int size(){
            return this.mainS.size();
        }
        void add(int val){
            this.mainS.push(val);
        }
        int remove(){
            if(this.mainS.size()==0){
                System.out.println("stack underflow");
                return -1;
            }
            while(this.mainS.size()>1){
                int pope=this.mainS.pop();
                this.helperS.push(pope);
            }
            int tme = this.mainS.pop();
            while(this.helperS.size()>0){
                int pope=this.helperS.pop();
                this.mainS.push(pope);
            }
            return tme;
        }
        int peek(){
            if(this.mainS.size()==0){
                System.out.println("stack underflow");
                return -1;
            }
            while(this.mainS.size()>1){
                int pope=this.mainS.pop();
                this.helperS.push(pope);
            }
            int peeke=this.helperS.push(this.mainS.pop());
            while(this.helperS.size()>0){
                int pope=this.helperS.pop();
                this.mainS.push(pope);
            }
            return peeke;
        }
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            stacktoqueueadapter st=new stacktoqueueadapter();
            while(true){
            System.out.println("Choose a option:");
            System.out.println("1.add");
            System.out.println("2.peek");
            System.out.println("3.remove");
            System.out.println("4.size");
            System.out.println("5.Exit");
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
                    System.out.println("size of stack is: "+st.size());
                    break;
                case 5:
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