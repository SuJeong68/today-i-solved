import java.util.*;

class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int solution(int[][] maps) {
        int n = maps.length - 1;
        int m = maps[0].length - 1;

        boolean[][] visited = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (maps[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        return bfs(maps, visited);
    }

    public int bfs(int[][] maps, boolean[][] visited) {
        Queue<Room> queue = new LinkedList<>();
        queue.offer(new Room(0, 0, null));

        while (!queue.isEmpty()) {
            Room current = queue.poll();
            int i = current.i;
            int j = current.j;

            int count = 1;
            if (current.prev != null) {
                count = maps[current.prev.i][current.prev.j] + 1;
            }

            if (visited[i][j]) {
                maps[i][j] = Math.min(count, maps[i][j]);
            } else {
                maps[i][j] = count;

                for (int[] direction : directions) {
                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];
                    if (nextI < 0 || nextJ < 0 || nextI >= maps.length || nextJ >= maps[0].length) {
                        continue;
                    }

                    if (maps[nextI][nextJ] != 0 && !visited[nextI][nextJ]) {
                        queue.offer(new Room(nextI, nextJ, current));
                    }
                }
            }
            visited[i][j] = true;
        }

        int result = maps[maps.length - 1][maps[0].length - 1];
        if (result == 1) {
            return -1;
        }
        return result;
    }
}

class Room {
    int i;
    int j;
    Room prev;

    Room(int i, int j, Room prev) {
        this.i = i;
        this.j = j;
        this.prev = prev;
    }
}