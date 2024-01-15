import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] splited = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 최대공약수
        int m = -1;
        int gcd = splited[0];
        int tmp = splited[1];
        while (m != 0) {
            m = gcd % tmp;
            gcd = tmp;
            tmp = m;
        }
        bw.write(Integer.toString(gcd));
        bw.newLine();

        // 최소공배수
        int lcm = splited[0] * splited[1] / gcd;
        bw.write(Integer.toString(lcm));
        bw.flush();

        br.close();
        bw.close();
    }
}
