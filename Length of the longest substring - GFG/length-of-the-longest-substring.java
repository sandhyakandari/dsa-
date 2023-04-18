//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        int fre[]=new int[27];
        int max=0;
        int i=0;int j=0;
        while(j<S.length()){
            int a=S.charAt(j)-'a';
            if(fre[a]==0){
                fre[a]++;
            j++;}
            else if(fre[a]>0){
                int c=j-i;
                max=Math.max(c,max);
                while(fre[a]!=0){
                    int b=S.charAt(i)-'a';
                    fre[b]--;
                    i++;
                }
            }
        }
        max=Math.max(max,j-i);
        return max;
        
    }
}