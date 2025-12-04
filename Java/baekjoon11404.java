import java.util.*;
import java.io.*;

public class baekjoon11404{

    static int INF = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st; 

        // 도시 개수
        int N = Integer.parseInt(br.readLine());

        int[][] dist = new int[N + 1][N + 1];

        for(int i = 0 ; i <= N; i++){
            Arrays.fill(dist[i], INF);
        }
        for(int i = 0; i <= N; i++){
            dist[i][i] = 0;
        }
        // 버스 개수
        int M = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            // 동일한 경로가 여러 개 일수 있기에
            dist[s][e] = Math.min(dist[s][e], w);
        }

        // 플로이드 워셜로 풀기
        for(int k = 1; k <= N; k++){
            for(int a = 1; a <= N; a ++){
                for(int b = 1; b <= N; b ++){
                    if(dist[a][k] != INF && dist[k][b] != INF){
                    dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
                }
                }
            }
        }

        for(int i = 1 ; i <= N; i ++){
            for(int j = 1 ; j <= N; j++){
                if(dist[i][j] == INF){
                    bw.write(String.valueOf(0) + " ");    
                    continue;
                }

                bw.write(String.valueOf(dist[i][j]) + " ");
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }

}