import java.util.*;
import java.io.*;

public class baekjoon1941 {
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int rs = 0;
	static char[][] maps;
	static void BackTracking(boolean[][] visited, int y, int x, int cnt, int y_cnt) {
		
		if(cnt == 7) {
			if(y_cnt < 4) {
				rs += 1;
				return;
			}
		}
		if(7 - y_cnt < 4) {
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			int is_Y = 0;
			if(0 <= ny && ny < 5 && 0 <= nx && nx < 5 && visited[ny][nx] == false) {
				if(maps[ny][nx] == 'Y') {
					is_Y = 1;
				}
				visited[ny][nx] = true;
				BackTracking(visited, ny, nx, cnt + 1, y_cnt + is_Y);
				visited[ny][nx] = false;
				
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		maps = new char[5][5];
		
		for(int i = 0; i < 5; i++) {
			String line = br.readLine();
			for(int j = 0; j < 5; j++) {
				maps[i][j] = line.charAt(j);
			}
		}
		
		
		// 경로는 다음과 같은 룰을 포함해야 한다
		// 1. 7만큼의 길이를 갖는다(인접해 있어야 한다)
		// 2. 해당  경로에 Y가 하나도 없어선 안된다
		// 3. 다만 경로 내 Y가 4 미만이어야 한다 --> S가 4 이상이어야 한다
		
		// 접근법 : 모든 좌표를 순회하면 해당 좌표에서 깊이 우선 탐색을 진행한다
		// 탐색 중 위 경로 조건을 맞추지 못한다면 백트래킹으로 바로 break
		// 시간 터질거같은데 백트래킹으로 한번 조져봐야겠다.
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				int y = 0;
				boolean[][] visited = new boolean[5][5];
				visited[i][j] = true;
				if(maps[i][j] == 'Y') {
					y = 1;
				}
				BackTracking(visited, i, j, 1, y);
			}
		}
		
		bw.write(String.valueOf(rs));
		bw.flush();
		bw.close();
		br.close();
		
		
		// 소문난 칠공주
		
		
	}
}
