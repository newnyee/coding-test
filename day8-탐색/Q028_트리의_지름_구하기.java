/* 백준 1167 - 트리의 지름
 * 너비 우선 탐색 */

import java.util.*;

public class Q028_트리의_지름_구하기 {

    static ArrayList<int[]>[] A;
    static boolean[] visitArray;
    static int[] distance;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();

        A = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {

            int now = sc.nextInt();

            while (true) {
                int a = sc.nextInt();
                if (a == -1) {
                    break;
                }
                int b = sc.nextInt();
                A[now].add(new int[]{a, b});
            }
        }

        distance = new int[V + 1];
        visitArray = new boolean[V + 1];
        bfs(1);
        int max = 1;
        for (int i = 2; i <= V; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        distance = new int[V + 1];
        visitArray = new boolean[V + 1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[V]);
    }


    static void bfs(int i) {

        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(i);
        visitArray[i] = true;
        while (!myQueue.isEmpty()) {
            int now = myQueue.poll();
            for (int[] j : A[now]) {
                int a = j[0];
                int b = j[1];
                if (!visitArray[a]) {
                    visitArray[a] = true;
                    myQueue.add(a);
                    distance[a] = distance[now] + b;
                }
            }
        }
    }
}