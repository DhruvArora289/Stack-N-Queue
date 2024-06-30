import java.util.*;
public class postfixtoinfixandprefix {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String exp=sc.nextLine();
        //logic
        Stack<Integer> eval=new Stack<>();
        Stack<String> infix=new Stack<>();
        Stack<String> prefix=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(ch>='0' && ch<='9'){
                eval.push(Integer.parseInt(ch+""));
                infix.push(ch+"");
                prefix.push(ch+"");
            }else if(ch=='+' || ch=='*' || ch=='/' || ch=='-'){
                //infix
                String inv2=infix.pop(),inv1=infix.pop();
                infix.push("("+inv1+ch+inv2+")");
                //prefix
                String pnv2=prefix.pop(),pnv1=prefix.pop();
                prefix.push(ch+pnv1+pnv2);
                //eval
                int v2=eval.pop(),v1=eval.pop();
                if(ch=='+') eval.push(v1+v2);
                if(ch=='*') eval.push(v1*v2);
                if(ch=='/') eval.push(v1/v2);
                if(ch=='-') eval.push(v1-v2);
        }
        }
        System.out.println(eval.peek()+"\n"+infix.peek()+"\n"+prefix.peek());
    }
}

