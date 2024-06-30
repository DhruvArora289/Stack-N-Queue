import java.util.*;
public class smallestnumberfollowingpattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String pat=sc.nextLine();
        Stack<Integer> st=new Stack<>();
        int count=1;
        st.push(count);
        for(int i=0;i<pat.length();i++){
            if(pat.charAt(i)=='i'){
                while(!st.isEmpty()){
                    System.out.print(st.pop()+" ");
                }
            }
            count++;
            st.push(count);
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }
}
