import java.io.*;
import java.util.*;

public class baekjoon1916 {

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
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 도시 개수
        int N = Integer.parseInt(br.readLine());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for(int i = 0 ; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        // 버스 개수(경로)
        int M = Integer.parseInt(br.readLine());


        StringTokenizer st;     
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, w));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // dijkstra
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();

            int v = now.v;
            int w = now.w;
            

            if(w > dist[v]){
                continue;
            }

            for(Node next : graph.get(v)){
                int next_v = next.v;
                int next_w = next.w;

                if(dist[next_v] > dist[v] + next_w){
                    dist[next_v] = dist[v] + next_w;
                    queue.add(new Node(next_v, dist[next_v]));
                }
            }

        }


        System.out.println(dist[end]);
        br.close();
        


    }
    
}
