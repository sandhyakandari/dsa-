//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {  
        Arrays.sort(arr,(a,b)->{
        double pwa=1.0*a.value/a.weight;
        double pwb=1.0*b.value/b.weight;
        if(pwa>pwb){
            return -1;
        }
        else{
            return 1;
        } });
         double tot=0;
         for(int i=0;i<n;i++){
             if(arr[i].weight<W){
                 tot=arr[i].value+tot;
                 W=W-arr[i].weight;
                 
             }
             else{
                 double x=1.0*arr[i].value/arr[i].weight;
                 double an=x*W;
                 tot=tot+an;
                 W=0; break;
             }
         }   return tot;}}