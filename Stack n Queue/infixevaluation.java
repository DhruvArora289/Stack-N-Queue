import java.util.*;
public class infixevaluation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String exp=sc.nextLine();
        System.out.println(infixeval(exp));
    }
    public static int infixeval(String exp){
        Stack<Integer> opnd=new Stack<>();
        Stack<Character> optr=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(ch=='('){
                optr.push(ch);
            }else if(ch>='0' && ch<='9'){
                opnd.push(Integer.parseInt(ch+""));
            }else if(ch=='-' || ch=='+' || ch=='*' || ch=='/'){
                while(!optr.isEmpty() && optr.peek()!='(' && precedence(ch)<=precedence(optr.peek())){
                    evaluation(optr,opnd);
                }
                optr.push(ch);
            }else if(ch==')'){
                while(optr.peek()!='('){
                    evaluation(optr,opnd);
                }
                optr.pop();
            }
        }
        while(!optr.isEmpty()){
            evaluation(optr,opnd);
        }
        return opnd.peek();
    }
    public static void evaluation(Stack<Character> optr,Stack<Integer> opnd){
        char op=optr.pop();
        int v2=opnd.pop(),v1=opnd.pop();
        if(op=='+') opnd.push(v1+v2);
        if(op=='-') opnd.push(v1-v2);
        if(op=='*') opnd.push(v1*v2);
        if(op=='/') opnd.push(v1/v2);
    }
    public static int precedence(char optr){
        if(optr=='+' || optr=='-') return 1;
        if(optr=='*') return 2;
        return 2;
    }
}
