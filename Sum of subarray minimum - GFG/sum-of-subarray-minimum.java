//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.sumSubarrayMins(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int sumSubarrayMins(int n, int[] arr) {
        // code here
        Stack<Integer>st=new Stack<>();
        int ls[]=new int[n];
        int rs[]=new int[n];
        for(int i=0;i<n;i++){
            while(st.size()>0 && arr[i]<arr[st.peek()]){
                rs[st.peek()]=i;
                st.pop();}
            st.push(i);}
            while(st.size()>0){ rs[st.peek()]=n; st.pop();}
                for(int i=n-1;i>=0;i--){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                ls[st.peek()]=i;
                st.pop();     }
            st.push(i);}
            while(st.size()>0){ ls[st.peek()]=-1;st.pop();}
      int M=1000000007;
      int ans=0;
      for(int i=0;i<n;i++){
          int num=(i-ls[i])*(rs[i]-i);
          int temp = (num % M * arr[i] % M) % M;
		ans = (ans % M + temp % M) % M;
      }
      return ans;
    }
}
