import java.util.*;
import java.io.*;


public class baekjoon1931 {

    static class Node implements Comparable<Node> {
        int start;
        int end;

        Node(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Node o){
            if(this.end == o.end){
                return this.start - o.start;
            }
            return this.end - o.end;

        }
        
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(start, end);
        }

        // for(Node now : nodes){
        //     bw.write(String.valueOf(now.start) + " " + String.valueOf(now.end) + "\n");
        // }
        Arrays.sort(nodes);
        int cnt = 1;
        int now_end = nodes[0].end;
        for(int i = 1 ; i < N; i ++){
            if(nodes[i].start >= now_end){
                now_end = nodes[i].end;
                cnt += 1;
            }

        }

        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
        br.close();

        




    }
}
