import java.util.*;
import java.io.*;

public class baekjoon14938 {
    static int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] items = new int[N + 1];
        
        int[][] dist = new int[N + 1][N + 1];
        for(int i = 0 ; i <= N; i++){
            Arrays.fill(dist[i], INF);
        }

        for(int i = 0 ; i <= N; i++){
            dist[i][i] = 0;
        }

        for(int i  = 1 ; i <= N; i ++){
            items[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[s][e] = Math.min(dist[s][e], w);
            dist[e][s] = Math.min(dist[e][s], w);
        }

        // 플로이드 워셜
        for(int k = 1; k <= N; k++){
            for(int a = 1; a <= N; a++){
                for(int b = 1; b <= N; b++){
                    if(dist[a][k] != INF && dist[k][b] != INF){
                    dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
                }
                }
            }
        }

        int rs = Integer.MIN_VALUE;

        for(int i = 1; i <= N; i++){
            int sum = items[i];    
            for(int j = 1; j <= N; j++){
                if(i != j){
                    if(dist[i][j] <= M){
                        sum += items[j];
                    }
                }
            }
            rs = Math.max(rs, sum);
        }

        bw.write(String.valueOf(rs));
        bw.flush();
        bw.close();
        br.close();



    }
}
