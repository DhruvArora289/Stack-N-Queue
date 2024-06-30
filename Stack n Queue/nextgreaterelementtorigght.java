import java.util.*;
public class nextgreaterelementtorigght {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(nextgreaterelementtorigght(arr)));
    }
    public static int[] nextgreaterelementtorigght(int[] arr) {
        int[] res=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(i==arr.length-1){
                res[i]=-1;
                st.push(arr[i]);
            }else{
                while(st.size()!=0 && arr[i]>st.peek()){
                    st.pop();
                }
                if(st.isEmpty()){
                    res[i]=-1;
                }else{
                    res[i]=st.peek();
                }
                st.push(arr[i]);
            }
        }
        return res;
    }
}
