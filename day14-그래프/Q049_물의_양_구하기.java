/* 백준 2251 - 물통
 * 그래프의 표현 (인접 리스트)
 * */

import java.util.*;

public class Q049_물의_양_구하기 {

    static int[] sender = {0, 0, 1, 1, 2, 2,}; // A, A, B, B, C, C
    static int[] receiver = {1, 2, 0, 2, 0, 1}; //B, C, A, C, A, B
    static boolean[][] visited;
    static boolean[] answer; // 정답 배열
    static int[] now;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        now = new int[3];
        now[0] = sc.nextInt(); // A
        now[1] = sc.nextInt(); // B
        now[2] = sc.nextInt(); // C

        visited = new boolean[201][201];
        answer = new boolean[201];
        bfs();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void bfs() {

        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;

            for (int i = 0; i < 6; i++) { // A → B, A → C, B → A, B → C, C → A, C → B
                // 현재 뭍통 값
                int[] next = {A, B, C};

                // 받는 물통에 보내려는 물통의 값을 채워줌
                next[receiver[i]] = next[receiver[i]] + next[sender[i]];
                // 보내려는 물통 값 0으로 업데이트
                next[sender[i]] = 0;

                // 물이 넘칠 때
                if (next[receiver[i]] > now[receiver[i]]) {
                    // 초과하는 만큼 다시 이전 물통에 넣어 줌
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                    // 대상 물통은 최대로 채워 줌
                    next[receiver[i]] = now[receiver[i]];
                }

                // A와 B의 물의 양을 이용해 방문 배열 체크
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));

                    // A의 물의 양이 0일 때 C의 물의 무게를 정답 변수에 저장
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }

    }
}

class AB {

    int A;
    int B;

    public AB(int a, int b) {
        A = a;
        B = b;
    }
}
