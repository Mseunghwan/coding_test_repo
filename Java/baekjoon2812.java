import java.util.*;
import java.io.*;

public class baekjoon2812 {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st; 
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
//		int[] number = new int[N];
//		
//		String line = br.readLine();
//		
//		for(int i = 0; i < N; i++) {
//			char val = line.charAt(i);
//			number[i] = Integer.parseInt(String.valueOf(val));
//		}
//		
		// First Try : 그리디 배열 반복
		// N 까지 두번의 반복 --> 2500억 번 연산으로, X 실패한 코드
		// number 앞에서 부터 k 만큼의 범위를 확인한다, 해당 범위에서 자기가 가장 크면 다음 위치로
		// 자기가 가장 크지 않다면 삭제한다. 삭제했으니 k -= 1 로 범위 하나 삭제 후 다음 칸으로
		// 이후, 삭제 자리 다음부터 또 K 만큼 범위를 확인한다.
		
		// 현재 위치
//		int now = 0;
//		boolean flag;
//		
//		ArrayList<Integer> delete_list = new ArrayList<>();
//		
//		while(K > 0 && now < N) {
//			flag = false;
//
//			for(int i = now + 1; i <= now + K; i++) {
//				
//				// 만약 범위에 나보다 큰게 하나라도 있다면 바로 탈출
//				if(number[now] < number[i]) {
//					flag = true;
//					break;
//				}
//			}
//			// 만약 범위를 다 봤을 때 지금 보고있는 값인 now 보다 큰 게 있다면
//			if(flag) {
//				// now 위치를 삭제 리스트에 넣어준다
//				K -= 1;
//				delete_list.add(now);
//			}
//			now += 1;
//		}
		
//		for(int i = 0; i < N; i++) {
//			if(delete_list.contains(i)) {
//				continue;
//			}
//			bw.write(String.valueOf(number[i]) + "");
//		}
//		
		
		// 두 번째 시도 : 스택 활용
//		현재 숫자 vs 스택 
//		Top? 새로운 숫자를 만날 때마다, 스택의 맨 위 숫자가 현재 숫자보다 작다면
//		스택의 맨 위 숫자를 삭제
//		K 소진? 이 삭제 과정을 K가 0이 될 때까지 반복
//		이 과정을 마친 후 현재 숫자를 스택에 추가
		// append --> addLast
		// peek --> 그냥 마지막 값 보기 peekLast
		// pop --> 꺼내오기 removeLast
		String line = br.readLine();

		Deque<Integer> stack = new ArrayDeque<>();
	
		for(int i = 0; i < N; i++) {
			char val = line.charAt(i);
			int now = Integer.parseInt(String.valueOf(val)); // 지금 들어오는 값
			
			// 만약 삭제해야 할 카운트가 있고, 빈 스택이 아니면
			while(K > 0 && !stack.isEmpty() && stack.peekLast() < now) {
				stack.removeLast();
				K -= 1;
			}	
			stack.addLast(now);
		}
		
		while(K > 0) {
			stack.removeLast();
			K -= 1;
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i : stack) {
			sb.append(i);
		}
		bw.write(sb.toString());
		
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	
}
