import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class problem2063 {
    public static void main(String[] args) throws Exception { 

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] list = new int[n];
        int mid = n / 2;

        for(int i = 0; i < n; i ++){
            list[i] = sc.nextInt();
        }

        Arrays.sort(list);
        System.out.println(list[mid]);



    }
}
