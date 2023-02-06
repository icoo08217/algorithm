package programmers.lv1;

public class 자릿수_더하기 {
    public static void main(String[] args) {
        Solution_자릿수_더하기 solution = new Solution_자릿수_더하기();
        System.out.println(solution.solution(123));
        System.out.println(solution.solution(987));
    }
}

class Solution_자릿수_더하기 {
    public int solution(int n) {

        /*
        n 이 들어오면 String 형태로 값을 변환한 다음에
        String의 length 만큼 반복하여 각 자리의 숫자를 String -> Integer로 한 뒤에
        sum 에 계산한다.
         */
        int answer = 0;
        String number = String.valueOf(n);

        for (int i = 0; i < number.length(); i++) {
            String s = String.valueOf(number.charAt(i));
            int num = Integer.parseInt(s);

            answer += num;
        }

        return answer;
    }
}