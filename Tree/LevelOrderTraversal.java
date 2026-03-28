package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

//                     1
//                    / \
//                    2   3
//                    / \   \
//                   4   5   6
//
//    Answer: [[1], [2,3], [4,5,6]]
    public static void main(String [] args) {
        DFSTraversal.TreeNode treeNode = DFSTraversal.buildTree();
        Queue<DFSTraversal.TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            List<Integer> levelList=new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                DFSTraversal.TreeNode current = queue.poll();
                levelList.add(current.value);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            list.add(levelList);
        }

        System.out.println(list);

    }
}
