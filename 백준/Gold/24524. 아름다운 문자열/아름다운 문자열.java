import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] S = br.readLine().toCharArray();
        char[] T = br.readLine().toCharArray();

        char[] prev = new char[26];
        for (int i = 1; i < T.length; i++) {
            prev[T[i] - 97] = T[i - 1];
        }

        int[] cnt = new int[26];
        for (char ch : S) {
            int target = ch - 97;
            if (prev[target] == '\0' || cnt[prev[target] - 97] > cnt[target]) {
                cnt[target]++;
            }
        }

        System.out.println(cnt[T[T.length - 1] - 97]);

        br.close();
    }
}
