import java.util.*;
import java.io.*;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // DP Table create
        int[][] dp = new int[N+1][K+1];

        int[] W = new int[N+1];
        int[] V = new int[N+1];


        for (int i = 1; i<=N; i++){ // Weight , Value
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i =1; i<=N; i++){
            for(int j=1; j<=K; j++){
                dp[i][j] = dp[i-1][j];
                if ( j - W[i] >= 0) {  //현재 자신의 가방의 무게보다 무게가 남을 경우
                    dp[i][j] = Math.max(dp[i-1][j] , V[i] + dp[i-1][j - W[i]]); // 이전 아이템에서 구한 가치와 남은 무게의 가치  + 자신의 가치 중 큰 값을 취한다.
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}