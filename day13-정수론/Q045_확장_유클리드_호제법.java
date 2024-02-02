/* 백준 21568 - Ax + By = C
 * 확장 유클리드 호제법
 * */

import java.util.*;

public class Q045_확장_유클리드_호제법 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        long gcd = gcd(a, b);
        if (c % gcd != 0) {
            System.out.println(-1);
            return;
        }

        int mok = (int) (c / gcd);
        long[] ret = execute(a, b);
        System.out.println(ret[0] * mok + " " + ret[1] * mok);
    }

    public static long[] execute(long a, long b) {
        long[] ret = new long[2];
        if (b == 0) {
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }

        long q = a / b;
        long[] v = execute(b, a % b);
        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;
        return ret;
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }
}
