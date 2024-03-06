/* 백준 1516 - 게임 개발
 * 위상 정렬
 * */

import java.io.*;
import java.util.*;

public class Q054_게임_개발하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] A = new ArrayList[N + 1]; // 인접 리스트
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        int[] D = new int[N + 1]; // 진입 차수 배열
        int[] buildTime = new int[N + 1]; // 건물 생성 시간
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int now = Integer.parseInt(st.nextToken());
                if (now == -1) {
                    break;
                }
                A[now].add(i);
                D[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (D[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Integer a : A[now]) {
                D[a]--;
                result[a] = Math.max(result[a], result[now] + buildTime[now]);
                if (D[a] == 0) {
                    queue.add(a);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + buildTime[i]);
        }
    }
}