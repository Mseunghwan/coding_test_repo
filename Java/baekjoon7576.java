import java.io.*;
import java.util.*;

public class baekjoon7576 {
    static int N;
    static int M;
    static int[][] maps;
    static Queue<Node> queue;
    
    static class Node{
        int y;
        int x;

        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};


    public static void BFS(){

        while(!queue.isEmpty()){
            Node now = queue.poll();

            int y = now.y;
            int x = now.x;

            for(int i = 0 ; i< 4 ;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M && maps[ny][nx] == 0){
                    maps[ny][nx] = maps[y][x] + 1;
                    queue.add(new Node(ny, nx));
                }
            }

        }
        

    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        // 토마토 위치 시작점
        queue = new LinkedList<>();

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                int value = Integer.parseInt(st.nextToken());
                maps[i][j] = value;
                if(value == 1){
                    queue.add(new Node(i, j));
                }
            }
        }

        BFS();

        int rs = Integer.MIN_VALUE;

        boolean flag = false;
        for(int i = 0 ; i < N; i ++){
            for(int j = 0; j < M; j++){
                if(maps[i][j] - 1 > rs){
                    rs = maps[i][j] - 1;
                }
                if(maps[i][j] == 0){
                    rs = -1;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        bw.write(String.valueOf(rs));
        bw.flush();
        bw.close();
        br.close();

    }
}

