package programmers.lv2;

public class 최댓값과_최솟값 {
    public static void main(String[] args) {
        Solution_최댓값과_최솟값 solution = new Solution_최댓값과_최솟값();
//        String s = "1 2 3 4";
//        String s = "-1 -2 -3 -4";
        String s = "-1 -1";
        System.out.println(solution.solution(s));
    }
}

class Solution_최댓값과_최솟값{
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");

        int max = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[0]);

        for (String number : arr) {
            max = Math.max(max, Integer.parseInt(number));
            min = Math.min(min, Integer.parseInt(number));
        }

        answer = min + " " + max;

        return answer;
    }
}
