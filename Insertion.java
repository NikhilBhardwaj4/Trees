package Trees;
import java.util.*;

public class Insertion {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Insertion tree = new Insertion();
        tree.populate(sc);
        tree.display();
    }
    private static class Node{
        int value;
         Node left;
         Node right;
        public Node(int value){
            this.value= value;
        }
    }
    private Node root;

    public void populate(Scanner sc){
        System.out.println("Enter the root node: ");
        int val = sc.nextInt();
        root = new Node(val);
        populate(sc,root);
    }
    // on left side-----
    public void populate(Scanner sc , Node node){
        System.out.println("Do you want to enter left of: "+ node.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of left of: "+node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc,node.left);
        }

        System.out.println("Do you want to enter on the right side of: "+node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value you want to enter the right of: "+node.value);
            int val =sc.nextInt();
            node.right=new Node(val);
            populate(sc,node.right);
        }
    }

    public void display(){
        display(this.root);
    }
    private void display(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.value);
        display(node.left );
        display(node.right);
    }
}
