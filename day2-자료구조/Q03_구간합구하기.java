// 백준 1546 - 평균
import java.io.*;
import java.util.*;

public class Q03_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] S = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int range1 = Integer.parseInt(st.nextToken());
            int range2 = Integer.parseInt(st.nextToken());

            System.out.println(S[range2] - S[range1-1]);
        }
    }
}
