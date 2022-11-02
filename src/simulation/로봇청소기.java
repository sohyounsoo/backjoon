package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {
	
	static int[][] map;
	static int N, M, r, c, d;
	private static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(clean(r, c, d));

	}

	private static int clean(int x, int y, int d) {
		int dirCount = 0, cnt = 0, nx, ny;
		boolean flag = true;
		
		while (flag) {
			if (map[x][y] == 0) {
				map[x][y] = 2;
				cnt++;
			}
			
			while (true) {
				if (dirCount == 4) {
					nx = x - dx[d];
					ny = y - dy[d];
					
					if (map[nx][ny] == 1) {	//뒷칸도 벽 
						flag = false;
						break;
					} else {
						x = nx;
						y = ny;
						dirCount = 0;
					}
				}
				
				d = (d + 3) % 4;
				nx = x + dx[d];
				ny = y + dy[d];
				
				if (map[nx][ny] == 0) {
					dirCount = 0;
					x = nx; y = ny;
					break;
				} else {
					dirCount++;
					continue;
				} 
			}
		}
		return cnt;
	}

}
