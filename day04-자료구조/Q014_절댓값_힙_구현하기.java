

/* 백준 11286 - 절댓값 힙
*
* N = 연산의 개수
* 주어지는 값이 0이 아닌경우 그 값을 배열에 추가
* 주어지는 값이 0인경우 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
*
* */

import java.io.*;
import java.util.*;

public class Q014_절댓값_힙_구현하기 {

    /*public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> plus = new PriorityQueue<>();
        PriorityQueue<Long> minus = new PriorityQueue<>(Collections.reverseOrder());

        Long N = Long.parseLong(br.readLine());

        for (Long i = 0L; i < N; i++) {

            Long x = Long.parseLong(br.readLine());
            if (x != 0) {
                if (x > 0) {
                    plus.add(x);
                } else {
                    minus.add(x);
                }

            } else {
                if (plus.isEmpty() && minus.isEmpty()) {
                    System.out.println("0");
                } else {
                    if (plus.isEmpty()) {
                        System.out.println(minus.poll());
                    } else if (minus.isEmpty()) {
                        System.out.println(plus.poll());
                    } else {
                        if (Math.abs(plus.peek()) < Math.abs(minus.peek())) {
                            System.out.println(plus.poll());
                        } else {
                            System.out.println(minus.poll());
                        }
                    }
                }
            }
        }
    }*/

    // 다른 풀이
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> {
            /*
            비교할 객체 두개를 선언 (o1, o2)
            우선순위 큐의 경우 익명함수로 정렬 기준 변경의 경우 아래의 기준을 따름

            리턴값 양수 -> o1과 o2를 swap함
            리턴값 음수 -> o1과 o2를 swap하지 않음
             */

            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);

            // 절댓값이 같은 경우 음수 우선
            if (firstAbs == secondAbs) {
                return o1 > o2 ? 1 : -1;

            // 절댓값이 작은 데이터 우선
            } else {
                return firstAbs - secondAbs;
            }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (MyQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(MyQueue.poll());
                }
            } else {
                MyQueue.add(x);
            }
        }
    }
}
