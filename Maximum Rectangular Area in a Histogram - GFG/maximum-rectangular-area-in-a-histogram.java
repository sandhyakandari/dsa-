//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        long right[]=new long[(int)n];
        long left[]=new long[(int)n];
        Stack<Integer>l=new Stack<>();
        Stack<Integer>r=new Stack<>();
        for(int i=0;i<n;i++){
            while(r.size()>0 && hist[r.peek()]>hist[i]){
                right[r.peek()]=i;
                r.pop();
            }
            r.push(i);
        }
        while(r.size()>0){
            right[r.peek()]=n;
            r.pop();
        }
        for(int i=(int)n-1;i>=0;i--){
            while(l.size()>0 && hist[l.peek()]>hist[i]){
                left[l.peek()]=i;
                l.pop();
            }
            l.push(i);
        }
        while(l.size()>0){
            left[l.peek()]=-1;
        l.pop();}
        long area=-1;
        for(int i=0;i<n;i++){
            long w=right[i]-left[i]-1;
            long an=w*hist[i];
            area=Math.max(an,area);
        }
        return area;
    }
        
}



