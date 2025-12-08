import java.io.*;
import java.util.*;

public class baekjoon1520 {
    static int N;
    static int M;
    static int[][] maps;

    static public class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = { 0, -1, 0, 1 };
    static int[] dx = { 1, 0, -1, 0 };

    // 보고를 합치는 과정
    // 내 쪽에서 다른 DFS를 계속 호출 하면서, 거기 몇개냐 ? 거기 몇개냐 ? 물어가는거
    // 그래서 도착지를 찾은 DFS가 자신이 찾았다는 의미로 1을 리턴하면
    // 그 위는 내 길이 도착지로 가는 경로구나 하고 자신의 경로에 리턴값 + 1
    // 이런식으로 다른 경로로 같 애들도 만약 답을 찾으면 자신을 호출해준 DFS에 1을 계속 반환하면서
    // 가장 최종 시작점인 0, 0은 여러 갈래로 나뉘어진 DFS 들에게서 온 값을 취할 수 있는 것
    public static int DFS(int y, int x, int[][] dp) {

        // 도착지라면
        if (y == N - 1 && x == M - 1) {
            // 1 높여주기
            return 1;
        }

        // 이미 와 본 곳이라면
        if(dp[y][x] != -1){
            return dp[y][x];
        }

        // 처음 온다면
        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                if (maps[ny][nx] < maps[y][x]) {
                    // DFS가 바닥까지 가서 알아온 경로를 반환
                    dp[y][x] = dp[y][x] + DFS(ny, nx, dp);
                }
            }
        }

        return dp[y][x];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        // 내리막 길 문제
        // BFS로 문제 해결, maps[ny][nx] 가 maps[y][x] 보다 작은 경우에만 가도록하면 되지 않을까
        // 하려 했으나,, visited 중복 되면 안되기에 DFS로 했음
        // 근데 시간초과가 남, --> 중복 경로로 가는걸 계속 다시 계산하기 때문에
        // DP, 가본 길 갯수 저장하는 맵으로 계산
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][M];
        for(int i =  0 ; i < N; i ++){
            Arrays.fill(dp[i], -1);
        }

        
        int rs = DFS(0, 0, dp);

        bw.write(String.valueOf(rs));
        bw.flush();
        bw.close();
        br.close();

    }
}
