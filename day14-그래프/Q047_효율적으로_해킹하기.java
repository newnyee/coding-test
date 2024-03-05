/* 백준 1325 - 효율적인 해킹
 * 그래프의 표현 (인접 리스트)
 * */

import java.io.*;
import java.util.*;

public class Q047_효율적으로_해킹하기 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
        }

        B = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if(B[i] > max) {
                max = B[i];
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            if (B[i] == max) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(int a) {

        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(a);
        visited[a] = true;

        while (!myQueue.isEmpty()) {
            int x = myQueue.poll();
            for (Integer y : A[x]) {
                if (!visited[y]) {
                    myQueue.add(y);
                    visited[y] = true;
                    B[y]++;
                }
            }
        }
    }
}
