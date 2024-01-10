/* 백준 11399 - ATM
* 삽입 정렬 풀이 */

import java.io.*;
import java.util.*;
public class Q018_ATM인출_시간_계산하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> A = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        A.add(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < N; i++) { // 입력받은 숫자로 바로 삽입정렬
            int num = Integer.parseInt(st.nextToken());
            boolean isAdd = false;
            for (int j = 0; j < i; j++) {
                if (A.isEmpty() || num <= A.get(j)) {
                    A.add(j, num);
                    isAdd = true;
                    break;
                }
            }
            if (isAdd == false) {
                A.add(num);
            }
        }

        int[] S = new int[N+1]; // 합배열로 필요한 총 인출 시간 계산
        int result = 0;
        for (int i = 1; i <= N; i++) {
            S[i] = S[i-1] + A.get(i-1);
            result += S[i];
        }

        System.out.println(result);
    }
}
