package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 입력:
4 6
a t c i s w

*/

public class 암호만들기 {
	static int l,c;
	static char arr[];
	static boolean visited[];
	static ArrayList<String> list = new ArrayList<>();
	
	static void vaild() {
		String s = new String();
		int v = 0;
		int cc = 0;
		
		for(int i=0;i<c;i++) {
			if(visited[i]) {
				s += arr[i];
				if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') {
					v++;
				}else cc++;	
			}
		}
		if(v>=1 && cc>=2) {
			list.add(s);
		}
	}
	
	static void combination(int start,int cnt) {
		if(cnt==l) {
			vaild();
		}
		//백트래킹
		for(int i=start;i<c;i++) {
			visited[i]=true;
			combination(i+1,cnt+1);
			visited[i]=false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		l = sc.nextInt();
		c = sc.nextInt();
		arr = new char[c];
		visited = new boolean[c];
		
		for(int i=0;i<c;i++) {
			arr[i] = sc.next().charAt(0);
		}
		
		Arrays.sort(arr);
	
		combination(0, 0);
		
		for(String s : list) {
			System.out.println(s);
		}
	}
	

}
