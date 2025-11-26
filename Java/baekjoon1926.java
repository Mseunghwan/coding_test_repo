import java.io.*;
import java.util.*;

public class baekjoon1926 {
	
	static class Node{
		int y;
		int x;
		Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static int[][] maps;
	static int N;
	static int M;
	
	static int rs_cnt = 0;
	static int rs_max = 0;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static void BFS(int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(i, j));
		int is_max = 1;
		rs_cnt += 1;
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(is_max > rs_max) {
				rs_max = is_max;
			}
			
			int y = now.y;
			int x = now.x;
			
			for(int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(0 <= ny && ny < N && 0 <= nx && nx < M && visited[ny][nx] == false && maps[ny][nx] == 1) {
					visited[ny][nx] = true;
					is_max += 1;
					queue.offer(new Node(ny, nx));
				}
			
			}
			
		}
	}
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st; 
		
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maps = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		for(int i = 0 ; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(maps[i][j] == 1 && visited[i][j] == false) {
					BFS(i, j);
				}
			}
				
		}
		bw.write(String.valueOf(rs_cnt) + "\n");
		bw.write(String.valueOf(rs_max));
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
