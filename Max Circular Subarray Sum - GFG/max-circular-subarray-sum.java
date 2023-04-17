//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {

int maxsum=-1000000; int cur=maxsum; int minsum=1000000; int min=minsum; int tot=0;

for(int i=0;i<n;i++){
    tot=tot+a[i];
    
    cur=Math.max(cur+a[i],a[i]);
    maxsum=Math.max(cur,maxsum);
    
    min=Math.min(min+a[i],a[i]);
    minsum=Math.min(minsum,min);
}
if(tot==minsum){ return maxsum;}

return Math.max(maxsum,tot-minsum);
    }
    
}

