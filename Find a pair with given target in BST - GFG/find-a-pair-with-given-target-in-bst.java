//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int target = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.isPairPresent(root,target));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    class pair{
        Node root;
        int state;
        pair(Node root,int state){
            this.root=root;
            this.state=state;
        }
    }
    // root : the root Node of the given BST
    // target : the target sum
  public Node getleft(Stack<pair>st){
      while(st.size()>0){
          pair r=st.peek();
          if(r.state==1){
              r.state++;
              if(r.root.left!=null){
                  st.push(new pair(r.root.left,1));
              }
          }
          else if(r.state==2){
              r.state++;
              if(r.root.right!=null){ st.push(new pair(r.root.right,1));} return r.root;
      }
    else{ st.pop();
           
      }}
      return null;
  }
  public Node getri(Stack<pair>st){
      while(st.size()>0){
          pair r=st.peek();
          if(r.state==1){
              r.state++;
              if(r.root.right!=null){
                  st.push(new pair(r.root.right,1));
              }
          }
          else if(r.state==2){
              r.state++;
              if(r.root.left!=null){ st.push(new pair(r.root.left,1));} return r.root;
      }
    else{ st.pop(); 
      }}
      return null;  }
      public int isPairPresent(Node root, int target)
    {
        // Write your code here
        
        Stack<pair>le=new Stack<>();
        
        Stack<pair>ri=new Stack<>();
        le.push(new pair(root,1));
        ri.push(new pair(root,1));
        
        Node s=getleft(le);
        int ans=0;
        Node e=getri(ri);
        while(s.data<e.data){
            if(s.data+e.data==target){
                ans=1;
                break;
            }
            else if(s.data+e.data>target){
                 e=getri(ri);
            }
            else{ s=getleft(le);
        }
    }
    return ans;
}
}