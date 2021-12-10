import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //테스트케이스 개수
        int testCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // 테스트 개수만큼 반복
        for(int i=0; i<testCnt ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            //문서 개수 N 
            int N = Integer.parseInt(st.nextToken());
            // 내가 궁금한 문서의 현재 큐 위치 M
            int M = Integer.parseInt(st.nextToken());
            
            LinkedList<int[]> queue = new LinkedList<>();
            
            st = new StringTokenizer(br.readLine());
            
            // 큐에 차례대로 넣는다[index, 중요도]
            for(int j=0; j<N; j++){
                queue.offer(new int[] {j , Integer.parseInt(st.nextToken())});
            }
            
            int out_count=0;
            
            while(!queue.isEmpty()) { // 큐가 비어있으면 멈춤.
                
                int[] front = queue.poll(); //제일 앞에 있는 배열 꺼내오기
                boolean isMax = true;
                
                for(int j=0; j<queue.size(); j++){
                    if(front[1] < queue.get(j)[1]){ // 남아있는 큐의 우선순위와 뽑은 front와 비교
                        queue.offer(front); // 우선순위가 밀린다면 큐의 끝에 다시 삽입.
                        for(int k=0; k<j; k++){
                            queue.offer(queue.poll());
                        }
                        
                        isMax = false;
                        break;
                    }
                }
                
                if(isMax == false){
                    continue;
                }
                
                out_count++;
                if(front[0] == M){
                    break; // 테스트 케이스 종료 
                }
            }
            
            sb.append(out_count).append('\n');

        }
        System.out.println(sb);
    }
}