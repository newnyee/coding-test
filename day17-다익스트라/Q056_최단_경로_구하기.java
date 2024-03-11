/* 백준 1753 - 최단 경로
 * 다익스트라
 * */

import java.io.*;
import java.util.*;

public class Q056_최단_경로_구하기 {

    /*public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int K = Integer.parseInt(br.readLine()); // 시작 정점 번호

        ArrayList<Node56>[] A = new ArrayList[V + 1]; // 인접 리스트
        int[] D = new int[V + 1]; // 최단 거리 배열
        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
            D[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 엣지 시작 노드
            int v = Integer.parseInt(st.nextToken()); // 엣지 끝 노드
            int w = Integer.parseInt(st.nextToken()); // 엣지 가중치

            A[u].add(new Node56(v, w));
        }

        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node56> queue = new PriorityQueue<>();
        queue.add(new Node56(K, 0));
        D[K] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll().v;
            visited[now] = true;
            for (Node56 a : A[now]) {
                int next = a.v;
                D[next] = Math.min(D[now] + a.value, D[next]);
                if (!visited[next]) {
                    a.setValue(D[next]);
                    queue.add(a);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                bw.write(D[i] + "\n");
            } else {
                bw.write("INF" + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int K = Integer.parseInt(br.readLine()); // 시작 정점 번호

        ArrayList<Node56>[] A = new ArrayList[V + 1]; // 인접 리스트
        int[] D = new int[V + 1]; // 최단 거리 배열
        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
            D[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 엣지 시작 노드
            int v = Integer.parseInt(st.nextToken()); // 엣지 끝 노드
            int w = Integer.parseInt(st.nextToken()); // 엣지 가중치

            A[u].add(new Node56(v, w));
        }

        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node56> queue = new PriorityQueue<>();
        queue.add(new Node56(K, 0));
        D[K] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll().v;
            if (visited[now]) {
                continue;
            }
            visited[now] = true;

            for (Node56 a : A[now]) {
                int next = a.v;
                int value = a.value;
                if (D[next] > D[now] + value) { // 최소 거리로 업데이트
                    D[next] = D[now] + value;
                    queue.add(new Node56(next, D[next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(D[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}


class Node56 implements Comparable<Node56>{

    int v;
    int value;

    public Node56(int v, int value) {
        this.v = v;
        this.value = value;
    }

    @Override
    public int compareTo(Node56 o) {
        if (this.value > o.value) {
            return 1;
        }
        return -1;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
