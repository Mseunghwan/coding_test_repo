import java.util.*;
import java.io.*;

public class baekjoon1477 {

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> roads = new ArrayList<>();

        roads.add(0);
        for(int i = 0; i < N; i++) {
            roads.add(Integer.parseInt(st.nextToken()));
        }
        roads.add(L);
        Collections.sort(roads);
        int left = 1;
        int right = L;
        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            int requiredStops = 0;
            for(int i = 1; i < roads.size(); i++) {
                int distance = roads.get(i) - roads.get(i - 1);
                if(distance > mid) {
                    requiredStops += (distance - 1) / mid;
                }
            }

            if(requiredStops > M) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();


    }
        
}
