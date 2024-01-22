/* 백준 10989 - 수 정렬하기3
 * 계수 정렬 풀이
 *
 * 계수 정렬 알고리즘 사용 조건
 * 1. 데이터의 크기가 작아야함
 * 2. 데이터가 양수여야함
 * */

import java.io.*;

public class Q022_수_정렬하기3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[10001];
        for (int i = 0; i < N; i++) {
            A[Integer.parseInt(br.readLine())]++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= 10000; i++) {
            while (A[i] > 0) {
                bw.write(i + "\n");
                A[i]--;
            }
        }

        bw.flush();
        bw.close();
    }
}
