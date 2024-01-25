/* 백준 1929 - 소수 구하기
 * 에라토스테네스의 체 */

import java.util.*;

public class Q037_소수_구하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] A = new boolean[N + 1];
        A[1] = true; // 1은 소수가 아님
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (A[i]) {
                continue;
            }
            for (int j = i + i; j <= N; j += i) {
                if (!A[j]) {
                    A[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!A[i]) {
                System.out.println(i);
            }
        }
    }
}
