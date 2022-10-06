import java.util.*;
import java.io.*;

class baek5582 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        int max = 0;

        for (int i = 1; i<str1.length()+1; i++){
            for (int j = 1; j<str2.length()+1; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }

            }
        }

        System.out.println(max);
    }
}