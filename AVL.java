package Trees;

public class AVL {
    public static class Node {
        int value;
        int height;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;
// inserting a node---------------------------------------------------------------------
    public void insert(int value){
        root = insert(value,root);
    }
    private Node insert(int value, Node node ){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value<node.value){
            node.left=insert(value,node.left);
        } else node.right=insert(value,node.right);

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node);
    }
// height of a node-------------------------------------------------------------
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

// rotating left and right function -----------------------------------------------------
    private Node rotate(Node node){
        //checking if left heavy--->
        if(height(node.left)-height(node.right)>1){
            //checking if left-left case
            if(height(node.left.left)-height(node.left.right)>0){
                return rotateright(node);
            }
            //checking if left right case
            if(height(node.left.left)-height(node.left.right)<0){
                node.left=rotateleft(node.left);
                return rotateright(node);
            }
        }
        // checking if right heavy--->
        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if(height(node.right.left) - height(node.right.right) < 0) {
                // right right case
                return rotateleft(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0) {
                // left right case
                node.right =
                        rotateright(node.right);
                return rotateleft(node);
            }
        }
        return node;
    }


    // Right rotate------------
    public Node rotateright(Node p){
        Node c=p.left;
        Node t=c.right;

        // rotating right from p
        c.right=p;
        p.left=t;

        c.height = Math.max(height(c.left),height(c.right)+1);
        p.height=Math.max(height(p.left),height(p.right)+1);
        return c;
    }

    //Left rotate-------------
    public Node rotateleft(Node c){
        Node p=c.right;
        Node t=p.left;

        //rotating left from c
        p.left=c;
        c.right=t;

        p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);

        return p;
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }
        System.out.println(tree.height());
    }

}


