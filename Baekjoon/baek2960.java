import java.util.*;
import java.io.*;

class baek2960 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean check[] = new boolean[n + 1];

        check[0] = check[1] = true;

        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j+=i){
                if (check[j] == false){ // P로 교체 ( 즉 , 소수를 지웠다.)
                    cnt++;
                    check[j] = true;
                }

                if (cnt == k){
                    System.out.println(j);
                    System.exit(0);
                }
            }
        }

    }
}