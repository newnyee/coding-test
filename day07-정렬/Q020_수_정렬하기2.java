/* 백준 2751 - 수 정렬하기 2
* 병합 정렬 풀이 */

import java.io.*;

public class Q020_수_정렬하기2 {

    static int[] A;
    static int[] temp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        temp = new int[N];
        mergeSort(0, N - 1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : A) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void mergeSort(int s, int e) { // 시작 인덱스, 끝 인덱스

        if (s >= e) {
            return;
        }

        // 분할 작업
        int m = (s + e) / 2;
        mergeSort(s, m);
        mergeSort(m + 1, e);

        // 분할한 인덱스로 sort 작업 (투 포인터)
        int p1 = s;
        int p2 = m + 1;
        int index = s;
        while (p1 <= m && p2 <= e) {

            if (A[p1] < A[p2]) {
                temp[index++] = A[p1++];
            } else {
                temp[index++] = A[p2++];
            }
        }

        // 잔여 값 처리
        while (p1 <= m) {
            temp[index++] = A[p1++];
        }
        while (p2 <= e) {
            temp[index++] = A[p2++];
        }

        // 정렬된 값 원본 배열에 저장
        for (int i = s; i <= e; i++) {
            A[i] = temp[i];
        }
    }
}
