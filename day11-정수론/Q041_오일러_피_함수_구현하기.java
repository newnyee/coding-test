/* 백준 11689 - GCD(n,k)=1
 * 오일러 피 함수
 * */

import java.util.*;

public class Q041_오일러_피_함수_구현하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long result = n;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result = result - result / i;
            }
            while (n % i == 0) {
                n /= i;
            }
        }

        if (n > 1) {
            result = result - result / n;
        }

        System.out.println(result);
    }
}
