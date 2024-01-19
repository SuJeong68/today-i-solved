import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] abv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (abv[2] <= abv[0]) {
            System.out.print(1);
        } else {
            int n = (int) Math.ceil((double) (abv[2] - abv[0]) / (abv[0] - abv[1]));
            System.out.print(n + 1);
        }
    }
}
