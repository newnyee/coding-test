/* 백준 1456 - 거의 소수
 * 에라토스테네스의 체 */

import java.util.*;

public class Q038_거의_소수_구하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] A = new boolean[10000001];
        for (int i = 2; i <= Math.sqrt(A.length); i++) {
            if (A[i] == true) {
                continue;
            }
            for (int j = i + i; j < A.length; j += i) {
                A[j] = true;
            }
        }

        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (!A[i]) {
                long temp = i;
                while (i <= (double) max / temp) {
                    if (i >= (double) min / temp) {
                        count++;
                    }
                    temp = temp * i;
                }
            }
        }

        System.out.println(count);
    }

    /*public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        boolean[] arr = new boolean[(int) Math.sqrt(B) + 1];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = i + i; j < arr.length; j += i) {
                if (!arr[j]) {
                    arr[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                long sum = (long) i * i; // 캐스팅 미스
                while (sum <= B) {
                    if (sum >= A) {
                        count++;
                    }
                    sum *= i;
                }
            }
        }

        System.out.println(count);
    }*/
}
