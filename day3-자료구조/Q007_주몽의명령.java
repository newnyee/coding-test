/* 백준 1940 - 주몽
* 첫번째 줄: N개의 재료
* 두번째 줄: 두 재료의 고유번호의 합 = M
* 세번째 줄: N개의 재료들의 고유번호 공백을 사이에 두고 주어짐
*
* sum > N: end--
* sum < N: start++
* sum == N: end--, start++, count++
* */

import java.io.*;
import java.util.*;
public class Q007_주몽의명령 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int start = 0;
        int end = N-1;
        int count = 0;

        while (start < end) {

            int sum = A[start] + A[end];

            if (sum > M) {
                end--;
            } else if (sum < M) {
                start++;
            } else {
                end--;
                start++;
                count++;
            }
        }

        System.out.println(count);
    }
}
