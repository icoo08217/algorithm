import java.util.*;
import java.io.*;

class baek3190 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    static int[][] map;
    static int dx[] = {0, 1, 0, -1}; // 상 우 하 좌.
    static int dy[] = {-1, 0, 1, 0};
    static HashMap<Integer, String> move;
    static Queue<Snake> mySnake;
    static int currentDirection = 1;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        move = new HashMap<Integer, String>();
        mySnake = new LinkedList<Snake>();

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 사과의 개수

        // 맵에 사과 넣기
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            map[row][col] = 1; // 사과 위치 1
        }

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken()); // 뱀의 방향 변환 횟수

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            move.put(x, c);
        }

        mySnake.add(new Snake(0,0));
        int finishTime = start(2,1, n);
        System.out.println(finishTime);

    }

    static int start(int x, int y, int n) {
        int nowTime = 1;

        while (true) {
            // 뱀이 벽에 부딪힌 경우
            if ((x <= 0 || x > n) || (y <= 0 || y > n)) {
                return nowTime;
            }

            // 뱀의 몸에 부딪힌 경우
            if (map[y][x] == 2) {
                return nowTime;
            }

            if (map[y][x] == 0) { // 부딪힐 경우가 없을 경우
                Snake tail = mySnake.poll();
                map[tail.y][tail.x] = 0;
            }
            mySnake.add(new Snake(x, y)); // 머리 추가
            map[y][x] = 2;

            if (move.containsKey(nowTime)) { // 방향을 전환 해주어야함.
                String c = move.remove(nowTime); // key 값으로 map에서 찾아서 삭제 후에 해당 value 값을 가져옴.
                if (c.equals("L")) {
                    currentDirection = currentDirection == 0 ? (dx.length - 1) % 4 : (currentDirection - 1) % 4;
                }

                if (c.equals("D")) {
                    currentDirection = (currentDirection + 1) % 4;
                }
            }
                x += dx[currentDirection];
                y += dy[currentDirection];

                nowTime++;


        }
    }

    static class Snake{
        int x;
        int y;

        Snake(int x, int y ){
            this.x = x;
            this.y = y;
        }
    }
}