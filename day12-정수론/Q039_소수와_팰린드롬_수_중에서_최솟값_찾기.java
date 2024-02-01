/* 백준 1747 - 소수 & 팰린드롬
 * 에라토스테네스의 체
 *
 * 배열 A의 범위를 넉넉하게 잡은 후 로직을 먼저 구현하여 실행한 결과
 * N의 최대값인 1000000을 입력했을 때 소수이면서 팰린드롬 수인 값이 1003001로 도출됨
 * 배열 A의 범위를 도출된 범위로 다시 좁혀서 코딩을 완료함
 * */

import java.util.*;

public class Q039_소수와_팰린드롬_수_중에서_최솟값_찾기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] A = new boolean[1003002];
        A[1] = true;
        for (int i = 2; i < Math.sqrt(A.length); i++) {
            if (A[i]) {
                continue;
            }
            for (int j = i + i; j < A.length; j += i) {
                if (!A[j]) {
                    A[j] = true;
                }
            }
        }

        for (int i = N; i < A.length; i++) {
            if (!A[i] && isPalindrome(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    public static boolean isPalindrome(int target) {

        char temp[] = String.valueOf(target).toCharArray();
        int s = 0;
        int e = temp.length - 1;
        while (s < e) {
            if (temp[s] != temp[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
