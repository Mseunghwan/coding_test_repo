import java.util.*;
import java.io.*;

public class baekjoon1697 {

    static class Node{
        int x;
        int cnt;

        Node(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }

    static int N;
    static int K;

    static int BFS(){

        boolean[] visited = new boolean[100001];
        Queue<Node> queue = new LinkedList<>(); 

        visited[N] = true;
        queue.add(new Node(N, 0));

        while(!queue.isEmpty()){

            Node now = queue.poll();
            int x = now.x;
            int cnt = now.cnt;

            if(x == K){
                return cnt;
            }
    
            for(int i = 0 ; i < 3; i ++){
                int val = x;
                if(i == 0){
                    val = x + 1;
                }
                else if (i == 1){
                    val = x - 1;
                } 
                else if (i == 2){
                    val = x * 2;
                }
    
                if(0 <= val && val < 100001 && visited[val] == false){
                    visited[val] = true;
                    queue.add(new Node(val, cnt + 1));
            }

        }

    }
    return 0;
}

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        int val = BFS();

        bw.write(String.valueOf(val));
        bw.flush();
        bw.close();
        br.close();

    }
}
