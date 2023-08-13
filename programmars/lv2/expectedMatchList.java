package programmers.lv2;

public class expectedMatchList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(solution.solution(n , a , b));
    }

    static class Solution{
        public int solution(int n, int a, int b){
            int answer = 0;

            while (true) {
                a = a/2 + a%2;
                b = b/2 + b%2;
                answer++;
                if (a == b) break;
            }
            return answer;
        }
    }
}
