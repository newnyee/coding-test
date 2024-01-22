/* 백준 11724 - 연결 요소의 개수
* 깊이 우선 탐색 */

import java.io.*;
import java.util.*;

public class Q023_연결_요소의_개수_구하기 {

    static ArrayList<Integer>[] A;
    static boolean[] visitedArray;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트 생성
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        // 인접 리스트 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        // 방문 배열 생성
        visitedArray = new boolean[N + 1];

        // 연결 요소의 개수
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visitedArray[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    static void dfs(int i) {

        if (visitedArray[i]) {
            return;
        }

        visitedArray[i] = true;
        for (Integer j : A[i]) {
            if (visitedArray[j] == false) {
                dfs(j);
            }
        }
    }
}
