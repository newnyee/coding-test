/* 백준 2750 - 수 정렬하기 */

import java.util.*;

public class Q015_수_정렬하기1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            boolean swap = false;
            for (int j = 0; j < N - i -1; j++) {
                int target = A[j];
                if (target > A[j + 1]) {
                    A[j] = A[j + 1];
                    A[j + 1] = target;
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }

        for (int i : A) {
            System.out.println(i);
        }
    }
}
