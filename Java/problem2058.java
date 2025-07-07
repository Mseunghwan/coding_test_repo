import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2058 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int sum = 0;
        for(int i = 0; i < str.length(); i++){
            sum += Character.getNumericValue(str.charAt(i));
        }
        System.out.println(sum);

    }
}