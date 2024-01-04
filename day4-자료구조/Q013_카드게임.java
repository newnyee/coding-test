/* 백준 2164 - 카드2
 *
 * N = 카드의 수
 * 카드가 위에서 아래로 오름차순의 형태로 쌓여있음
 *
 * 큐(Queue) 사용
 * 맨 위의 카드를 poll -> 맨 위의 카드를 poll, poll한 카드번호를 add -> 반복
 * 마지막 한장 남았을 때 그 카드의 번호를 출력
 * */

import java.util.*;

public class Q013_카드게임 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> myQueue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            myQueue.add(i);
        }

        while (myQueue.size() > 1) {
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }

        System.out.println(myQueue.peek());
    }
}
