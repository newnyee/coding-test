/* 백준 1715 - 카드 정렬하기
 * 그리디 알고리즘 */

import java.io.*;
import java.util.*;

public class Q033_카드_정렬하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        long result = 0;
        while (queue.size() > 1) {

            int a = queue.poll();
            int b = queue.poll();

            int sum = a + b;
            result += sum;

            queue.add(sum);
        }

        System.out.println(result);
    }
}
