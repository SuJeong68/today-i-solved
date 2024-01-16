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

        String line;
        while (!(line = br.readLine()).equals("0 0 0")) {
            int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            if (Math.pow(nums[0], 2) + Math.pow(nums[1], 2) == Math.pow(nums[2], 2)) {
                bw.write("right");
            } else {
                bw.write("wrong");
            }
            bw.newLine();
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
