package Tree;

public class DFSTraversal {

    static TreeNode buildTree(){
        TreeNode root = new TreeNode(1);   // root = 1
        root.left     = new TreeNode(2);   // left child = 2
        root.right    = new TreeNode(3);   // right child = 3
        root.left.left  = new TreeNode(4); // left child of 2 = 4
        root.left.right = new TreeNode(5); // right child of 2 = 5
        root.right.right = new TreeNode(6);// ri
        root.left.right.right = new TreeNode(7); // right child of 2 = 5

        return root;
    }

    private static TreeNode inOrder(TreeNode root){
        if(root==null) return null;
        inOrder(root.left);
        System.out.println(root.value);
        return inOrder(root.right);
    }

    private static TreeNode preOrder(TreeNode root){
        if(root==null) return null;
        System.out.println(root.value);
        preOrder(root.left);
        return preOrder(root.right);
    }

    private static void postOrder(TreeNode root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }


    public static void main(String []args) {
        TreeNode root = buildTree();
        inOrder(root);
        System.out.println("PreOrder...");
        preOrder(root);

        System.out.println("PostOrder...");
        postOrder(root);
    }

static class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value){
        this.left=null;
        this.right=null;
        this.value=value;
    }
}
}
