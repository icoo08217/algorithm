package programmers;

import java.util.HashMap;

public class 성격유형검사 {
    public static void main(String[] args) {
        Solution_MBTI solution = new Solution_MBTI();
//        String[] survey = new String[] {"AN", "CF", "MJ", "RT", "NA"};
        String[] survey = new String[] {"TR", "RT", "TR"};
//        int[] choices = new int[]{5, 3, 2, 7, 5};
        int[] choices = new int[]{7,1,3};

        System.out.println(solution.solution(survey , choices));

    }
}

class Solution_MBTI {
    public String solution(String[] survey, int[] choices) {

        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        String[][] type = new String[][]{{"R" , "T"} , {"C" , "F"} , {"J" , "M"} , {"A" , "N"}};

        // 맵에 데이터 저장했음 ( R , 0 )  , ( T , 0 ) 이런 형태로
        for (String[] str : type) {
            map.put(str[0], 0);
            map.put(str[1], 0);
        }

        // 맵에 실제 데이터를 저장해야함.
        for (int i = 0; i < choices.length; i++) {
            String minusCategory = survey[i].split("")[0];
            String plusCategory = survey[i].split("")[1];

            switch (choices[i]) {
                case 1:
                    map.put(minusCategory, map.get(minusCategory) + 3);
                    break;
                case 2:
                    map.put(minusCategory, map.get(minusCategory) + 2);
                    break;
                case 3:
                    map.put(minusCategory, map.get(minusCategory) + 1);
                    break;
                case 4: // 어떤 성격 유형도 점수를 얻지 못함.
                    break;
                case 5:
                    map.put(plusCategory, map.get(plusCategory) + 1);
                    break;
                case 6:
                    map.put(plusCategory, map.get(plusCategory) + 2);
                    break;
                case 7:
                    map.put(plusCategory, map.get(plusCategory) + 3);
                    break;
            }
        }

        for (int i = 0; i < type.length; i++) {
            // 둘중 더 높은 점수의 유형을 answer에 붙이면 됨
            answer += scoreCategory(map , type[i][0] , type[i][1]);
        }

        return answer;
    }

    public static String scoreCategory(HashMap<String , Integer> map , String type1 , String type2){
        String result = "";
        if (map.get(type1) > map.get(type2)) {
            result+= type1;
        } else if (map.get(type1) < map.get(type2)) {
            result += type2;
        } else { // 점수가 같은 경우
            if (type1.charAt(0) < type2.charAt(0)) {
                result += type1;
            } else {
                result += type2;
            }
        }

        return result;
    }
}
