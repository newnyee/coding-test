/* 백준 1744 - 수 묶기

 * 수를 합 또는 곱을 하여 최댓값을 찾는 문제
 * 1. 양수의 경우 내림차순하여 가장 큰 값들끼리 곱셈하여 합치고
 * 2. 음수의 경우 오름차순하여 가장 작은 값들끼리 곱셈하여 합침
 * 3. 위의 과정에서 남은 값들(곱할 수 없으며 가장 작은 값들)은 그대로 합침
 * */

import java.io.*;
import java.util.*;

public class Q034_수를_묶어서_최댓값_만들기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {

            int x = Integer.parseInt(o1.toString());
            int y = Integer.parseInt(o2.toString());

            // 두 수 모두 0을 포함한 음수일 경우 오름차순 정렬
            if (x <= 0 && y <= 0) {
                return x - y;

            // 나머지의 경우 내림차순 정렬
            } else {
                return y - x;
            }
        });

        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int plus = 0;
        int minus = 0;
        int sum = 0;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            // 양수일 경우 - 직전의 값이 양수로 저장되어있을 경우 두 수를 곱하여 결과값에 합침
            // → 직전 값이 없을경우 저장해놓음
            if (now > 0) {
                if (plus > 0) {
                    if (plus + now > plus * now) { // 더하기의 경우가 곱셈보다 그 수가 큰 경우
                        sum += plus + now;
                    } else {
                        sum += plus * now;
                    }
                    plus = 0;
                } else {
                    plus = now;
                }

            // 음수일 경우 - 직전의 값이 음수로 저장되어있을 경우 두 수를 곱하여 결과값에 합침
            // → 직전 값이 없을경우 저장해놓음
            } else if (now < 0) {
                if (minus < 0) {
                    sum += minus * now;
                    minus = 0;
                } else {
                    minus = now;
                }

            // 0일 경우(큐의 마지막 숫자) - 저장값에 음수가 남아있을 음수를 없애기 위해 0을 곱해줌
            } else {
                if (minus < 0) {
                    minus = 0;
                }
            }
        }

        System.out.println(plus + minus + sum);
    }
}
