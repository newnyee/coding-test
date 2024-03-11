/* 백준 1916 - 최소 비용 구하기
 * 다익스트라
 * */

import java.io.*;
import java.util.*;

public class Q057_최소_비용_구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node57>[] A = new ArrayList[N + 1]; // 인접 리스트
        int[] D = new int[N + 1]; // 최단 거리 배열
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            D[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 해당 버스의 출발 도시 번호
            int y = Integer.parseInt(st.nextToken()); // 해당 버스의 도착 도시 번호
            int z = Integer.parseInt(st.nextToken()); // 버스 비용

            A[x].add(new Node57(y, z));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node57> queue = new PriorityQueue<>();
        queue.add(new Node57(S, 0));
        D[S] = 0;
        while (!queue.isEmpty()) {
            int nowCity = queue.poll().endCity;
            if (visited[nowCity]) {
                continue;
            }
            visited[nowCity] = true;

            for (Node57 a : A[nowCity]) {
                int nextCity = a.endCity;
                int fare = a.fare;
                if (D[nextCity] > D[nowCity] + fare) {
                    D[nextCity] = D[nowCity] + fare;
                    queue.add(new Node57(nextCity, D[nextCity]));
                }
            }
        }

        System.out.println(D[E]);
    }
}

class Node57 implements Comparable<Node57> {

    int endCity;
    int fare;

    public Node57(int endCity, int fare) {
        this.endCity = endCity;
        this.fare = fare;
    }

    @Override
    public int compareTo(Node57 o) {
        return this.fare > o.fare ? 1 : -1; // 양수일 경우 swap
    }
}
