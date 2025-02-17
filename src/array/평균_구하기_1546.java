package array;

import java.io.IOException;
import java.util.Scanner;


public class 평균_구하기_1546 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long sum = 0, max = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if(max < arr[i]) max = arr[i];
            sum += arr[i];
        }

        System.out.println(sum * 100.0 / max / n);
    }
}
