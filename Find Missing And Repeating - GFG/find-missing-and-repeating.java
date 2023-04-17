//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
 int[] findTwoElement(int a[], int n) {
        // 2nd approach 
        int[] res = new int[2];
     for(int i=0;i<n;i++){
         if(a[Math.abs(a[i])-1]>0 ){
             a[Math.abs(a[i])-1]=-a[Math.abs(a[i])-1];
         }
         else{
             res[0]=Math.abs(a[i]);
         }
     }
     for(int i=0;i<n;i++){
         if(a[i]>0){
             res[1]=i+1;
         break;}
     }
     return res;
     
     
     
    }}
 
   /* int[] findTwoElement(int arr[], int n) {
        // code here
       int fre[]=new int [n+1];
        for(int i=0;i<n;i++)
        {
          fre[arr[i]]++;
        }
        int ans[]=new int[2];
        for(int i=1;i<n+1;i++){
            if(fre[i]==2){
                ans[0]=i;
            }
            if(fre[i]==0){
                ans[1]=i;
            }
        }
        return ans;
    }
}*/