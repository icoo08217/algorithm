package programmers.완전탐색;

public class 최소직사각형 {
    public static void main(String[] args) {
        Solution_최소직사각형 solution = new Solution_최소직사각형();

        int[][] sizes = new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution.solution(sizes));

    }
}

class Solution_최소직사각형 {
    public int solution(int[][] sizes) {

        // 가로 : 두 변중 긴 부분
        // 세로 : 두 변중 짧은 부분
        int answer = 0;
        int max_v = 0; // 가로
        int max_h = 0; // 세로

        for (int i = 0; i < sizes.length; i++) {
            int v = Math.max(sizes[i][0] , sizes[i][1]);
            int h = Math.min(sizes[i][0] , sizes[i][1]);
            max_v = Math.max(max_v, v);
            max_h = Math.max(max_h, h);
        }

        answer = max_h * max_v;
        return answer;
    }
}
