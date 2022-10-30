package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
입력:
10 1 10 2 1
출력:
6

입력:
100 2 1 1 0
출력:
use the stairs
 */
public class 스타트링크 {
	
	static int F, S, G, U, D;
	
	private static int bsf(int[] arr) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(S); // 현재 층
		arr[S] = 1; // 시작점 안눌렀지만 1로 중복 체크
		
		int s = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == G) {
				return arr[now] - 1; // 시작할때 누른거 취소
			}
			
			if(now + U <= G && arr[now + U] == 0) {
				arr[now + U] = arr[now] + 1;
				q.add(now + U);
				
			}
			
			if(now - D > 0 && arr[now - D] == 0) {
				arr[now - D] = arr[now] + 1;
				q.add(now - D);
				
			}
			
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken()); // 건물 총 층
        S = Integer.parseInt(st.nextToken()); // 현재 층
        G = Integer.parseInt(st.nextToken()); // 목표 층
        U = Integer.parseInt(st.nextToken()); // 업
        D = Integer.parseInt(st.nextToken()); // 다운
        
        int[] arr = new int[F + 1];
        int answer = bsf(arr);
        
        if(answer == -1) System.out.println("use the stairs");
        else System.out.println(answer);
        

	}
}
