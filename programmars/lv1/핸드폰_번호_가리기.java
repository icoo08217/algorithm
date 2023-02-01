package programmers.lv1;

public class 핸드폰_번호_가리기 {
    public static void main(String[] args) {
//        String phone_number = "01033334444";
        String phone_number = "027778888";

        Solution_핸드폰_번호_가리기 solution = new Solution_핸드폰_번호_가리기();
        System.out.println(solution.solution(phone_number));
    }
}

class Solution_핸드폰_번호_가리기{
    public String solution(String phone_number) {

        /* phone_number 뒤 4자리는 남겨두고
         * 남은 자리는 모두 *로 표시하기
         * 뒤에 4자리를 저장해놓고
         * phone_number.length() - 4 만큼 *를 추가해주고 뒤에 4자리를 붙이기
         */

        String answer = "";

        String remaining = phone_number.substring(phone_number.length() - 4);
        int starCnt = phone_number.length() - 4;

        String star = "";
        for (int i = 0; i < starCnt; i++) {
            star = star.concat("*");
        }

        answer = star.concat(remaining);
        return answer;
    }
}
