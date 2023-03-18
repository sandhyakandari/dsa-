//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{ public static class pair{
     int wsf;
     int node;
     String  psf;
pair(int wsf,int node,String psf){
    this.wsf=wsf;
    this.node=node;
    this.psf=psf;
}}
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)->{
            return a.wsf-b.wsf;});
        q.add(new pair(0,S," "+S));
        int vis[]=new int[V];
        Arrays.fill(vis,-1);
        while(q.size()>0){
             pair c=q.remove();
             int wsf=c.wsf;
             int node=c.node;
             String psf=c.psf;
             if(vis[node]!=-1){ continue;}
             vis[node]=wsf;
             for(ArrayList<Integer> ar:adj.get(node)){
                 int nbr=ar.get(0);
                 int cost=ar.get(1);
                 if(vis[nbr]==-1){
                     q.add(new pair(wsf+cost,nbr,psf+nbr));
                 }
             }
        }
        return vis;
        
    }
        
    }

