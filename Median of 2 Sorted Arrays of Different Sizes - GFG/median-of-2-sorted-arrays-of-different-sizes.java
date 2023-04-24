//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int x, int y, int nums1[], int nums2[]) 
    {
      ArrayList<Integer>ar=new ArrayList<>();
     int i=0; int j=0;
     while(i<nums1.length && j<nums2.length){
         if(nums1[i]>nums2[j]){
             ar.add(nums2[j]);
         j++;}
         else if(nums1[i]<nums2[j]){
             ar.add(nums1[i]);
             i++;
         }
         else{
         ar.add(nums1[i]);
        ar.add(nums2[j]);
         i++;j++;
         }}
         while(i<nums1.length){
             ar.add(nums1[i]);
             i++;
         }
     
         while(j<nums2.length){
             ar.add(nums2[j]);
             j++;
         }
        
         int m=ar.size();
         if(m%2==0){
         float as=(ar.get(m/2)+ar.get(m/2-1))/2f;
         return (double)as;
         }
         else{return ar.get(m/2);
         }
     }
    }
        
        