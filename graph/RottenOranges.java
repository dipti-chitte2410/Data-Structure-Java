package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

//    ### Problem 2 — Rotting Oranges (LeetCode #994)
//
//**Question:**
//- 0 = empty cell
//- 1 = fresh orange
//- 2 = rotten orange
//
//    Every minute rotten orange makes adjacent fresh oranges rotten. Find minimum minutes until all oranges rot. Return -1 if impossible.
//```
//    grid = [
//            [2, 1, 1],
//            [1, 1, 0],
//            [0, 1, 1]
//            ]
//
//    Minute 0: [[2,1,1],[1,1,0],[0,1,1]]   start
//    Minute 1: [[2,2,1],[2,1,0],[0,1,1]]   rotten spreads
//    Minute 2: [[2,2,2],[2,2,0],[0,1,1]]   spreads more
//    Minute 3: [[2,2,2],[2,2,0],[0,2,1]]   spreads more
//    Minute 4: [[2,2,2],[2,2,0],[0,2,2]]   all rotten
//
//    Answer: 4

    public static void main(String arfs[]) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] rottenGrid = new int[rows][cols];
        int minutes = 0;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!queue.isEmpty() && fresh>0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int []latest=queue.poll();
                int newRow=latest[0];
                int newCol=latest[1];
                for (int[] direction : directions) {
                    int newR = direction[0] + newRow;
                    int newC = direction[1] + newCol;
                    if (newR >= 0 && newR < rows && newC >= 0 && newC < cols
                            && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        fresh--;
                        queue.add(new int[]{newR, newC});
                    }
                }
            }
            minutes++;
        }
        int ans = fresh == 0 ? minutes : -1;  // if fresh remain → impossible
        System.out.println(ans);
    }

}
