import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // 2 * n 타일링

    public static Integer dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 그림을 그려봄.
        //dp[N] = dp[N-1] + dp[N-2] 라는 점화식이 유추됨.
        dp = new Integer[N+2];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i<=N; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007 ;
        }

        System.out.println(dp[N] % 10007);

    }
}
