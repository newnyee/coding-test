/* 백준 1948 - 임계 경로
 * 위상 정렬
 * */

import java.io.*;
import java.util.*;

public class Q055_임계_경로_구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 갯수
        int m = Integer.parseInt(br.readLine()); // 도로의 갯수

        ArrayList<MyNode>[] A = new ArrayList[n + 1]; // 인접 리스트
        ArrayList<MyNode>[] reverseA = new ArrayList[n + 1]; // 역 인접 리스트
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
            reverseA[i] = new ArrayList<>();
        }

        int[] D = new int[n + 1]; // 진입 차수 배열
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 도로의 출발 도시의 번호
            int e = Integer.parseInt(st.nextToken()); // 도로의 도착 도시의 번호
            int v = Integer.parseInt(st.nextToken()); // 해당 도로를 지나는데 걸리는 시간

            A[s].add(new MyNode(e, v));
            reverseA[e].add(new MyNode(s, v));
            D[e]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCountry = Integer.parseInt(st.nextToken()); // 지도를 그리는 사람들의 출발 도시
        int endCountry = Integer.parseInt(st.nextToken()); // 지도를 그리는 사람들의 도착 도시

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startCountry);
        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (MyNode node : A[now]) {
                int next = node.targetNode;
                D[next]--;
                result[next] = Math.max(result[next], result[now] + node.value);

                if (D[next] == 0) {
                    queue.add(next);
                }
            }

        }

        // 역 위상 정렬
        int count = 0;
        boolean[] visited = new boolean[n + 1];
        queue = new LinkedList<>();
        queue.add(endCountry);
        visited[endCountry] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (MyNode node : reverseA[now]) {
                // 1분도 쉬지 않는 도로 체크
                int next = node.targetNode;
                if (result[next] + node.value == result[now]) {
                    count++;
                    // 중복 카운트 방지를 위해 이미 방문한 적이 있는 노드 제외
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }

        System.out.println(result[endCountry]);
        System.out.println(count);
    }
}

class MyNode {
    int targetNode;
    int value;

    public MyNode(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }
}
