package programmers.lv2;

import java.util.Arrays;

public class 최솟값_만들기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{1, 4, 2};
        int[] B = new int[]{5, 4, 4};
        System.out.println(solution.solution(A , B));
    }

    static class Solution {
        public int solution(int[] a, int[] b) {
            int answer = 0;

            Arrays.sort(a);
            Arrays.sort(b);

            int size = a.length;
            System.out.println(size);
            for (int i = 0; i < a.length; i++) {
                answer += a[i] * b[size - (i+1)];
            }

            return answer;
        }
    }
}
