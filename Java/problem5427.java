import java.util.*;
import java.io.*;

public class problem5427 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int cases = Integer.parseInt(br.readLine());

        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        for(int c = 0; c < cases; c++){


            //        1
            //        4 3
            //        ####
            //        #*@.
            //        ####
//            '.': 빈 공간
//            '#': 벽
//            '@': 상근이의 시작 위치
//            '*': 불
            // BFS로 풀자!
            // 우선, 불이 어느 시간대에 번졌는지 기록 하는 BFS를 먼저 순회하고(f_time),
            // 그 다음 상근이가 가는 BFS를 시작(s_time).
            // 만약 상근이가 도착한 지점에서의 불 도착 시간과 상근이의 시간을 비교해서
            // 상근이가 더 빠르면 이동 가능.

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            char[][] maps = new char[N][M];

            // 맵 만들기
            for(int i = 0; i < N; i ++){
                String line = br.readLine();
                for(int j = 0; j < M; j++) {
                    maps[i][j] = line.charAt(j);
                }
            }

            // 불, 상근 시간 초기화
            int[][] f_time = new int[N][M];
            int[][] s_time = new int[N][M];
            for(int i = 0; i < N; i++){
                Arrays.fill(f_time[i], INF);
                Arrays.fill(s_time[i], INF);
            }


            Queue<int[]> f_queue = new LinkedList<>();
            // 불 스타트 지점 구하기
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(maps[i][j] == '*'){
                        f_queue.add(new int[]{i, j});
                        f_time[i][j] = 0;
                    }
                }
            }

            // 불 시간 bfs
            while(!f_queue.isEmpty()){
                int[] cur = f_queue.poll();
                int y = cur[0];
                int x = cur[1];

                for(int i = 0; i < 4; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(0 <= ny && ny < N && 0 <= nx && nx < M){
                        if(maps[ny][nx] == '.' && f_time[ny][nx] == INF){
                            f_time[ny][nx] = f_time[y][x] + 1;
                            f_queue.add(new int[]{ny, nx});
                        }
                    }
                }
            }

            int s_y = 0;
            int s_x = 0;
            // 상근이 위치 구하기
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(maps[i][j] == '@'){
                        s_y = i;
                        s_x = j;
                    }
                }
            }
            Queue<int[]> s_queue = new LinkedList<>();
            s_queue.add(new int[]{s_y, s_x});
            s_time[s_y][s_x] = 0;

            int rs = INF;
            while(!s_queue.isEmpty()){
                int[] cur = s_queue.poll();
                int y = cur[0];
                int x = cur[1];

                // 가장자리에 도착하면 다음 턴에 성공하므로(탈출 하는 ny, nx까지 못가므로 세운 종료조건)
                if(y == 0 || y == N - 1 || x == 0 || x == M - 1){
                    rs = s_time[y][x] + 1;
                    break;
                }

                for(int i = 0; i < 4; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(0 <= ny && ny < N && 0 <= nx && nx < M){
                        if(maps[ny][nx] == '.' && s_time[ny][nx] == INF && (s_time[y][x] + 1 < f_time[ny][nx])){
                            s_time[ny][nx] = s_time[y][x] + 1;
                            s_queue.add(new int[]{ny, nx});
                        }
                    }
                }
            }

            if(rs == INF){
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(String.valueOf(rs) + "\n");
            }
            }
        bw.flush();
        bw.close();
        br.close();

    }

}
