//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public pair indexes( long nums[], long t)
    {
        // Your code goes here
        int s=0;int end=nums.length-1;
  int f=-1; int ar[]=new int[2];
        while(s<=end){
         int m=(s+end)/2;
         if(nums[m]>t)
         {    end=m-1;     }
         else if(nums[m]<t){
             s=m+1;        }
         else{ 
              if(f==-1){
                  f=m;end=m-1; }
              else if(f>m){
               f=m;
               end=m-1;
              }
             }
             
         }
         
     ar[0]=f;
     int i=-1; s=0; end=nums.length-1;
while(s<=end){
    
         int m=(s+end)/2;
         if(nums[m]>t)
         {    end=m-1;     }
         else if(nums[m]<t){
             s=m+1;        }
         else{ 
              if(i==-1){
                  i=m;s=m+1; }
              else if(i<m){
               i=m;
               s=m+1;
              }
             }
         }
  ar[1]=i;

return new pair(ar[0],ar[1]);
        }
    }
        