import java.util.*;

public class InsertionAndDeletion {
static class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
    public static void main(String args[]){
        Node root = new Node(10);
        root.left= new Node(15);
        root.right=  new Node (20);
        root.left.left=new Node(16);
        root.right.right= new Node(32);
        System.out.print("Befor Insertion : ");
        inorder(root);

        System.out.println("After Insertion : ");
        insert(root,25);
        inorder(root);
        System.out.println();
        delete(root, 25);
        System.out.print("After Deletion: ");
        inorder(root);

    }

    public static void  insert(Node root,int key){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node cur = queue.remove();
            if(cur.left==null){
                cur.left=new Node(key);
                break;
            }
            else{
                queue.add(cur.left);
            }
            if(cur.right==null){
                cur.right= new Node(key);
                break;
            }
            else{
                queue.add(root.right);
            }
        }
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        //LNR
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
public static void delete(Node root, int key) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.data == key) {
                root = null;
            }
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node keyNode = null;
        Node last = null;
        Node parentOfLast = null;

        // Find the node to delete and the last node
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.data == key) {
                keyNode = temp;
            }

            if (temp.left != null) {
                parentOfLast = temp;
                queue.add(temp.left);
            }
            if (temp.right != null) {
                parentOfLast = temp;
                queue.add(temp.right);
            }

            last = temp;
        }

        if (keyNode != null) {
            keyNode.data = last.data; // Copy last node's data
            // Delete the deepest node
            if (parentOfLast.left == last) {
                parentOfLast.left = null;
            } else {
                parentOfLast.right = null;
            }
        }
    }
}

