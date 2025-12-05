import java.util.*;
import java.io.*;

public class baekjoon1941 {

	static int rs = 0;

	static char[][] maps;

	// 어느 자리의 사람을 뽑았는지 기록 - BFS 순회해야 할 조합
	static int[] pick = new int[7];

	// 이다솜 파가 최소 4명 이상이어야 하니,
	static void BackTracking(int cnt, int lim_cnt, int start){
		
		// 만약 남은 경우를 다 해도 이다솜파 4명을 채울 수 없으면 return
		// 즉 임도연파 인원이 4 이상이라면
		if(lim_cnt >= 4){
			return;
		}

		if(cnt == 7){
			if(BFS()){
				rs += 1;
			}

			return;
		}

		for(int i = start ; i < 25; i++){
			int y = i / 5;
			int x = i % 5;

			pick[cnt] = i;
			if(maps[y][x] == 'Y'){
				BackTracking(cnt + 1, lim_cnt + 1, i + 1);
			}
			else if(maps[y][x] == 'S'){
				BackTracking(cnt + 1, lim_cnt, i + 1);
			}
					
		}

	}

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	static boolean BFS(){

		Queue<Integer> queue = new LinkedList<>();

		boolean[][] visited = new boolean[5][5];

		// 지금 뽑은 pick을 지도로 그려주기(아래 while - if 문 내에서 찾기 편하게 하기 위함)
		boolean[][] my_member = new boolean[5][5];
		for(int idx : pick){
			my_member[idx/5][idx%5] = true;
		}
		
		queue.add(pick[0]);
		visited[pick[0] / 5][pick[0] % 5] = true;

		// 카운트 시작(몇 명이 통과했는지, 모두 통과하면 패스한 것)
		int cnt = 1;

		while(!queue.isEmpty()){
			int now = queue.poll();

			int y = now / 5;
			int x = now % 5;

			for(int i = 0; i < 4; i++){
				int ny = y + dy[i];
				int nx = x + dx[i];

				if(0 <= ny && ny < 5 && 0 <= nx && nx < 5 && visited[ny][nx] == false){
					if(my_member[ny][nx]){
						visited[ny][nx] = true;
						queue.add((ny * 5) + nx);
						cnt += 1;
					}
				}

			}
		}
		// 다 돌았을 떄, 7명을 다 돌았으면 통과한 것.
		return cnt == 7;
	
	}

	public static void main(String args[]) throws IOException{

		// 칠공주 문제
		// BackTracking으로 7명의 조합을 뽑고, 그 조합이 붙어있는지 BFS로 확인하기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		maps = new char[5][5];

		for(int i = 0; i < 5; i++){
			String line = br.readLine();
			for(int j = 0; j < 5; j++){
				maps[i][j] = line.charAt(j);
			}
		}

		BackTracking(0, 0, 0);

		bw.write(String.valueOf(rs));
		

		bw.flush();
		bw.close();
		br.close();

	}

}
