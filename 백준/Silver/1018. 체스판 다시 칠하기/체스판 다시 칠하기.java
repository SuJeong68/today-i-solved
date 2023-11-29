import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        bw.write(solution(n, m, board));
        bw.flush();
    }

    public static String solution(int n, int m, String[] board) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                for (char start : new char[]{'B', 'W'}) {
                    int cnt = 0;
                    for (int x = i; x < i + 8; x++) {
                        for (int y = j; y < j + 8; y++) {
                            if (((x + y) % 2 == 0 && start != board[x].charAt(y)) ||
                                ((x + y) % 2 != 0 && start == board[x].charAt(y))) {
                                cnt++;
                            }
                        }
                    }
                    min = Math.min(min, cnt);
                }
            }
        }
        return Integer.toString(min);
    }
}
