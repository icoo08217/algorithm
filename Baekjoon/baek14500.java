import java.util.*;
import java.io.*;

class baek14500 {

    public static int n, m , a[][], result;
    public static boolean check[][];
    public static int dx[] = {0, 0, 1, -1};
    public static int dy[] = {-1, 1, 0, 0};

    public static int ex[][] = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    public static int ey[][] = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};


    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        //1. 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n+1][m+1];
        check = new boolean[n+1][m+1];
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                check[i][j] = false;
            }
        }

        for (int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2. 계산
        //2. 2차원 배열 각각의 원소에서 검사를 수행합니다.
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                // 1) DFS 로 검사
                // 방문했던 점을 또 방문해야하기 때문에
                // 들어가기전 체크를 해주고 , 끝났을때 체크를 해제해줍니다.
                check[i][j] = true;

                dfs(i,j,a[i][j],1);

                // 체크를 해제하면 무한루프에 들어가지않을까 걱정할 수 있다.
                // 길이로 재귀를 중단시키기 때문에, 수행횟수는 4 * 3 * 3, 한점에서 최대 36번 수행됩니다.
                check[i][j] = false;

                // 2) ㅏ 모양 검사
                check_exshape(i, j);
            }
        }


        // 3. 출력
        System.out.println(result);
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    // DFS 로 4가지 모양 검사 ( ㅜ 제외 )
    public static void dfs(int x, int y , int sum_value, int length){
        //길이가 4 이상이면 종료해줍니다.
        if (length >= 4){
            result = max(result, sum_value);
            return;
        }

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            //지도 넘어가는 경우 검사
            if(nx < 1 || nx > n || ny < 1 || ny > m) continue;

            // 방문하지 않은 점이면
            if (check[nx][ny] == false){

                // 들어가기 전 체크해주고
                check[nx][ny] = true;

                dfs(nx,ny,sum_value + a[nx][ny] , length + 1);
                // 하나의 탐색을 완료하면 여기로 돌아옵니다.

                // 나올때 체크를 해제
                check[nx][ny] = false;
            }
        }
    }

    // ㅜ 모양 검사
    public static void check_exshape(int x, int y) {
        for (int i=0; i<4; i++){

            boolean isOut = false;
            int sum_value = 0;

            for (int j=0; j<4; j++){
                int nx = x + ex[i][j];
                int ny = y + ey[i][j];

                if(nx < 1 || nx > n || ny < 1 || ny > m) {
                    isOut = true;
                    break;
                }
                else {
                    sum_value += a[nx][ny];
                }
            }
            if(!isOut) {
                result = max(result, sum_value);
            }
        }
    }
}