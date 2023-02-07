package programmers.lv1;

public class 평균_구하기 {
    public static void main(String[] args) {
        Solution_평균_구하기 solution = new Solution_평균_구하기();
//        int[] arr = new int[]{1, 2, 3, 4};
        int[] arr = new int[]{5, 5};
        System.out.println(solution.solution(arr));
    }

}

class Solution_평균_구하기 {
    public double solution(int[] arr) {

        int length = arr.length;
        int sum = 0;
        double answer = 0;

        for (int i : arr) {
            sum += i;
        }

        answer = sum / (double) length ;

        return answer;
    }
}
