import java.util.*;
import java.io.*;

public class problem2589 {

    static class Point {
        int y;
        int x;
        int dist; // 시작 점 으로 부터의 거리

        Point(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    static int N;
    static int M;
    static char[][] maps;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int BFS(int start_y, int start_x){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start_y, start_x, 0));

        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            Arrays.fill(visited[i], false);
        }

        visited[start_y][start_x] = true;

        int max_one = 0;
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int dist = cur.dist;

            if(dist > max_one){
                max_one = dist;
            }

            for(int i = 0; i < 4; i ++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(0 <= ny & ny < N && 0 <= nx && nx < M){
                    if(visited[ny][nx] || maps[ny][nx] == 'W'){
                        continue;
                    }
                    visited[ny][nx] = true;
                    queue.add(new Point(ny, nx, dist + 1));
                }
            }

        }
        return max_one;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//                5 7
//                WLLWWWL
//                LLLWLLL
//                LWLWLWW
//                LWLWLLL
//                WLLWLWW
//                제일 오래 걸리는 곳을 찾아야 하니,
//                L 위치에서 BFS를 돌리고, 가장 많이 차이나는 값을 저장해서 리턴


        maps = new char[N][M];

        int rs = 0;
        int is_max = 0;
        for(int i = 0; i < N; i ++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                char val = line.charAt(j);
                maps[i][j] = val;
            }
        }

        for(int i = 0; i < N; i ++){
            for(int j = 0; j < M; j++){
                if(maps[i][j] == 'L') {
//                    여기서 BFS 호출
                    is_max = BFS(i, j);
                    if(is_max > rs){
                        rs = is_max;
                    }
                }
            }
        }


        bw.write(Integer.toString(rs));
        bw.flush();
        bw.close();
        br.close();


    }
}
