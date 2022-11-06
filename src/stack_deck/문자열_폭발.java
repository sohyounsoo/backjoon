package stack_deck;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열_폭발 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String boom = br.readLine();
		
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			st.push(str.charAt(i));
			
			
			if(st.size() >= boom.length()) {
				boolean contain = true;
				
				//폭발 문자열의 길이만큼 반복
				for(int j=0; j<boom.length(); j++) {
					
					if(st.get(st.size() - boom.length() + j) != boom.charAt(j)) {
						contain = false;
						break;
					}
				}
				
				if(contain) {
					for(int j=0; j<boom.length(); j++) {
						st.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character c : st) {
			sb.append(c);
		}
		
		
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
		

	}

}
