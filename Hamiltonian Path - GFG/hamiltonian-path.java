//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ boolean dfs(int i,boolean vis[],ArrayList<Integer>psf,ArrayList<ArrayList<Integer>>gr,int os){
    
   int n=gr.size()-1;
   if(psf.size()==n-1){
       return true;
   }
   vis[i]=true;
   psf.add(i);
   for(int nbr:gr.get(i)){
       if(!vis[nbr]){
           boolean an=dfs(nbr,vis,psf,gr,os);
           if(an){ return true;
       }
   }
}     vis[i]=false;
psf.remove(psf.size()-1);
return false;
}
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
         boolean vis[]=new boolean[N+1];
         ArrayList<Integer>psf=new ArrayList<>();
          ArrayList<ArrayList<Integer>>gr=new ArrayList<>();
          for(int i=0;i<=N;i++){
              gr.add(new ArrayList<Integer>());
          }
          for(ArrayList<Integer>e:Edges){
              int a=e.get(0);
              int b=e.get(1);
              gr.get(a).add(b);
              gr.get(b).add(a);
          }
        for(int i=1;i<N;i++){
            boolean isha=dfs(i,vis,psf,gr,i);
            if(isha){
                return true;
            }
        }
        return false;
        
    }
} 