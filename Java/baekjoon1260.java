import java.util.*;

import javax.sound.sampled.Line;

import java.io.*;

public class baekjoon1260 {
    static int N;
    static int M;
    static int V;

    static ArrayList<ArrayList<Integer>> maps;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void DFS(int start, boolean[] visited) throws IOException {
        bw.write(String.valueOf(start) + " ");
        for(int next : maps.get(start)){
            if(visited[next] == false){
                visited[next] = true;
                DFS(next, visited);
            }
        }
    }

    static void BFS(boolean[] visited) throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        while(!queue.isEmpty()){
            int now = queue.poll();
            bw.write(String.valueOf(now) + " ");

            for(int next : maps.get(now)){
                if(visited[next] == false){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        maps = new ArrayList<>();

        for(int i = 0 ; i <= N; i++){
            maps.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            maps.get(v1).add(v2);
            maps.get(v2).add(v1);
        }
        for(int i = 0 ; i <= N; i++){
            maps.get(i).sort(null);
        }
    
        boolean[] visited = new boolean[N + 1];
        visited[V] = true;
        DFS(V, visited);

        bw.write("\n");

        visited = new boolean[N + 1];
        visited[V] = true;
        BFS(visited);

        bw.flush();
        bw.close();
        br.close();


    }
}
