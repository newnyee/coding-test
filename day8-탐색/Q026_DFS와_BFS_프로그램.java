/* 백준 1260 - DFS와 BFS
 * 깊이 우선 탐색, 너비 우선 탐색 */

import java.util.*;
import java.io.*;

public class Q026_DFS와_BFS_프로그램 {

    static ArrayList<Integer>[] A;
    static boolean[] visitedArray;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        visitedArray = new boolean[N + 1];
        dfs(V);
        System.out.println();

        visitedArray = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int i) {

        visitedArray[i] = true;
        System.out.print(i + " ");
        for (Integer a : A[i]) {
            if (!visitedArray[a]) {
                dfs(a);
            }
        }
    }

    static void bfs(int i) {

        Queue<Integer> myQueue = new LinkedList();
        myQueue.add(i);
        visitedArray[i] = true;

        while (!myQueue.isEmpty()) {
            int now = myQueue.poll();
            System.out.print(now + " ");
            for (Integer a : A[now]) {
                if (!visitedArray[a]) {
                    myQueue.add(a);
                    visitedArray[a] = true;
                }
            }
        }
    }
}
