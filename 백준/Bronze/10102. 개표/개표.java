import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int A = 0;
        int B = 0;

        for (char ch : str.toCharArray()) {
            if (ch == 'A') {
                A++;
            } else if (ch == 'B') {
                B++;
            }
        }

        if (A == B) {
            System.out.println("Tie");
        } else {
            System.out.println(A > B ? 'A' : 'B');
        }

        br.close();
    }
}
