/* 백준 2023 - 신기한 소수
 * 깊이 우선 탐색 */

import java.util.*;
public class Q024_신기한_소수_찾기 {

    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    /**
     * 깊이 우선 탐색
     * @param num 숫자
     * @param digits 자릿수
     */
    public static void dfs(int num, int digits) {

        if (digits == N) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        // 뒷자리 홀 수
        for (int i = 1; i < 10; i = i + 2) {

            // 현재 자릿수 + 1 의 숫자가 소수일 경우
            if (isPrime(num * 10 + i)) {

                // 현재 자릿수 + 1 의 숫자로 재귀함수 호출함
                dfs(num * 10 + i, digits + 1);
            }
        }
    }

    // 소수 확인
    public static boolean isPrime(int num) {

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}