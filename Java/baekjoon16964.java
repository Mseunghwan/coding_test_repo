import java.util.*;
import java.io.*;

public class baekjoon16964 {
    static ArrayList<Integer>[] graph;
    static int N; // 정점 개수
    static boolean visited[];
    static int[] rule;
    static ArrayList<Integer> dfs_rs;

    public static void DFS(int start){
        visited[start] = true;

        dfs_rs.add(start);
        for(int next : graph[start]) {
            if(visited[next] == false){
                DFS(next);
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        // 4
        // 1 2
        // 1 3
        // 2 4
        // 1 2 3 4

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }


        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        rule = new int[N + 1];
        st = new StringTokenizer(br.readLine()); // 이 순서 입력 받음
        for(int i = 1; i <= N; i++){
            rule[i] = Integer.parseInt(st.nextToken());
        }

        int[] priority = new int[N + 1];
        // 이 번호는 몇 번째 순서인지, 이걸 기준으로 정렬해줄 생각
        for(int i = 1 ; i <= N; i ++){
            priority[rule[i]] = i;
        }

        // 정렬
        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i], (nodeA, nodeB) -> {
                return priority[nodeA] - priority[nodeB]; // priority 우선 순서에 맞게 우선 정렬
            });
        }

        visited = new boolean[N + 1];
        dfs_rs = new ArrayList<>();
        dfs_rs.add(0);

        DFS(1);

        boolean is_correct = true;
        for(int i = 1; i <= N; i++){
            if(dfs_rs.get(i) != rule[i]){
                is_correct = false;
                break;
            }
        }

        if(is_correct){
            bw.write(String.valueOf(1));
        } else {
            bw.write(String.valueOf(0));
        }

        bw.flush();
        bw.close();
        br.close();

    }
    
}
