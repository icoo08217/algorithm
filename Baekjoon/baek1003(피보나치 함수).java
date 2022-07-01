import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // DP 실버3 피보나치 함수
    static int count_0 ;
    static int count_1 ;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        dp = new Integer[41][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }
        System.out.println(sb);
    }

    public static Integer[] fibonacci(int n){
        if (dp[n][0] == null || dp[n][1] == null){
            dp[n][0] = fibonacci(n-2)[0] + fibonacci(n-1)[0];
            dp[n][1] = fibonacci(n-2)[1] + fibonacci(n-1)[1];
        }

        return dp[n];
    }
}
