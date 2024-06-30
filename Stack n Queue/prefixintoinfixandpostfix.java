import java.util.*;
public class prefixintoinfixandpostfix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String exp=sc.nextLine();
        //logic
        Stack<Integer> eval=new Stack<>();
        Stack<String> infix=new Stack<>();
        Stack<String> postfix=new Stack<>();
        for(int i=exp.length()-1;i>=0;i--){
            char ch=exp.charAt(i);
            if(ch>='0' && ch<='9'){
                eval.push(Integer.parseInt(ch+""));
                infix.push(ch+"");
                postfix.push(ch+"");
            }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                //infix
                String v1=infix.pop(),v2=infix.pop();
                infix.push("("+v1+ch+v2+")");
                //postfix
                String pv1=postfix.pop(),pv2=postfix.pop();
                postfix.push(pv1+pv2+ch);
                //eval
                int ev1=eval.pop(),ev2=eval.pop();
                if(ch=='+') eval.push(ev1+ev2);
                if(ch=='-') eval.push(ev1-ev2);
                if(ch=='*') eval.push(ev1*ev2);
                if(ch=='/') eval.push(ev1/ev2);
            }
        }
        System.out.println(eval.peek()+"\n"+infix.peek()+"\n"+postfix.peek());
    }
}
