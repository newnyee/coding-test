/* 백준 1253 - 좋다 */

import java.io.*;
import java.util.*;
public class Q008_좋은수구하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        int count = 0;
/* 틀린 풀이
반례
N: 3 / 0 1 1
답 : 2

        if (N >= 3) {
            for (int i = 2; i < N; i++) {
                int start = 0;
                int end = i-1;

                while (start < end) {
                    long sum = A[start] + A[end];
                    if (sum > A[i]) {
                        end--;
                    } else if (sum < A[i]) {
                        start++;
                    } else {
                        count++;
                        break;
                    }
                }
            }
        }*/

        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N-1;

            while (start < end) {
                long sum = A[start] + A[end];
                if (sum > A[i]) {
                    end--;
                } else if (sum < A[i]) {
                    start++;
                } else {
                    if (start != i && end != i) {
                        count++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
