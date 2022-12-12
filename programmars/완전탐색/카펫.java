package programmers.완전탐색;

public class 카펫 {
    public static void main(String[] args) {
        Solution_카펫 solution = new Solution_카펫();

        int brown = 24;
        int yellow = 24;

        System.out.println(solution.solution(brown , yellow)[0]);
        System.out.println(solution.solution(brown , yellow)[1]);
    }
}

class Solution_카펫 {
    public int[] solution(int brown, int yellow) {

        int[] answer = new int[2];
        int sum = brown + yellow;

        // 1. 행과 열의 갯수가 3이상이어야 한다.
        // 2. brown 개수와 yellow 개수를 합치면 return 개수의 곱과 같다.
        // 3. 카펫의 가로 길이는 세로길이와 같거나 커야한다.
        // 4. return 값의 가로 - 2 * 세로 - 2 = yellow 가 성립해야한다.

        for (int i = 3; i < sum; i++) {
            int j = sum / i;

            if (sum % i == 0 && j >= 3) {
                int row = Math.max(i, j);
                int col = Math.min(i, j);

                int center = (row - 2) * (col - 2);

                if (yellow == center) {
                    answer[0] = row;
                    answer[1] = col;
                    return answer;
                }
            }
        }
        return answer;
    }
}
