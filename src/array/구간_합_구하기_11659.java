package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 구간_합_구하기_11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());
        long[] s = new long[n + 1]; // 0 번째 인덱스를 무시하고 진행

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            s[i] = s[i-1] + Integer.parseInt(st.nextToken()); // 합배열 공식
        }

        for(int q = 0; q < quizNo; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(s[j] - s[i-1]);
        }

    }
}
