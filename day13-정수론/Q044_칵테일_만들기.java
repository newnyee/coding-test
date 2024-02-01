/* 백준 1033 - 칵테일 만들기
 * 유클리드 호제법, 깊이 우선 탐색
 * */

import java.io.*;
import java.util.*;

public class Q044_칵테일_만들기 {

    static ArrayList<Node>[] A;
    static boolean[] visited;
    static long lcm = 1; // 최소 공배수
    static long[] D;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        A = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList();
        }

        visited = new boolean[N];
        for (int i = 1; i < N; i++) {
            int a = sc.nextInt(); // 인덱스
            int b = sc.nextInt(); // 인접노드
            int p = sc.nextInt();
            int q = sc.nextInt();

            A[a].add(new Node(b, p, q));
            A[b].add(new Node(a, q, p));
            // 전체 재료들의 최소 공배수를 찾아냄
            lcm *= (p * q / gcd(p, q));
        }

        D = new long[N];
        // 최소 공배수를 시작점에 입력
        D[0] = lcm;
        // 임의의 점 0을 시작점으로 선정하여 깊이 우선 탐색함
        dfs(0);

        // dfs를 이용해 업데이트 된 D 배열의 값들로 최대 공약수 계산하기
        long mgcd = D[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }

        // 각각의 값에서 최대 공약수를 제거한 값 출력
        for (int i = 0; i < N; i++) {
            System.out.print(D[i] / mgcd + " ");
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void dfs(int a) {
        visited[a] = true;
        for (Node node : A[a]) {
            int b = node.getB();
            if (!visited[b]) {
                // 최소 공배수를 비율대로 저장함
                D[b] = D[a] * node.getQ() / node.getP();
                dfs(b);
            }
        }
    }
}

class Node {

    int b;
    int p;
    int q;

    public Node(int b, int p, int q) {
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}
