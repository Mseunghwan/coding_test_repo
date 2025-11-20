import java.io.*;
import java.util.*;

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
		// First Try : 그리?�� 배열 반복
		// N 까�? ?��번의 반복 --> 2500?�� �? ?��?��?���?, X ?��?��?�� 코드
		// number ?��?��?�� �??�� k 만큼?�� 범위�? ?��?��?��?��, ?��?�� 범위?��?�� ?��기�? �??�� ?���? ?��?�� ?��치로
		// ?��기�? �??�� ?���? ?��?���? ?��?��?��?��. ?��?��?��?��?�� k -= 1 �? 범위 ?��?�� ?��?�� ?�� ?��?�� 칸으�?
		// ?��?��, ?��?�� ?���? ?��?���??�� ?�� K 만큼 범위�? ?��?��?��?��.
		
		// ?��?�� ?���?
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
//				// 만약 범위?�� ?��보다 ?���? ?��?��?��?�� ?��?���? 바로 ?���?
//				if(number[now] < number[i]) {
//					flag = true;
//					break;
//				}
//			}
//			// 만약 범위�? ?�� 봤을 ?�� �?�? 보고?��?�� 값인 now 보다 ?�� �? ?��?���?
//			if(flag) {
//				// now ?��치�?? ?��?�� 리스?��?�� ?��?���??��
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
		
		// ?�� 번째 ?��?�� : ?��?�� ?��?��
//		?��?�� ?��?�� vs ?��?�� 
//		Top? ?��로운 ?��?���? 만날 ?��마다, ?��?��?�� �? ?�� ?��?���? ?��?�� ?��?��보다 ?��?���?
//		?��?��?�� �? ?�� ?��?���? ?��?��
//		K ?���?? ?�� ?��?�� 과정?�� K�? 0?�� ?�� ?��까�? 반복
//		?�� 과정?�� 마친 ?�� ?��?�� ?��?���? ?��?��?�� 추�?
		// append --> addLast
		// peek --> 그냥 마�?�? �? 보기 peekLast
		// pop --> 꺼내?���? removeLast
		String line = br.readLine();

		Deque<Integer> stack = new ArrayDeque<>();
	
		for(int i = 0; i < N; i++) {
			char val = line.charAt(i);
			int now = Integer.parseInt(String.valueOf(val)); // �?�? ?��?��?��?�� �?
			
			// 만약 ?��?��?��?�� ?�� 카운?���? ?���?, �? ?��?��?�� ?��?���?
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
