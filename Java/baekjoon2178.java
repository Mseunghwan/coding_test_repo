import java.util.*;
import java.io.*;

public class baekjoon2178 {
    static int N;
    static int M;

    static int[][] maps;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Node{
        int y;
        int x;
        int cnt;

        Node(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    static int BFS(){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            int y = now.y;
            int x = now.x;
            int cnt = now.cnt;

            if(y == N - 1 && x == M - 1){
                return cnt;
            }

            for(int i = 0 ; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M && visited[ny][nx] == false){
                    if(maps[ny][nx] == 1){
                        visited[ny][nx] = true;
                        queue.add(new Node(ny, nx, cnt + 1));
                    }
                }
            }
        }

        return -1;

    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()) ;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];


        for (int i = 0 ; i < N; i++){
            String line = br.readLine();
            for(int j = 0 ; j < M; j++){
                maps[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        
        int rs = BFS();

        bw.write(String.valueOf(rs));
        bw.flush();
        bw.close();
        br.close();





    }

}
