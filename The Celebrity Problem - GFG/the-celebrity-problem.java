//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer>st=new Stack<>();
      for(int i=0;i<n;i++){
          st.push(i);
      }
      while(st.size()>1){
          int t1=st.pop();
          int t2=st.pop();
          if(M[t1][t2]==1){
              st.push(t2);
          }
         else if(M[t2][t1]==1){
              st.push(t1);
          }
      }
      if(st.size()==0 ){ return -1;}
     int ans=st.peek();
          for(int i=0;i<n;i++){
        if(i!=ans && M[i][ans]==0){return -1;}  
         if(M[ans][i]==1){
           return -1;}   
          }
          return ans;
    }
}