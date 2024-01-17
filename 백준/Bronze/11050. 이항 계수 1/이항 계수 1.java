import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bw.write(Integer.toString(bc(nk[0], nk[1])));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int bc(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return bc(n - 1, k) + bc(n - 1, k - 1);
    }
}
