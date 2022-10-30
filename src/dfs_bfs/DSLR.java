package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 
입력:
3
1234 3412
1000 1
1 16

출력 :
LL
L
DDDD
 */
public class DSLR {

	static Queue<Integer> q;
	static boolean[] visited;
	static String[] command; 
	
	private static void bfs(int a, int b) {
		
		while(!q.isEmpty() && !visited[b]) {
			int now = q.poll();
			
			int D = 2 * now % 1000;
			int S = now == 0 ? 9999 : now - 1;
			int L = now % 1000 * 10 + now / 1000; 
			int R = now % 10 * 1000 + now / 10;
			
			if(!visited[D]) {
				q.add(D);
				visited[D] = true;
				command[D] = command[now] + "D";
			}
			
			if (!visited[S]) {
                q.add(S);
                visited[S] = true;
                command[S] = command[now] + "S";
            }

            if (!visited[L]) {
                q.add(L);
                visited[L] = true;
                command[L] = command[now] + "L";
            }

            if (!visited[R]) {
                q.add(R);
                visited[R] = true;
                command[R] = command[now] + "R";
            }
		}
		System.out.println(command[b]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			
			q = new LinkedList<>();
			q.add(a);
			
			visited = new boolean[10000];
			visited[a] = true;
			
			command = new String[10000];
			Arrays.fill(command, "");
			
			String s = "s";
			
			bfs(a, b);
		}
	}

	

}
