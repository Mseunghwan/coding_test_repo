import java.io.*;
import java.util.*;

public class baekjoon24479 {
    static int N; // 정점 수
    static int M; // 간선 수
    static int R; // 시작 정점
    
    static BufferedReader br;
    static BufferedWriter bw;
    static ArrayList<Integer>[] graph;

    static int[] visited;
    static int cnt = 1;

    public static void DFS(int start){
        visited[start] = cnt;
        cnt++;
        for(int next : graph[start]){
            if(visited[next] == 0){
                DFS(next);
            }
        }
    }

    
    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);   
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }
        visited = new int[N + 1];
        Arrays.fill(visited, 0);

        DFS(R);
        for(int i = 1; i <= N; i++){
            bw.write(String.valueOf(visited[i] + "\n"));
        }
        bw.flush();
        bw.close();
        br.close();

    }    

    // 5 5 1
    // 1 4
    // 1 2
    // 2 3
    // 2 4
    // 3 4

}
