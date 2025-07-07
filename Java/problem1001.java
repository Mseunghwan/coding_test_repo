import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class problem1001 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // str을 넣고 " "을 기준으로 나눈 걸 st에 넣어두고 st.Token으로 불러온다 하나씩
        StringTokenizer st = new StringTokenizer(str, " ");


        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(a - b);


    }
}
