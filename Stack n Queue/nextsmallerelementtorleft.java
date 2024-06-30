import java.util.*;
public class nextsmallerelementtorleft {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(nextsmallerelementtoleft(arr)));
    }
    public static int[] nextsmallerelementtoleft(int[] arr){
        int n=arr.length;
        int[] res=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(i==0){
                res[i]=-1;
                st.push(arr[i]);
            }else{
                while(!st.isEmpty() && arr[i]<st.peek()){
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
