/* 백준 2343 - 기타 레슨
 *
 * 블루레이 크기 범위 = 배열 중 가장 긴 강의 시간 ~ 전체 강의 시간의 합
 * 예제의 블루레이 크기 범위 = 9 ~ 45
 *
 * 이진 탐색으로 블루레이의 수 찾기
 * mid = (9 + 45) / 2 = 27 → 27초로는 2개의 블루레이가 만들어짐
 * 목표 블루레이보다 작거나 같기 때문에 9 ~ 27 사이의 범위로 블루레이 크기 범위 좁힘
 *
 * mid = (9 + 27) / 2 = 18 → 18초로는 3개의 블루레이가 만들어짐
 * 목표 블루레이보다 작거나 같기 때문에 9 ~ 18 사이의 범위로 블루레이 크기 좁힘
 *
 * mid = (9 + 18) / 2 = 13 → 13초로는 5개의 블루레이가 만들어짐
 * 목표 블루레이보다 크므로 14 ~ 18 사이의 범위로 블루레이 크기 좁힘
 *
 * mid = (14 + 18) / 2 = 16 → 16초로는 4개의 블루레이가 만들어짐
 * 목표 블루레이보다 크므로 블루레이 크기 범위를 17 ~ 18 사이로 좁힘
 *
 * mid = (17 + 18) / 2 = 17 → 17초로는 3개의 블루레이가 만들어짐
 * 목표 블루레이보다 작거나 같으므로 블루레이 크기 범위를 17 로 좁힘
 *
 * start 와 end가 17로 같으므로 17을 도출하며 종료
 * */

import java.io.*;
import java.util.*;

public class Q030_블루레이_만들기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int s = 0;
        int e = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (s < A[i]) {
                s = A[i];
            }
            e += A[i];
        }

        int result = 0;
        while (s <= e) {

            if (s == e) {
                result = s;
                break;
            }

            int m = (s + e) / 2;
            int count = 0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (sum + A[i] > m) {
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }

            if (sum != 0) {
                count++;
            }

            if (count > M) {
                s = m + 1;
            } else {
                e = m;
            }
        }

        System.out.println(result);
    }
}
