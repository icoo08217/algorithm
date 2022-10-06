import java.util.*;
import java.io.*;

class baek11652 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashMap<Long, Integer> card = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        while(N --> 0) {
            Long num = Long.parseLong(br.readLine());
            card.put(num, card.getOrDefault(num,0) + 1);
        }

        int max = 0;

        ArrayList<Integer> list = new ArrayList<>(card.values());
        for (Integer value : list) {
            if(max < value){
                max = value;
            }
        }

        PriorityQueue<Long> q = new PriorityQueue<>();
        // 밸류로 키 조회하기
        for(Long key :card.keySet()){
            if(max==card.get(key)){
                q.add(key);
            }
        }
        System.out.println(q.poll());
    }
}