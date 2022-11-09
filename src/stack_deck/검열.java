package stack_deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 검열 {

	  public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String keyStr = br.readLine();
	        int keyLen = keyStr.length();
	        StringBuilder tarStr = new StringBuilder(br.readLine());
	        boolean isLeft = true;

	        while(true) {
	            if(isLeft) {
	                int position = tarStr.indexOf(keyStr);

	                if(position > -1){
	                    tarStr.delete(position, position+keyLen);
	                    isLeft = false;
	                }
	                else
	                    break;
	            }
	            else {
	                int position = tarStr.lastIndexOf(keyStr);

	                if(position > -1){
	                    tarStr.delete(position, position+keyLen);
	                    isLeft = true;
	                }
	                else
	                    break;
	            }
	        }
	        System.out.println(tarStr.toString());
	  }
}
