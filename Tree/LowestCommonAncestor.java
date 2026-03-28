package Tree;

public class LowestCommonAncestor {
//                  3
//                 / \
//                5   1
//                / \ / \
//               6  2 0  8
//               / \
//              7   4
//
//    LCA of 5 and 1 → 3   (3 is parent of both)
//    LCA of 5 and 4 → 5   (5 is ancestor of 4, so 5 itself)
//    LCA of 6 and 4 → 5   (5 is first common ancestor)
    public static void main(String args[]){
        DFSTraversal.TreeNode node = DFSTraversal.buildTree();
        DFSTraversal.TreeNode foundRoot=traverse(node,node.left,node.left.right);
        System.out.println(foundRoot.value);
    }


    static DFSTraversal.TreeNode traverse(DFSTraversal.TreeNode node, DFSTraversal.TreeNode node1,DFSTraversal.TreeNode node2){
        if(node==null){
            return null;
        }

        if(node==node1 || node==node2){
            return node;
        }

        DFSTraversal.TreeNode left=traverse(node.left,node1,node2);
        DFSTraversal.TreeNode right=traverse(node.right,node1,node2);

        if(left!=null && right!=null){
            return node;
        }
        return node.left!=null ? left:right;
    }
}
