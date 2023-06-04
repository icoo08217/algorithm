package programmers.lv2;

public class JadenCase_문자열_만들기 {
    public static void main(String[] args) {
        Solution_JadenCase_문자열_만들기 solution = new Solution_JadenCase_문자열_만들기();
        String s = "3people   unFollowed me";
//        String s = "for the last week";
        System.out.println(solution.solution(s));
    }
}

class Solution_JadenCase_문자열_만들기{
    public String solution(String s){
        String answer = "";

        String[] spl = s.split(" ");

        for (int i = 0; i < spl.length; i++) {
            String now = spl[i];

            // 문자열 길이 0
            if(spl[i].length() == 0) {
                answer += " ";
            }
            // 문자
            else {
                answer += now.substring(0, 1).toUpperCase();
                answer += now.substring(1).toLowerCase();
                answer += " ";
            }
        }

        if(s.substring(s.length() - 1, s.length()).equals(" ")) {
            return answer;
        }

        return answer.substring(0, answer.length() - 1);
    }
}
