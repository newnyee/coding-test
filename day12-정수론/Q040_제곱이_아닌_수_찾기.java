/* 백준 1016 - 제곱 ㄴㄴ수
 * 에라토스테네스의 체
 * */

import java.util.*;

public class Q040_제곱이_아닌_수_찾기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] A = new boolean[(int) (max - min + 1)];
        for (long i = 2; i * i <= max; i++) {

            long num = i * i;
            long s = min / num;
            // 나누어 떨어진다면 s * num의 경우 min과 같기 때문에 그대로 두어도 되지만
            // 나누어 떨어지지 않는다면 해당 s * num의 경우 min 값보다 작기 때문에 s에 1 을 더함
            if (min % num != 0) {
                s++;
            }

            for (long j = s; num * j <= max; j++) {
                A[(int) (num * j - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (!A[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
