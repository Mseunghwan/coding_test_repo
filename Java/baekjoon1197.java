import java.util.*;
import java.io.*;

public class baekjoon1197{

    static class Node implements Comparable<Node> {
        int v;
        int w;

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }

    public static void main(String args[]) throws IOException{
        // 최소 스패닝 트리 --> 프림 알고리즘
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for(int i = 0 ; i <= V; i++){
            graph.add(new ArrayList<>());
        }

        int E = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Node(v2, w));
            graph.get(v2).add(new Node(v1, w));
        }


        boolean[] visited = new boolean[V + 1];
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        int rs = 0;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            int v = now.v;
            int w = now.w;
            if(visited[v]){
                continue;
            }
            visited[v] = true;
            rs += w;

            for(Node next : graph.get(v)){
                if(!visited[next.v]){
                queue.add(next);
                }
            }

        }

        bw.write(String.valueOf(rs));
        bw.flush();
        bw.close();
        br.close();



        
    }
}
