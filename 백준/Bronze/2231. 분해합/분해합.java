import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 0; i < n; i++) {
            int num = i;
            int sum = num;

            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
