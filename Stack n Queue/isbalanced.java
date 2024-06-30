import java.util.*;
public class isbalanced {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String exp=sc.nextLine();
        System.out.println(isbalanced(exp));
    }
    public static boolean isbalanced(String exp){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
            }else if(ch==')' || ch==']' || ch=='}'){
                if(st.isEmpty()){
                    //ncb>nob
                    return false;
                }
                if( ch==')' && st.peek()!='('){
                    return false;
                }else if( ch=='}' && st.peek()!='{'){
                    return false;
                }else if( ch==']' && st.peek()!='['){
                    return false;
                }
                st.pop();
            }
        }
        if(!st.isEmpty()){
            // nob>ncb
            return false;
        }
        return true;
    }
}
