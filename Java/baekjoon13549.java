import java.util.*;
import java.io.*;

public class baekjoon13549 {
    static int[] maps = new int[100001];
    static int INF = Integer.MAX_VALUE;

    static int BFS(int start, int end) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        int[] visited = new int[100001];
        Arrays.fill(visited, INF);

        visited[start] = 0;
        queue.offer(start);

        int now = 0;
        int next = 0;
        int time = 0;
        int rs = 0;
        boolean flag = false;
        while(!queue.isEmpty()){
            flag = false;
            time = 0;
            now = queue.poll();
            
            if(now == end){
                rs = visited[end];
                break;
            }
            for(int i = 0; i < 3; i++){

                // 1 --> -1 하기
                // 2 --> +1 하기
                // 3 --> *2 하기(시간 변동 없음)
                if(i == 0){
                    next = now - 1;
                } else if (i == 1){
                    next = now + 1;
                } else if (i == 2){
                    next = now * 2;
                    flag = true;
                }

                if(0 <= next && next < 100001){
                    if(visited[next] > visited[now] ){
                        if(flag){
                            visited[next] = visited[now];
                        } else {
                            visited[next] = visited[now] + 1;
                        }
                        queue.offer(next);
                    }
                }

            }
        }

        return rs;
    }

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int rs = 0;
        rs = BFS(N, K);

        bw.write(String.valueOf(rs));

        bw.flush();
        bw.close();
        br.close();

        
        

    }
}
