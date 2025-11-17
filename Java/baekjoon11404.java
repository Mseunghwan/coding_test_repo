import java.util.*;
import java.io.*;

public class baekjoon11404 {
    static int INF = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        // 모든 도시의 쌍에 대해 경로 상 최솟값 구하는 문제
        // n이 2 <= n <= 100
        // 플로이드 워셜 사용 O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        // 도시의 개수
        int N = Integer.parseInt(br.readLine()); 

        // 도시 수 만큼 2차원 배열 선언
        int[][] graph = new int[N + 1][N + 1];
        for(int i = 0; i <= N; i++){
            Arrays.fill(graph[i], INF);
        }
        // 자기가 자기로 가는 경로는 비용 0으로 초기화
        for(int i = 0; i <= N; i++){
            graph[i][i] = 0;
        }

        // 버스의 개수(경로의 개수)
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            if(graph[first][second] > weight){
               graph[first][second] = weight;
        }

        }

        // 플로이드 워셜 수행, 점화식 :  Dab = min(Dab, Dak + Dkb)
        for(int k = 1; k <= N; k++){
            for(int a = 1; a <= N; a++){
                for(int b = 1; b <= N; b++){
                    if(graph[a][k] != INF && graph[k][b] != INF){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(graph[i][j] == INF){
                    bw.write(String.valueOf(0) + " ");    
                }
                else
                 {
                    bw.write(String.valueOf(graph[i][j]) + " ");
                }
            }
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }
    
}
