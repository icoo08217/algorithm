
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String num = br.readLine();
        Integer[] arr = new Integer[num.length()];

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            arr[i] = c - 48;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i : arr) {
            System.out.print(i);
        }

    }
}
