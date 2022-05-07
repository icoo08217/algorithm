import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static int N , K ;
    public static int[] check;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        check = new int[100001];

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }


    }

    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        check[x] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int nextN = 0;

                if (i == 0) {
                    nextN = temp - 1;
                } else if (i == 1) {
                    nextN = temp + 1;
                } else {
                    nextN = temp * 2;
                }

                if (nextN == K) {
                    System.out.println(check[temp]);
                    return;
                }

                if (nextN >= 0 && nextN < check.length && check[nextN] == 0) {
                    q.add(nextN);
                    check[nextN] = check[temp] + 1; // 1초 추가
                }
            }
        }

    }
}