//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean findPair(int arr[], int s, int n)
    {
        //code here.
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<s;i++){
            int a=arr[i];
            if(hm.containsKey(a+n) || hm.containsKey(a-n)){
                return true;
            }
            int val=hm.getOrDefault(a,0);
            hm.put(a,val+1);
            }
            return false;
    }
}