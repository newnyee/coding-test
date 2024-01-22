/* 백준 13023 - ABCDE
 * 깊이 우선 탐색 */

import java.io.*;
import java.util.*;

public class Q025_친구_관계_파악하기 {

    public static ArrayList<Integer>[] A;
    public static boolean[] visitedArray;
    public static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        visitedArray = new boolean[N];
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (result == 1) {
                System.out.println(result);
                return;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int i, int depth) {

        if (depth == 5) {
            result = 1;
            return;
        }

        visitedArray[i] = true;
        for (Integer j : A[i]) {
            if (!visitedArray[j]) {
                dfs(j, depth + 1);
            }
        }
        visitedArray[i] = false;
    }
}
