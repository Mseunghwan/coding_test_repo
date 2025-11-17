import java.util.*;
import java.io.*;

public class baekjoon14938 {
    static int INF = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        // 플로이드 워셜로, 비용 맵 만들고
        // 비용이 수색범위 내라면 아이템을 sum에 += 해주는 방식으로 

        st = new StringTokenizer(br.readLine());
        
        // 지역 개수
        int N = Integer.parseInt(st.nextToken());
        
        // 수색범위
        int M = Integer.parseInt(st.nextToken());

        // 길 개수
        int R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 각 지역이 보유한 아이템의 수
        int[] local_item = new int[N + 1];
        local_item[0] = 0;
        // 각 아이템의 수 초기화
        for(int i = 1; i <= N; i++){
            int val = Integer.parseInt(st.nextToken());
            local_item[i] = val;
        }

        // 비용 맵
        int[][] graph = new int[N + 1][N + 1];

        // INF 로 채우기
        for(int i = 0; i <= N; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i = 0; i <= N; i++){
            graph[i][i] = 0;
        }

        // 자기 자신은 0으로

        // 비용 맵 입력
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph[a][b] = l;
            graph[b][a] = l;
        }

        // floyd warshall
        for(int k = 1; k <= N; k++){
            for(int a = 1; a <= N; a++){
                for(int b = 1; b <= N; b++){
                    if(graph[a][k] != INF && graph[k][b] != INF){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
                }
            }
        }

        // for(int i = 1; i <= N; i++){
        //     for(int j = 1; j <= N; j++){
        //         bw.write(String.valueOf(graph[i][j]) + " ");
        //     }
        //     bw.write("\n");
        // }

        int max_sum = 0;

        int sum;
        for(int i = 1; i <= N; i++){
            sum = 0;
            for(int j = 1; j <= N; j++){
                if(graph[i][j] <= M){
                    sum += local_item[j];
                }
            }
            if(sum > max_sum){
                max_sum = sum;
            }
        }

        bw.write(String.valueOf(max_sum));

        bw.flush();
        bw.close();
        br.close();




    }   
}
