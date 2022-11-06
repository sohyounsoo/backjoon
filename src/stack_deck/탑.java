package stack_deck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
	
	static class Top { 
		int num;
		int height;
		
		Top(int num, int height) {
			this.num = num;
			this.height = height;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Stack<Top> stack = new Stack<>();
		StringBuilder answer = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty()) { // 스택이 비어있으면, 0을 출력하고 탑을 push
				answer.append("0 ");
				stack.push(new Top(i, height));
			}else {
				while(true) {
					if(stack.isEmpty()) { // 스택이 비어있으면, 0을 출력하고 탑을 push
						answer.append("0 ");
						stack.push(new Top(i, height));
						break;
					}
					
					Top top = stack.peek(); // 하나 꺼낸다
					
					if(top.height > height) {
						answer.append(top.num + " ");
						stack.push(new Top(i, height));
						break;
					}else {
						stack.pop();
					}
				}
			}
		}
		
		bw.write(answer.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
