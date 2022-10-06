package programmers;

public class 완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {
        String FailName = null;
        for (String finishedRunner : completion) {
            for (int i = 0; i < participant.length; i++) {
                if (finishedRunner.equals(participant[i])) {
                    participant[i] = "FINISHED";
                }
            }
        }
        for (String player : participant) {
            if (!player.equals("FINISHED")) {
                FailName = player;
            }
        }
        String answer = ("\"" + FailName +"\"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.");
        return answer;
    }

}
