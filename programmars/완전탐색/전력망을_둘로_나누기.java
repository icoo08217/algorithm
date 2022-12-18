package programmers.완전탐색;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망을_둘로_나누기 {
    public static void main(String[] args) {
        Solution_전력망둘로나누기 solution = new Solution_전력망둘로나누기();
        int n = 9;
        int[][] wires = new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6}, {4,7},{7,8},{7,9}};
        System.out.println(solution.solution(n , wires));
    }
}

class Solution_전력망둘로나누기 {
    static int[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = n;

        arr = new int[n+1][n+1]; // 인접행렬 생성
        for (int i = 0; i < wires.length; i++) { // 인접행렬에 데이터 넣기
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        int x, y;

        // 선 하나씩 끊어보기
        for (int i = 0; i < wires.length; i++) {
            x = wires[i][0];
            y = wires[i][1];

            // 선 끊기
            arr[x][y] = 0;
            arr[y][x] = 0;

            //bfs
            answer = Math.min(answer, bfs(n, x));

            // 선 다시 복구
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        return answer;
    }

    private int bfs(int n, int start) {

        int[] visited = new int[n + 1];
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int point = queue.poll();
            visited[point] = 1;

            for (int i = 1; i <= n; i++) {
                if (visited[i] == 1) continue;
                if (arr[point][i] == 1) {
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        return (int) Math.abs(n - 2 * cnt);
    }
}