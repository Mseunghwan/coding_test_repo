import java.util.*;
import java.io.*;

public class baekjoon2636 {
    static int N;
    static int M;

    static int[][] maps;
    static boolean visited[][];

    static class Node{
        int y;
        int x;

        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    // 공기 채우기
    static void Air_BFS(int a, int b){
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(a, b));
        visited[a][b] = true;
        maps[a][b] = -1;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();

            int y = now.y;
            int x = now.x;

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M && visited[ny][nx] == false && maps[ny][nx] == 0){
                    maps[ny][nx] = -1;
                    visited[ny][nx] = true;
                    queue.offer(new Node(ny, nx));
                }
            }

        }
    }


    static boolean flag = true;
    static int cnt_before = 0;
    static int cnt = 0;

    static void turn_BFS(){

        int temp_cnt = 0;
        ArrayList<Node> remove_list = new ArrayList<>();
        

        // 공기 채울데가 있는지 체크
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(maps[i][j] == -1){
                    for(int k = 0; k < 4; k ++){
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(0 <= ny && ny < N && 0 <= nx && nx < M && visited[ny][nx] == false){
                            if(maps[ny][nx] == 0){
                                Air_BFS(ny, nx);
                            }
                        }     
                    }
                }
            }
        }

        // -1이면 주변 0 부분 채우기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(maps[i][j] == -1){
                    for(int k = 0; k < 4; k ++){
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(0 <= ny && ny < N && 0 <= nx && nx < M && visited[ny][nx] == false){
                            if (maps[ny][nx] == 1){
                                temp_cnt += 1;
                                remove_list.add(new Node(ny, nx));
                            }

                            visited[ny][nx] = true;
                        }     
                    }
                }
            }
        }
        if(temp_cnt > 0){
            cnt += 1;
            cnt_before = temp_cnt;
            flag = true;

        for(Node remove : remove_list){
            maps[remove.y][remove.x] = -1;
        }
        } else {
            flag = false;
        }


    }

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int [N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 치즈 문제
        // 1. 상, 하, 좌, 우에서의 바깥쪽 공기층들을 색칠한다(A로)
        // 2. 해당 공기층에서 상하좌우를 A로 한번 채우는 걸 1턴으로 생각한다.
        
        // 먼저, 상, 하, 좌, 우의 바깥쪽만 골라 돌아야 하기에
        // 아래와 같이, 색칠

        // 근데 이렇게 풀지 말고, 그냥 치즈를 세고
        // 치즈 상하좌우에 0이 있으면 한 턴에 하나씩 줄어드는 방식으로 가자,

        visited = new boolean[N][M];

        for(int i = 0 ; i < M; i++){
            // 위
            if(maps[0][i] == 0 && visited[0][i] == false && maps[0][i] == 0){
                Air_BFS(0, i);
            }
            // 아래
            if(maps[N-1][i] == 0 && visited[N - 1][i] == false && maps[N - 1][i] == 0){
                Air_BFS(N - 1, i);
            }
        }

        for(int i = 0 ; i < N; i++){
            // 좌측
            if(maps[i][0] == 0 && visited[i][0] == false && maps[i][0] == 0){
                Air_BFS(i, 0);
            }

            // 우측
            if(maps[i][M - 1] == 0 && visited[i][M - 1] == false && maps[i][M - 1] == 0){
                Air_BFS(i, M - 1);
            }
        }

        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < M; j++){
        //         bw.write(maps[i][j] + " ");
        //     }   
        //     bw.write("\n");
        // }

        while(flag){
            turn_BFS();
        }
        bw.write(String.valueOf(cnt) + "\n");
        bw.write(String.valueOf(cnt_before));


        bw.flush();
        bw.close();
        br.close();
    }
}
