//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().immediateSmaller(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void immediateSmaller(int arr[], int n) {
        // code here
        int ans[]=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
                if(st.size()>0 && arr[i]<arr[st.peek()]){
                    ans[st.peek()]=arr[i];
                st.pop();}
            st.push(i);
        }
        while(st.size()>0){
            ans[st.peek()]=-1;
            st.pop();
        }
        for(int i=0;i<ans.length;i++){
            arr[i]=ans[i];
        }
    }
}