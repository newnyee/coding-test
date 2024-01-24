/* 백준 1931 - 회의실 배정
* 그리디 알고리즘 */

import java.io.*;
import java.util.*;

public class Q035_회의실_배정하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료 시간 기준으로 오름 차순 정렬
        // 단, 종료시간이 같다면 시작시간 기준으로 오름차순 정렬
        Arrays.sort(A, (S, E)->{
            if (S[1] == E[1]) {
                return S[0] - E[0];
            }
            return S[1] - E[1];
        });

        int count = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            if (A[i][0] >= end) { // 시작시간이 현재 종료 시간과 겹치지 않은 경우
                end = A[i][1]; // 종료시간 업데이트
                count++;
            }
        }

        System.out.println(count);
    }
}
