package array;

import java.io.IOException;
import java.util.Scanner;

/**
 * 투 포인트
 */

public class 수들의_합_2018 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int sum = 1, count = 1, s_index = 1, e_index = 1;

        while(e_index < num) {
            if(sum < num) {
                e_index++; sum += e_index;
            }else if(sum > num) {
                sum -= s_index; s_index++;
            }else {
                count++; e_index++; sum += e_index;
            }
        }

        System.out.println(count);
    }
}
