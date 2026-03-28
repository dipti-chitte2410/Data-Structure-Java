package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {

    // Least Order Traversal
//           1          ← Level 1
//            / \
//            2   3        ← Level 2
//            / \   \
//            4   5   6      ← Level 3
    public static void main(String [] args){
        DFSTraversal.TreeNode treeNode = DFSTraversal.buildTree();
        Queue<DFSTraversal.TreeNode> queue=new LinkedList<>();
        queue.add(treeNode);

        while(!queue.isEmpty()){
            DFSTraversal.TreeNode node=queue.poll();
            System.out.println(node.value);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }

    }
}
