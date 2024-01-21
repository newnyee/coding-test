/* 백준 1300 - K번째 수
 * 이진 탐색
 * https://st-lab.tistory.com/281 */

import java.util.*;

public class Q031_배열에서_K번째_수_찾기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        long s = 1;
        long e = k;

        while (s < e) {

            long m = (s + e) / 2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(m / i, N);
            }

            if (k <= count) {
                e = m;
            } else {
                s = m + 1;
            }
        }

        System.out.println(s);
    }
}
