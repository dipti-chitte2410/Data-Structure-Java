package Tree;

import javax.swing.tree.TreeNode;

public class MaximumDepthOfBinaryTree {
    //         1          ← Level 1
//            / \
//            2   3        ← Level 2
//            / \   \
//           4   5   6      ← Level 3

//    Depth of tree = 1 + max(depth of left subtree, depth of right subtree)

//    depth(1) = 1 + max(depth(2), depth(3))
//    depth(2) = 1 + max(depth(4), depth(5))
//    depth(4) = 1 + max(null, null) = 1
//    depth(5) = 1 + max(null, null) = 1
//    depth(2) = 1 + max(1, 1)      = 2
//    depth(3) = 1 + max(null, null) = 1
//    depth(1) = 1 + max(2, 1)      = 3 ✅3

    public static int getLevel(DFSTraversal.TreeNode root){
        int leftLevel = 0;
        int rightLevel=0;
        if(root.left!=null){
            leftLevel=getLevel(root.left);
        }
        if(root.right!=null){
            rightLevel=getLevel(root.right);
        }
        return 1+ Math.max(leftLevel,rightLevel);
    }

    public static void main(String [] args){
        DFSTraversal.TreeNode treeNode = DFSTraversal.buildTree();
        int ans=getLevel(treeNode);
        System.out.println(ans);
    }
}
