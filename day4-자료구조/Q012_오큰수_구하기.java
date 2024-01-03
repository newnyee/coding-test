/* 백준 17298 - 오큰수
*
* N = 수열의 크기
* NGE(i) = 오큰수 : 인덱스와 원소의 크기가 i번째 원소보다는 큰 원소들 중 인덱스가 가장 작은 원소
* */

import java.util.*;
import java.io.*;

public class Q012_오큰수_구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] A = new int[N];
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            if (result[i] == 0) {
                bw.write("-1 ");
            } else {
                bw.write(result[i] + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}