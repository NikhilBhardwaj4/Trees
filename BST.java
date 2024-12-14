package Trees;
public class BST{
    public class Node{
        int value;
        int height;
        Node left;
        Node right;

        public Node(int value){
            this.value=value;
        }
    }
    static Node root;

    public Node insert(int value,Node node){
        if(node==null){
            node = new Node(value);
            return node ;
        }
        if(value<node.value){
            node.left=insert(value,node.left);
        } else node.right= insert(value,node.right);
        return node;
    }
    public void display(Node node , String str){
        if(node == null){
            return;
        }
        System.out.println(str+node.value);
        display(node.left,"left of "+node.value+ ": ");
        display(node.right,"Right of "+node.value+ ": ");
    }
    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            root = this.insert(nums[i],root);
        }
    }
    public Node populatesorted(int[] nums,int start ,int end){
        if(start>=end){
            return null;
        }
        int mid = (start+end)/2;
        root = this.insert(nums[mid],root);
        populatesorted(nums,start,mid);
        populatesorted(nums,mid+1,end);
        return root;
    }

    public int height(Node node){
        if(node==null){
            return -1;
        }
        int hleft= height(node.left);
        int hright=height(node.right);
        return Math.max(hleft,hright)+1;
    }
    public boolean balanced(Node node){
        if(node==null) return true;
        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left) && balanced(node.right);
    }
    private void preorder(){
        preorder(root);
    }
    private void preorder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.value+" ");
        preorder(node.left);
        preorder(node.right);
    }
    private void inorder(){
        inorder(root);
    }
    private void inorder(Node node ){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.value+" ");
        inorder(node.right);
    }
    private void postorder(){
        inorder(root);
    }
    private void postorder(Node node ){
        if(node==null){
            return;
        }
        inorder(node.left);
        inorder(node.right);
        System.out.print(node.value+" ");
    }

    public static void main(String[] args) {
        int[] nums={5,2,7,1,4,6,9,8,3,10};
        int[] arr ={1,2,3,4,5,6};
        BST tree = new BST();
//        tree.populate(nums);
//        tree.display(root,"");
//        System.out.println(tree.height(root));
//        System.out.println(tree.balanced(root));
      //  tree.root=tree.populatesorted(arr,0,arr.length);
        tree.populate(nums);
        tree.inorder();



    }
}
























