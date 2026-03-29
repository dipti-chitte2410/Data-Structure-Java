package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
//    **Question:** Count number of islands. Island = group of connected 1s surrounded by 0s.
//```
//    grid = [
//            [1, 1, 0, 0, 0],
//            [1, 1, 0, 0, 0],
//            [0, 0, 1, 0, 0],
//            [0, 0, 0, 1, 1]
//            ]
//
//    Island 1: top-left group of 1s
//    Island 2: middle 1
//    Island 3: bottom-right group of 1s
//
//    Answer: 3
//            ```
//
//            **Think like this:**
//            ```
//    Loop through every cell in grid
//    If cell is '1' and not visited → found a new island → count++
//    BFS from this cell → mark all connected 1s as visited
//            (so we don't count them again as new islands)
//
//    Continue looping → next unvisited '1' → new island → count++

    //    grid = [
//            [1, 1, 0, 0, 0],
//            [1, 1, 0, 0, 0],
//            [0, 0, 1, 0, 0],
//            [0, 0, 0, 1, 1]
//            ]

    public static void main(String args[]){
        int[][] grid = { {1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0},{0, 0, 0, 1, 1} };
        int[][] direction={{0,1},{0,-1},{1,0},{-1,0}};
        int rows=grid.length;
        int cols=grid[0].length;
        int islands=0;
        boolean[][]visited=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1 && !visited[i][j]==true){
                    islands++;
                    bfsLevelSearch(grid,visited,direction,rows,cols,i,j);
                }
            }
        }
        System.out.println(islands);
    }

    public static void bfsLevelSearch(int grid[][] ,boolean visited[][],int directions[][],int rows,int cols,int currentR,int currentC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{currentR, currentC});
        visited[currentR][currentC]=true;
        while (!queue.isEmpty()) {
            int[] latest = queue.poll();
            int r = latest[0];
            int c = latest[1];

            for (int[] direction : directions) {
                int newRow=direction[0]+r;
                int newCol=direction[1]+c;

                if(newRow>=0 && newRow<rows  &&
                   newCol>=0 && newCol<cols &&
                   !visited[newRow][newCol] && grid[newRow][newCol]==1){
                    visited[newRow][newCol]=true;
                    queue.add(new int[]{newRow,newCol});
                }
            }
        }
    }
}
