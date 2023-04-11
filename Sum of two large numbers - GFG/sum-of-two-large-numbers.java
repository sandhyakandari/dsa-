//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String x = read.readLine();
            String y = read.readLine();
            Solution ob = new Solution();
            String result = ob.findSum(x, y);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String findSum(String X, String Y) {
        // code here
        int n=X.length()-1;
        String s="";
        int i=Y.length()-1;int car=0;
        while(n>=0 && i>=0){
            int a=(int)X.charAt(n)-48;
            int b=(int)Y.charAt(i)-48;
            int an=a+b+car;
            if(an>=10){        int rem=an%10;        car=an/10;        s=rem+s;}
            else{ s=an+s;
            car=0;}
        i--;    n--;     }         while(n>=0){     int a=(int)X.charAt(n)-48;     int an=a+car;
         if(an>=10){    int rem=an%10; car=an/10;         s=rem+s;         }
         else{ car=0;     s=an+s;     } n--;}
     while(i>=0){     int a=(int)Y.charAt(i)-48;     int an=a+car;
         if(an>=10){
            int rem=an%10;
             car=an/10;         s=rem+s;     }
         else{ car=0;
         s=an+s;     } i--;   }
     if(car>0){ s=car+s;
    } int k=0; String ans="";
        while(k<s.length()){
            if(s.charAt(k)=='0'){     } else{ break;}   k++;    }
            if(k==s.length()){ return "0";}
        while(k<s.length()){
            ans=ans+s.charAt(k);
            k++;
        }
    return ans;}}