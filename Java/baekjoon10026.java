import java.util.*;
import java.io.*;

public class baekjoon10026 {
	static class Node{
		int y;
		int x;
		Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static int N;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static void BFS(char[][] maps, boolean[][] visited, int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(i, j));
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			int y = now.y;
			int x = now.x;
			
			for(int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(0 <= ny && ny < N && 0 <= nx && nx < N && maps[ny][nx] == maps[y][x] && visited[ny][nx] == false) {
					visited[ny][nx] = true;
					queue.offer(new Node(ny, nx));
				}
			}
			
		}
	}
	
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		char[][] maps = new char[N][N];
		char[][] handi_maps = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		boolean[][] handi_visited = new boolean[N][N];
		
		for(int i = 0; i < N; i ++) {
			Arrays.fill(visited[i], false);
			Arrays.fill(handi_visited[i], false);
		}
		
		for(int i = 0 ; i < N; i++) {
			
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				char now_one = line.charAt(j);
				if(now_one == 'G') {
					// ³ì»ö º¸´Â ³ðÀº °Á »¡°£°É·Î ¤¡¤¡
					handi_maps[i][j] = 'R';
				} else {
					handi_maps[i][j] = now_one;	
				}
				// ¾ë ÀÏ¹ÝÀÎÀÌ´Ï °Á ³Ö¾îÁÖ°í
				maps[i][j] = now_one;
				
			}
		}
		
		int rs_cnt = 0;
		int handi_cnt = 0;
		for(int i = 0 ; i < N; i ++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == false) {
					BFS(maps, visited, i, j);
					rs_cnt += 1;
				}
				if(handi_visited[i][j] == false) {
					BFS(handi_maps, handi_visited, i, j);
					handi_cnt += 1;
				}
			}
		}
		
		bw.write(String.valueOf(rs_cnt) + " " + String.valueOf(handi_cnt));
		bw.flush();
		bw.close();
		br.close();
		
	}
}
