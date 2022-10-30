package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 
입력 :
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

출력 : 
3
7
8
9
 */

public class 단지번호붙이기 {

	static int[][] map;
	static final int dx[] = {0, 0, 1, -1};
	static final int dy[] = {1, -1, 0, 0};
	static int n, count;
	
	static ArrayList<Integer> answer = new ArrayList<>();
	
	static class Point {
		public int x, y;
		Point(int x , int y) {
			this.x = x;
			this.y = y;
		}
	}
	
		
	static void bfs(int x, int y) {
		count++;
		map[x][y] = 0;
		
		Queue<Point> q = new LinkedList<Point>();
		
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for(int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny] == 1) {
					count++;
					map[nx][ny] = 0;
					q.offer(new Point(nx, ny));
				}
			}
		}
	}
	
	static void dfs(int x, int y) {
		count++;
		map[x][y] = 0;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && n>nx && n>ny && map[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String input = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 1) {
					count = 0;
//					dfs(i, j);
					bfs(i, j);
					answer.add(count);
				}
			}
		}
		
		Collections.sort(answer);
		
		for(int a : answer) {
			System.out.println(a);
		}
		

	}

}
