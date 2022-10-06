import java.io.*;
import java.util.*;

public class baek1748 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int result = 0; //
        int cnt = 1; // 자릿수
        int bound = 10; // 2의 자릿수를 의미하는 bound

        for (int i = 1; i <= N; i++) {
            if (i == bound) {
                cnt++;
                bound *= 10; // 두 자릿수 다음 세자릿수로 넘어감.
            }
            result += cnt; // 각 N의 자릿수를 더함.
        }

        System.out.println(result);
    }
}
