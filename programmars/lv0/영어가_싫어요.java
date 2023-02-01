package programmers.lv0;

import java.util.HashMap;

public class 영어가_싫어요 {

    public static void main(String[] args) {
//        String numbers = "onetwothreefourfivesixseveneightnine";
        String numbers = "onefourzerosixseven";
        solution_영어가_싫어요 solution = new solution_영어가_싫어요();
        System.out.println(solution.solution(numbers));
    }
}

class solution_영어가_싫어요 {
    public long solution(String numbers) {

        // 들어온 문자열을 숫자로 변환하자
        // HashMap 에 문자열 , 숫자 로 만들고
        // numbers 에 한 문자씩 접근하면서 해당 문자와 같은 것이 Map에 포함되어 있다면
        // 해당 숫자를 뽑아내고 , 쌓아왔던 문자열을 초기화 한다.
        // numbers 양 옆에 " 떼어내기

        HashMap<String , Integer> numberMap = new HashMap<>();
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);

        String answer = "";
        String temp = "";
        for (int i = 0; i < numbers.length(); i++) {
            String nextWord = String.valueOf(numbers.charAt(i));
            temp = temp.concat(nextWord);

            if(temp.length() >= 3) {
                if (numberMap.containsKey(temp)){
                    answer = answer.concat(String.valueOf(numberMap.get(temp)));
                    temp = "";
                }
            } else { // 3보다 작으면 비교 안해도 된다.
                continue;
            }

        }
        Long ans = Long.parseLong(answer);

        return ans;
    }
}
