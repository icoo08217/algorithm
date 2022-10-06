import java.util.*;
import java.io.*;

class baek11724{

    static int n , m;
    static int check[][];
    static boolean visited[];
    static int cnt=0;
    static int u,v ;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new int[1001][1001];
        visited = new boolean[1001];


        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            check[u][v] = check[v][u] = 1;
        }

        for (int i =1; i<=n; i++){
            if (visited[i] == false){
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);


    }

    public static void dfs(int i){

        if (visited[i] == true){
            return;
        }
        else {
            visited[i] = true;

            for (int j=1; j<=n; j++){
                if (check[i][j] == 1){
                    dfs(j);
                }
            }
        }

    }
}