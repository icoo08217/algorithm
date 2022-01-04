import java.util.*;
import java.io.*;

class Main{

    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        maze = new int[N][M];

        // 미로 배열 완성하기
        for (int i=0; i<N; i++){
            String s = br.readLine();
            for (int j=0; j<M; j++){
                maze[i][j] = s.charAt(j) - '0'; // s.charAt(j) 는 아스키코드로 저장되어 있기 때문에
                // 49라는 값이 저장되어있다. 그러므로 '1'(49) - '0'(48) 을 해주어야 int로 저장 되었을 때
                // 정상적인 0 , 1 이 저장될 수 있다. 
            }
        }

        // 방문 체크를 위한 visited 배열
        visited = new boolean[N][M];
        visited[0][0] = true; // 첫번째부터 시작하기 때문에 방문한거로 간주
        bfs(0,0);
        System.out.println(maze[N-1][M-1]);

    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>(); // bfs를 위한 큐 생성
        q.add(new int[] {x,y}); // 큐에 매개변수를 배열로 추가.

        while(!q.isEmpty()){
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue; // 다음의 X, Y 가 2차원배열의 왼쪽으로 벗어나거나
                // 다음의 X, Y 가 2차원 배열의 오른쪽으로 벗어나면  --> 다음 노드는 갈수 없으므로 넘어간다.
                if (visited[nextX][nextY] || maze[nextX][nextY] == 0) continue;

                q.add(new int[]{nextX, nextY});
                maze[nextX][nextY] = maze[nowX][nowY] + 1; // 최소 카운트를 센다.
                visited[nextX][nextY] = true;

            }
        }


    }
}