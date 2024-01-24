import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int r = 31;
        final int M = 1234567891;

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long sum = 0;
        for (int i = 0; i < L; i++) {
            sum += Math.pow(r, i) * (str.charAt(i) - 96);
        }
        System.out.println(sum % M);

        br.close();
    }
}
