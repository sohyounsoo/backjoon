package stack_queue;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * 스택
 */

public class 스택_수열_1874 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        int num = 1;
        StringBuffer buffer = new StringBuffer();

        boolean flag = false;
        for (int i = 0; i < n; i++) {

            if(arr[i] >= num) {
                while(arr[i] >= num) {
                    st.push(num++);
                    buffer.append("+\n");
                }
                st.pop();
                buffer.append("-\n");
            } else {
                int s = st.pop();
                if(s > arr[i]) {
                    System.out.println("NO");
                    flag = true;
                    break;
                } else {
                    buffer.append("-\n");
                }
            }
        }

        if(!flag) System.out.println(buffer.toString());


    }

}
