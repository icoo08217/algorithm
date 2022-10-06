import java.util.*;
import java.io.*;


class baek7785{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        int n = Integer.parseInt(br.readLine()); // 로그의 수

        HashSet<String> set = new HashSet<>(); //

        for (int i=0; i < n; i++){
            str = new StringTokenizer(br.readLine());
            String name = str.nextToken();
            String log = str.nextToken();

            if (log.equals("enter")){
                set.add(name);
            }

            if (log.equals("leave")){
                if (set.contains(name)){
                    set.remove(name);
                }
            }
        }

        // 사전 순 역순으로 정렬 후 출력
        List<String> list = new ArrayList<>();
        for (String s : set) {
            list.add(s);
        }

        Collections.sort(list, Collections.reverseOrder());

        for (String s : list) {
            System.out.println(s);
        }
    }
}