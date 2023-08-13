package programmers.lv2;

public class jumpAndTeleportation {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int n = 5;
//        int n = 6;
        int n = 5000;
        System.out.println(solution.solution(n));
    }

    static class Solution{
        public int solution(int n) {
            int answer = 0;

            while (n != 0) {
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n-=1;
                    answer++;
                }
            }
            return answer;
        }
    }
}
