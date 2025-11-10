import java.util.*;
import java.io.*;

public class problem1000 {
    public static void main(String[] args) throws IOException {
        // java 에서 입력 받는 방법의 대표적인 방법이 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] lectures = new int[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures[i][0] = start;
            lectures[i][1] = end;
        }

//        for(int i = 0; i < n; i++){
//            System.out.println(Arrays.toString(lectures[i]));
//        }
        // 정렬
        Arrays.sort(lectures, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o2[1]; // 끝나는 시간 오름차순
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(lectures[0][1]);

        for (int i = 1; i < n; i++){
            int current_start = lectures[i][0];
            int current_end = lectures[i][1];

            int earliest_end = pq.peek();

            if (current_start >= earliest_end) {
                pq.poll();
            }

            pq.add(current_end);
        }

        System.out.println(pq.size());

        br.close();
    }
}
