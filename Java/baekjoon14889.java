import java.io.*;
import java.util.*;

public class baekjoon14889 {
    static int N;
    static int[][] maps;
    static int min_rs = Integer.MAX_VALUE;

    static boolean[] visited;
    static void BackTracking(int depth, int start){
        if(depth == N / 2){
            int start_team = 0;
            int link_team = 0;
            
            for(int i = 0 ; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    if(visited[i] == false && visited[j] == false){
                        link_team += maps[i][j] + maps[j][i];
                    }
                    else if(visited[i] && visited[j]){
                        start_team += maps[i][j] + maps[j][i];
                    }
                }
            }
            int diff = Math.abs(start_team - link_team);
            min_rs = Math.min(min_rs, diff);
            
        }

        for(int i = start; i < N; i++){
            if(visited[i] == false){
                visited[i] = true;
                BackTracking(depth + 1, i);
                visited[i] = false;

            }
        }

    }

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        maps = new int[N][N];

        for(int i = 0 ; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];

        BackTracking(0, 0);

        bw.write(String.valueOf(min_rs));
        bw.flush();
        bw.close();
        br.close();


}

}
