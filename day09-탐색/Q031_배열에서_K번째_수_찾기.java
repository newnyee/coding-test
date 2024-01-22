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
                // 배열 한줄당 최대 N개이므로 N보다 큰 수가 count될 수 없음, 따라서 min 함수 사용
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
