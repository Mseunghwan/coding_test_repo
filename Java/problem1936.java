import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class problem1936 {

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();

    StringTokenizer st = new StringTokenizer(str, " ");

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    if(a == 1 && b == 2){
        System.out.println("B");
    }
    else if(a == 1 && b == 3) {
        System.out.println("A");
    }
    else if(a == 2 && b == 1) {
        System.out.println("A");
    }
    else if(a == 2 && b == 3) {
        System.out.println("B");
    }
    else if(a == 3 && b == 1) {
        System.out.println("B");
    }
    else if(a == 3 && b == 2) {
        System.out.println("A");
    }
    
}
}
