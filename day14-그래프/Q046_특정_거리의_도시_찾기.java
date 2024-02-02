/* 백준 18352 - 특정 거리의 도시 찾기
 * 그래프의 표현 (인접 리스트)
 * */

import java.io.*;
import java.util.*;

public class Q046_특정_거리의_도시_찾기 {

    static ArrayList<Integer>[] A;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b); // 단방향 그래프
        }

        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }
        bfs(X);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == K) {
                bw.write(i + "\n");
                count++;
            }
        }

        if (count == 0) {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(int s) {

        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(s);
        visited[s]++;

        while (!myQueue.isEmpty()) {
            int now = myQueue.poll();
            for (Integer a : A[now]) {
                if (visited[a] == -1) {
                    visited[a] = visited[now] + 1;
                    myQueue.add(a);
                }
            }
        }
    }
}
