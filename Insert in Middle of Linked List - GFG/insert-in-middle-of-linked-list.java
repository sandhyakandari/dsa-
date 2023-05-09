//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        
        while(t-->0){
            int n = sc.nextInt();   
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++){
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            int key = sc.nextInt();
            
            //display(head);
            Solution obj = new Solution();
            obj.insertInMid(head, key);
            display(head);
            System.out.println();
        }
    }
    
    public static void display(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    public int getL(Node head){
        int i=0;
        while(head!=null){
            i++;
            head=head.next;
        }
        return i;
    }
    public Node insertInMid(Node head, int data){
        //Insert code here, return the head of modified linked list
    Node ne=new Node(data);
    if(head==null){
        return ne;
    }
    int len=getL(head);
    if(len%2==0){
        int p=len/2;
        Node cur=head;
        p--;
        while(p>0){
            p--;
            cur=cur.next;
        }
        Node temp=cur.next;
        cur.next=ne;
        ne.next=temp;
        return head;
    }
    
    else{
        int p=len/2;
        Node cur=head;
        while(p>0){
            p--;
            cur=cur.next;
        }
        Node temp=cur.next;
        cur.next=ne;
        ne.next=temp;
        return head;
    }
    }
}