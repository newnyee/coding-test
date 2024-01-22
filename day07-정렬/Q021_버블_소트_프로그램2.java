/* 백준 1517 - 버블 소트
 * 병합 정렬 풀이 */

import java.io.*;
import java.util.*;

public class Q021_버블_소트_프로그램2 {
    static int[] A;
    static int[] temp;
    static long count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        temp = new int[N];
        mergeSort(0, N - 1);
        System.out.println(count);
    }

    public static void mergeSort(int s, int e) {

        if (s >= e) {
            return;
        }

        int m = (s + e) / 2;
        mergeSort(s, m);
        mergeSort(m + 1, e);

        int index = s;
        int p1 = s;
        int p2 = m + 1;
        while (p1 <= m && p2 <= e) {

            if (A[p1] > A[p2]) {
                temp[index] = A[p2];
                count = count + (p2 - index);
                index++;
                p2++;
            } else {
                temp[index++] = A[p1++];
            }
        }

        while (p1 <= m) {
            temp[index++] = A[p1++];
        }
        while (p2 <= e) {
            temp[index++] = A[p2++];
        }

        for (int i = s; i <= e; i++) {
            A[i] = temp[i];
        }
    }
}
