import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] splited = br.readLine().split(" ");
        int k = Integer.parseInt(splited[0]);
        int n = Integer.parseInt(splited[1]);

        int[] lines = new int[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[i]);
        }

        bw.write(Long.toString(solution(k, n, lines, max)));
        bw.flush();
    }

    public static long solution(int k, int n, int[] lines, long max) {
        long start = 0;
        long end = max + 1;
        while (start < end) {
            long mid = (start + end) / 2;

            long count = 0;
            for (int i = 0; i < k; i++) {
                count += lines[i] / mid;
            }

            if (count < n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start - 1;
    }
}
