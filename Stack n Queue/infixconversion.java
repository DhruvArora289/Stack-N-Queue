import java.util.*;
public class infixconversion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String exp=sc.nextLine();
        infixconversion(exp);
    }
    public static void infixconversion(String exp){
        Stack<String> prefix=new Stack<>();
        Stack<String> postfix=new Stack<>();
        Stack<Character> optr=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(ch=='('){
                optr.push(ch);
            }else if(ch>='a' && ch<='z'){
                prefix.push(ch+"");
                postfix.push(ch+"");
            }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                while(!optr.isEmpty() && optr.peek()!='(' && precedence(ch)<=precedence(optr.peek())){
                    evaluation(optr,prefix,postfix);
                }
                optr.push(ch);
            }else if(ch==')'){
                while(optr.peek()!='('){
                    evaluation(optr,prefix,postfix);
                }
                optr.pop();
            }
        }
        while(!optr.isEmpty()){
            evaluation(optr,prefix,postfix);
        }
        System.out.println(prefix.peek()+"\n"+postfix.peek());
    }
    public static void evaluation(Stack<Character> optr,Stack<String> prefix,Stack<String> postfix){
        char op=optr.pop();
        //prefix
        String prev2=prefix.pop(),prev1=prefix.pop();
        prefix.push(op+prev1+prev2);
        //postfix
        String pos2=postfix.pop(),pos1=postfix.pop();
        postfix.push(pos1+pos2+op);
    }
    public static int precedence(char op){
        if(op=='+' || op=='-') return 1;
        if(op=='*' || op=='/') return 2;
        return -1;
    }
}
