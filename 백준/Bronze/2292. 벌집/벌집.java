import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.print(1);
            return;
        }

        // 6, 12, 18, 24, ...
        int depth = 1;
        int min = 1;
        int max = min + depth * 6;
        while (true) {
            if (min < n && n <= max) {
                System.out.println(depth + 1);
                return;
            }
            depth++;
            min = max;
            max = min + depth * 6;
        }
    }
}