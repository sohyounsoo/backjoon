package dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.zip.CheckedInputStream;

public class 사디리_조작 {
	
	private static int n, m, h, answer;
	private static int[][] map;
	private static boolean finish = false;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 세로 선
		m = Integer.parseInt(st.nextToken()); // 가로 선
		h = Integer.parseInt(st.nextToken()); // 세로선마다 가로선을 놓을 수 있는 위치의 개수
		
		map = new int[h+1][n+1];
		
		int x, y;
		for(int i=0; i<m; i++) { // 가로선 갯수 만큼 반복
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y] = 1; // 오른쪽 이동
			map[x][y+1] = 2; // 왼쪽으로 이동
		}
		
		for(int i=0; i<3; i++) {
			answer = i;
			dfs(1, 0);
		}
		

	}

	private static void dfs(int x, int count) {
		if (finish) return;
		if(answer == count) {
			if(check()) finish = true;
			return;
		}
		
		for(int i=x; i < h+1; i++) {
			for(int j=1; j < n; j++) {
				if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(i, count + 1);
                    map[i][j] = map[i][j + 1] = 0;
                }
			}
		}
	}

	private static boolean check() {
		for (int i = 1; i <= n; i++) {
            int x = 1, y = i;
            for (int j = 0; j < h; j++) {
                if (map[x][y] == 1) y++;
                else if (map[x][y] == 2) y--;
                x++;
            }
            if (y != i) return false;
        }
        return true;
	}

}
