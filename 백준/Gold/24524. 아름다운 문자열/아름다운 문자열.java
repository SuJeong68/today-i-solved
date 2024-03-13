import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        char[] prev = new char[26];
        for (int i = 1; i < T.length(); i++) {
            prev[T.charAt(i) - 97] = T.charAt(i - 1);
        }

        int[] cnts = new int[26];
        for (char ch : S.toCharArray()) {
            int target = ch - 97;
            if (prev[target] == '\0' || cnts[prev[target] - 97] > cnts[target]) {
                cnts[target]++;
            }
        }

        System.out.println(cnts[T.charAt(T.length() - 1) - 97]);

        br.close();
    }
}