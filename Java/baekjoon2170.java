import java.io.*;
import java.util.*;


public class baekjoon2170 {
		public static void main(String args[]) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			// 선 길이 출력 문제 --> 겹치는 선이 몇 개 있는지 찾는 문제 
			// 입력 받고, 해당 입력 하나씩 뽑으면서 일차원 배열에 출발, 끝 까지 채워주고
			// 순회하면서 1 시작 ~ 1 끝, 1 시작 ~ 1 끝 세면서 
			// rs += (1끝 - 1 시작) 해주면 된다
			
			int n = Integer.parseInt(br.readLine());
			
			int[][] lines = new int[n][2];
			
			StringTokenizer st;
			
			int max_one = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				lines[i][0] = Integer.parseInt(st.nextToken());
				lines[i][1] = Integer.parseInt(st.nextToken());
				if(lines[i][1] > max_one) {
					max_one = lines[i][1];			
					}
			}
			
			Arrays.sort(lines, (a, b) -> {
				return Integer.compare(a[0], b[0]);
			});
			
			long rs = 0;
			int min = lines[0][0];
			int max = lines[0][1];
			for(int i = 1; i < n; i++) {
				if(lines[i][0] < max) {
					if (lines[i][1] >= max){
						max = lines[i][1];
					}
				} else { 
					rs += (max - min);
					min = lines[i][0];
					max = lines[i][1];
				}
			}
			rs += (max - min);
			
			System.out.println(rs);
			
			
//			System.out.println(Arrays.deepToString(lines));
			
			// 스윕 방식?
//			모든 선을 시작점(lines[i][0]) 기준으로 오름차순 정렬합니다.
//			첫 번째 선을 '기준 선'(min, max)으로 잡습니다.
//			두 번째 선부터 순회하면서 '기준 선'과 겹치는지 확인합니다.
//			겹치는 경우 '기준 선'의 끝점을 더 먼 값으로 확장합니다.
//			'기준 선'이 끝났으므로, 길이를 (max - min) 만큼 rs에 더합니다. 
//			그리고 '기준 선'을 이 '새 선'으로 교체합니다.
//			루프가 끝나면, 마지막 '기준 선'의 길이를 rs에 더해줍니다.
//			
			// 메모리 터질 수 밖에 없는 1차원 배열 뿌리기 방식
//			int[] result = new int[max_one + 1];
//			
//			for(int i = 0; i < n; i++) {
//				for(int j = lines[i][0]; j < lines[i][1]; j++){
//					result[j] = 1;
//				}
//			}
//			int rs = 0;
//			
//			
////			System.out.println(Arrays.toString(result));\
//			// result 순회
//			for(int i = 1; i <= max_one; i++) {
//				if(result[i] == 1) {
//					int s = i;
//					int e = 0;
//					for(int j = i; j <= max_one; j++) {
//						e = j;
//						if(result[j] == 0) {
//							break;
//						}
//					}
//					i = e;
//					rs += e - s;
//				}
//			}
//			System.out.println(rs);
			
		}
}

