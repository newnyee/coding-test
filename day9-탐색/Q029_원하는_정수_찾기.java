/* 백준 1920 - 수 찾기
 * 이진 탐색 */

import java.io.*;
import java.util.*;

public class Q029_원하는_정수_찾기 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int result = 0;
            long target = Long.parseLong(st.nextToken());
            int s = 0;
            int e = N-1;

            while (s <= e) {

                int m = (s + e) / 2;

                if (A[m] > target) {
                    e = m - 1;
                } else if (A[m] < target) {
                    s = m + 1;
                } else {
                    result = 1;
                    break;
                }
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}
