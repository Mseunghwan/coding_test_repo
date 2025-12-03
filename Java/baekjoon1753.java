import java.util.*;
import java.io.*;

public class baekjoon1753 {
    
    static class Node implements Comparable<Node>{
        int v;
        int w;

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        public int compareTo(Node o){
            return this.w - o.w;
        }

    }

    static int INF = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 다익스트라 문제

        int V = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for(int i = 0 ; i <= V; i++){
            graph.add(new ArrayList<>());
        }

        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()); // 시작 지점

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, w));
        }

        int[] dist = new int[V + 1];
        for(int i = 0 ; i <= V; i++){
            dist[i] = INF;
        }

        dist[K] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(K, 0));

        while(!queue.isEmpty()){
            Node now = queue.poll();
            int v = now.v;
            int w = now.w;

            if(w > dist[v]){
                continue;
            }

            for(Node next : graph.get(v)){
                if(dist[next.v] > dist[v] + next.w){
                    dist[next.v] = dist[v] + next.w;
                    queue.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        for(int i = 1 ; i <= V; i++){
            if(dist[i] == INF){
                bw.write("INF\n");
                continue;    
            }
            bw.write(String.valueOf(dist[i])+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
