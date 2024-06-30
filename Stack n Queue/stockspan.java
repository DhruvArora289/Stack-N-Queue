import java.util.*;
public class stockspan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(stockspan(arr)));
    }
    public static int[] stockspan(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                res[i]=1;
                st.push(i);
            }else{
                while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()){
                    res[i]=i+1;
                }else{
                    res[i]=i-st.peek();
                }
                st.push(i);
            }
        }
        return res;
    }
}
