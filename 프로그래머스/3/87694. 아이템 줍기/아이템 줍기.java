import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] twice = new int[102][102];

        // twice 채우기
        for (int[] rect : rectangle) {
            int lbx = rect[0] * 2;
            int lby = rect[1] * 2;
            int rtx = rect[2] * 2;
            int rty = rect[3] * 2;
            for (int y = lby; y <= rty; y++) {
                for (int x = lbx; x <= rtx; x++) {
                    twice[y][x] = 2;
                }
            }
        }

        // twice 선 그리기
        for (int i = 0; i < twice.length; i++) {
            for (int j = 0; j < twice[i].length; j++) {
                if (twice[i][j] == 2 && (twice[i-1][j] == 0 || twice[i+1][j] == 0 || twice[i][j-1] == 0 || twice[i][j+1] == 0 ||
                    twice[i-1][j-1] == 0 || twice[i-1][j+1] == 0 || twice[i+1][j-1] == 0 || twice[i+1][j+1] == 0)) {
                    twice[i][j] = 1;
                }
            }
        }
        twice[itemY * 2][itemX * 2] = 3;

        // bfs
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(characterY * 2, characterX * 2, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            twice[point.i][point.j] = -1;

            for (int[] direction : directions) {
                if (point.i + direction[0] >= 0 && point.j + direction[1] >= 0 && point.i + direction[0] <= 101 && point.j + direction[1] <= 101) {
                    if (twice[point.i + direction[0]][point.j + direction[1]] == 1) {
                        queue.add(new Point(point.i + direction[0], point.j + direction[1], point.count + 1));
                    } else if (twice[point.i + direction[0]][point.j + direction[1]] == 3) {
                        return (point.count + 1) / 2;
                    }
                }
            }
        }

        return 0;
    }

    class Point {
        int i;
        int j;
        int count;

        public Point(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }
}