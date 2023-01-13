//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    Solution obj = new Solution();
		    String arr[]=sc.nextLine().split(" ");
		    System.out.println(obj.mostFrequentWord(arr, n));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[],int n)
    { Map<String,Integer>hm=new HashMap<>();
        // code here
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                int oldval=hm.get(arr[i]);
                hm.put(arr[i],oldval+1);
            }
            else{hm.put(arr[i],1);}
        } String mfc=arr[0];
        for(String Key:hm.keySet()){
            if(hm.get(mfc)<hm.get(Key)){
                mfc=Key;
            }
        }
        int max=hm.get(mfc);
        String ans="";
        for(int i=0;i<n;i++){
        String a=arr[i];
        if(hm.get(a)==max){ 
            int val=hm.get(a);
            hm.put(a,val-1);
            ans=a;
        }
    }
    return ans;

}
}

//{ Driver Code Starts.
// } Driver Code Ends