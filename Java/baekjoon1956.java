import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1956 {
    public static int INF = Integer.MAX_VALUE; 
    
    
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());

        int[][] graph = new int[V + 1][V + 1];

        for(int i = 0; i <= V; i++){
            Arrays.fill(graph[i], INF);
        }

        int E = Integer.parseInt(st.nextToken());

        
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
        }

        for(int k = 1; k <= V; k++){
            for(int a = 1; a <= V; a++){
                for(int b = 1; b <= V; b++){
                    if(graph[a][k] != INF && graph[k][b] != INF){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                    }
                } 
            }
        }
 
        
        int rs = INF;
        // graph[i][i] --> 자기 자신에게 오는 경우가 사이클 weight를 의미하는 것이므로
        for(int i = 1; i <= V; i++) {
        	if(graph[i][i] < rs) {
        		rs = graph[i][i];
        	}
        }
        if(rs == INF) {
        	bw.write(String.valueOf(-1));
        }
        else {
        bw.write(String.valueOf(rs));
        }        
        
        
        bw.flush();
        bw.close();
        br.close();
    }
}