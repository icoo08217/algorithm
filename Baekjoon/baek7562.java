import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T , l;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int presentX , presentY ;
    static int finalX , finalY;
    static int[][] chess;
    static boolean[][] check;
    static Queue<Knight> q = new LinkedList<Knight>();

    public static void main(String[] args) throws IOException{
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine());
            chess = new int[l][l];
            check = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            presentX = Integer.parseInt(st.nextToken());
            presentY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            finalX = Integer.parseInt(st.nextToken());
            finalY = Integer.parseInt(st.nextToken());

            bfs(new Knight(presentX, presentY));
            System.out.println(chess[finalX][finalY]);
        }
    }

    static void bfs(Knight k) {

        q.clear();
        check[k.x][k.y] = true;
        q.add(k);

        while (!q.isEmpty()) {

            Knight pK = q.remove();
            int x = pK.x;
            int y = pK.y;

            if (x == finalX && y == finalY) { // 시작지점이 도착지점일 경우
                return;
            }

            for (int j = 0; j < dx.length; j++) {
                int nx = dx[j] + x;
                int ny = dy[j] + y;

                if (nx >= 0 && ny >= 0 && nx < l && ny < l) {
                    if (!check[nx][ny]) {
                        q.add(new Knight(nx, ny));
                        check[nx][ny] = true;
                        chess[nx][ny] = chess[x][y] + 1;
                    }
                }
            }
        }
    }

    static class Knight {
        int x ;
        int y ;

        public Knight(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
