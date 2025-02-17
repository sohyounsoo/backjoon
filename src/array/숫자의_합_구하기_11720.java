package array;

import java.io.IOException;
import java.util.Scanner;


public class 숫자의_합_구하기_11720 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char[] c = s.toCharArray();
        int sum = 0;

        for(int i=0; i<n; i++) {
            sum += c[i] - '0';
        }

        System.out.println(sum);
    }
}
