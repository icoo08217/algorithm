package programmers.lv2;

public class 타겟_넘버 {
    public static void main(String[] args) {
        Solution_타켓넘버 solution = new Solution_타켓넘버();
//        int[] numbers = new int[]{1, 1, 1, 1, 1};
        int[] numbers = new int[]{4,1,2,1};
//        int target = 3;
        int target = 4;
        System.out.println(solution.solution(numbers , target));
    }
}

class Solution_타켓넘버 {

    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public void dfs(int[] numbers, int depth, int sum, int target) {

        if (depth == numbers.length) {
            if (sum == target) answer++;
        } else {
            dfs(numbers, depth + 1, sum + numbers[depth], target);
            dfs(numbers, depth + 1, sum - numbers[depth], target);
        }

    }
}
