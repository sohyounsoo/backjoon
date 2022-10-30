package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
입력 :
6
0 1 2 3 4 5
1 0 2 3 4 5
1 2 0 3 4 5
1 2 3 0 4 5
1 2 3 4 0 5
1 2 3 4 5 0

출력 :
2
 *
 */
public class 스타트와링크 {
	
	static int n;
	static int min = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visit;
	
	private static void dfs(int depth, int count) {
		if(depth == n/2) {
			diff();
			return;
		}
		
		for (int i = count; i < n; i++) {
			visit[i] = true;
			dfs(depth + 1, i + 1);
			visit[i] = false;
		}
	}
	
	private static void diff() {
		int start = 0;
		int link = 0;
		
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if(visit[i]==true && visit[j]==true) {
					start += arr[i][j];
					start += arr[j][i];
				} else if(visit[i]==false && visit[j]==false) {
					link += arr[i][j];
					link += arr[j][i];
				}
			}
		}
		
		int val = Math.abs(start - link);
		
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		min = Math.min(min, val);
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.valueOf(str.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(min);

	}

	

}
