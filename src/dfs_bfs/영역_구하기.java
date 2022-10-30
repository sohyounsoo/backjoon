/*
 * 입력 :
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2

출력 :
3
1 7 13
 */

package dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import dfs_bfs.단지번호붙이기.Point;

public class 영역_구하기 {

	static final int dx[] = {0, 0, 1, -1};
	static final int dy[] = {1, -1, 0, 0};
	static int n, m, count;
	static int size[][];
	static ArrayList<Integer> answer = new ArrayList<>();
	
	static void dfs(int x, int y) {
		count++; //영역의 개수 증가
		size[x][y] = 1;
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(0<=nx && nx<n && 0<=ny && ny<m) {
				if(size[nx][ny] == 0) {
					dfs(nx,ny);
				}
			}
		}
	}
	
	static void bfs(int x, int y) {
		size[x][y] = 1;
		count++; //영역의 개수 증가
		
		Queue<Point> q = new LinkedList<Point>();
		
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for(int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && size[nx][ny] == 0) {
					size[nx][ny] = 1;
					count++;
					q.offer(new Point(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();
		
		size = new int[n][m];
		
		for(int i=0; i<k; i++) {
			int x1 = sc.nextInt(); //0
			int y1 = sc.nextInt(); //2
			int x2 = sc.nextInt(); //4
			int y2 = sc.nextInt(); //4
			
			for(int x=y1; x<y2; x++) { 
				for(int y=x1; y<x2; y++){ 
					size[x][y] = 1; //직사각형이 만들어지는 곳은 1로 변경
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(size[i][j] == 0) {
					count = 0; //영역 개수 초기화
					//bfs(i,j);
					dfs(i,j);
					answer.add(count);
				}
			}
		}
		
		Collections.sort(answer); //오름차순 정렬
		
		for(int i : answer)  {
			System.out.println(i);
		}
	}
}
