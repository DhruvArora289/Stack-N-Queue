import java.util.*;
public class slidingwindowmaximum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        slidingwindowmaximum(arr, k);
    }
    public static void slidingwindowmaximum(int arr[],int k){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int nger[]=new int[n];
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                nger[i]=n;
                st.push(arr[i]);
            }else{
                while(!st.isEmpty() && st.peek()>=arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    nger[i]=n;
                }else{
                    nger[i]=st.peek();
                }
                st.push(arr[i]);
            }
        }
        int j=0;
        for(int i=0;i<n-k+1;i++){
            if(j<i){
                j=i;
            }
            while(nger[j]<i+k){
                j=nger[j];
            }
            System.out.println(arr[j]);
        }
    }
}
