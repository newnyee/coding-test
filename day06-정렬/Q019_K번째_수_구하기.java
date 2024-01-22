/* 백준 11004 - K번째 수
 * 퀵 정렬 풀이 */

import java.io.*;
import java.util.*;

public class Q019_K번째_수_구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }


    /**
     * 퀵 정렬 메소드
     * @param A 원본 배열
     * @param s start 인덱스
     * @param e end 인덱스
     * @param K 주어진 숫자 K
     */
    public static void quickSort(int[] A, int s, int e, int K) {
        if (s < e) {
            int pivot = partition(A, s, e); // 기준값
            if (pivot == K) {
                return;
            } else if (K < pivot) { // 기준값의 왼쪽 요소들만 퀵정렬
                quickSort(A, s, pivot - 1, K);
            } else { // 기준값의 오른쪽 요소들만 퀵정렬
                quickSort(A, pivot + 1, e, K);
            }
        }
    }

    // 퀵 정렬 후 해당 기준값의 인덱스 구하기
    public static int partition(int[] A, int s, int e) {

        if (s + 1 == e) { // 데이터가 2개인 경우
            if (A[s] > A[e]) {
                swap(A, s, e);
            }
            return e;
        }

        // 중앙값을 첫번째 요소로 이동시킴
        int m = (s + e) / 2;
        swap(A, s, m);

        // 이동시킨 첫번째 요소를 기준값으로 함
        int pivot = A[s];

        int i = s + 1; // start 포인터
        int j = e; // end 포인터
        while (i <= j) {
            while (j >= s + 1 && pivot < A[j]) { // 기준값보다 작은수가 나올 때 까지 end 포인터 이동
                j--;
            }
            while (i <= e && pivot > A[i]) { // 기준값보다 큰 수가 나올 때 까지 start 포인터 이동
                i++;
            }
            if (i <= j) {
                swap(A, i++, j--); // swap 함수 호출 후 양쪽 포인터 이동
            }
        }

        A[s] = A[j]; // j = 두 그룹의 경계의 작은수 쪽 인덱스 위치
        A[j] = pivot; // 이동시켰던 기준값을 경계 인덱스에 저장함
        return j; // 경계 인덱스 return
    }
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
