/* 백준 11047 - 동전 0
 * 그리디 알고리즘 */

import java.util.*;
import java.io.*;

public class Q032_동전_개수의_최솟값_구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] <= K) {
                count += K / A[i];
                K = K % A[i];
            }
        }

        System.out.println(count);
    }
}
