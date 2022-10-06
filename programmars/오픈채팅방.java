package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 오픈채팅방 {
    public static void main(String[] args) {

    }
}

class Solution_오픈채팅방 {
    public String[] solution(String[] record) {
        HashMap<String, String> id = new HashMap<>();
        List<String> userInOut = new ArrayList<>();

        for (String command : record) {
            String[] commandInfo = command.split(" ");
            if (commandInfo[0].equals("Enter")){ // 입장 : 1. 새로운 멤버
                                                        // 2. 닉네임을 변경하고 들어옴
                userInOut.add(commandInfo[1] + "Enter");
                id.put(commandInfo[1] , commandInfo[2]);
            } else if (commandInfo[0].equals("Leave")) { // 퇴장
                userInOut.add(commandInfo[1] + "Leave");
            } else { // 변경
                id.put(commandInfo[1] , commandInfo[2]);
            }
        }


        String[] answer = new String[userInOut.size()];

        for (int i = 0; i < userInOut.size(); i++) {
            if (userInOut.get(i).contains("Enter")) {
                answer[i] = id.get(userInOut.get(i).replaceAll("Enter" , "")) + "님이 들어왔습니다.";
            } else {
                answer[i] = id.get(userInOut.get(i).replaceAll("Leave" , "")) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
// 모든 유저는 [유저 아이디]로 구분한다.
//[유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - "Enter [유저 아이디] [닉네임]"
// 퇴장 "Leave [유저 아이디]"
// 변경 "Change [유저아이디] [닉네임]"
// 첫 단어 Enter , Leave , Change

// record 입력의 예 : ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
// result 출력의 예 : ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]