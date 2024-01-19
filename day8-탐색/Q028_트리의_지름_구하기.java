/* 백준 1167 - 트리의 지름
 * 깊이 우선 탐색 */

import java.io.*;
import java.util.*;

public class Q028_트리의_지름_구하기 {

    static ArrayList<int[]>[] A;
    static boolean[] visitArray;
    static int diameter = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        A = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            A[now] = new ArrayList<>();
            while (st.countTokens() > 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                A[i].add(new int[]{a, b});
            }
        }

        if (V == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i <= V; i++) {
            visitArray = new boolean[V + 1];
            dfs(i, 0);
        }
        System.out.println(diameter);
    }

    static void dfs(int i, int count) {

        visitArray[i] = true;
        for (int[] a : A[i]) {
            if (!visitArray[a[0]]) {
                dfs(a[0], count + a[1]);
            } else {
                if (count > diameter) {
                    diameter = count;
                }
            }
        }
    }
}
