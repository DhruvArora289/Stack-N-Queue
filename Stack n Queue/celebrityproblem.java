import java.util.*;
public class celebrityproblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i);
        }
        while(st.size()!=1){
            int v1=st.pop(),v2=st.pop();
            if(arr[v2][v1]==1){
                st.push(v1);
            }else{
                st.push(v2);
            }
        }
        int potentialceleb=st.pop();
        boolean isceleb=true;
        for(int i=0;i<n;i++){
            if(i!=potentialceleb){
                if(arr[i][potentialceleb]==0 || arr[potentialceleb][i]==1){
                    isceleb=false;
                    break;
                }
            }
        }
        if(isceleb){
            System.out.println("celeb is: "+potentialceleb);
        }else{
            System.out.println("no celeb");
        }
    }
}
