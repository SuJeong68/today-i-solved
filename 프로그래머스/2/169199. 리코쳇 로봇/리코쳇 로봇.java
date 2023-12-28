import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String[] board) {
        final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();

        int[][] visited = new int[board.length][board[0].length()];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (board[i].charAt(j) == 'R') {
                    visited[i][j] = 1;
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] d = directions[i];
                int x = c[0] + d[0];
                int y = c[1] + d[1];
                while (x >= 0 && y >= 0 && x < board.length && y < board[0].length() && board[x].charAt(y) != 'D') {
                    x += d[0];
                    y += d[1];
                }
                x -= d[0];
                y -= d[1];

                if (board[x].charAt(y) == 'G') {
                    return visited[c[0]][c[1]];
                }

                if (visited[x][y] == 0) {
                    visited[x][y] = visited[c[0]][c[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        
        return -1;
    }
}