package stack_queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 우선순위 큐
 */

public class 절댓값_힙_11286 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if (first == second) {
                return o1 > o2 ? 1 : -1;
            }
            return first - second;
        });

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if( 0 == num) {
                if(queue.isEmpty()) {
                    System.out.println("0");
                }else {
                    System.out.println(queue.poll());
                }
            }else {
                queue.add(num);
            }
        }

    }
}
