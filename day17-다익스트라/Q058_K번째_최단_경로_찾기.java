import java.io.*;
import java.util.*;

public class Q058_K번째_최단_경로_찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 수
        int k = Integer.parseInt(st.nextToken()); // k번째 최단 경로

        ArrayList<Node58>[] A = new ArrayList[n + 1];
        PriorityQueue<Integer>[] distQueue = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
            distQueue[i] = new PriorityQueue<>(k, (o1, o2) -> o1 < o2 ? 1 : -1); // 큐 용량, 내림차순 설정하여 초기화
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            A[a].add(new Node58(b, c));
        }

        PriorityQueue<Node58> queue = new PriorityQueue<>();
        queue.add(new Node58(1, 0)); // 시작 노드 추가
        distQueue[1].add(0);
        while (!queue.isEmpty()) {
            Node58 now = queue.poll();
            int nowCity = now.city;
            int nowFare = now.fare;

            for (Node58 next : A[nowCity]) {
                int nextCity = next.city;
                int nextFare = next.fare;
                if (distQueue[nextCity].size() < k) {
                    distQueue[nextCity].add(nowFare + nextFare);
                    queue.add(new Node58(nextCity, nowFare + nextFare));
                } else if (distQueue[nextCity].size() >= k && distQueue[nextCity].peek() > nowFare + nextFare) {
                    distQueue[nextCity].poll();
                    distQueue[nextCity].add(nowFare + nextFare);
                    queue.add(new Node58(nextCity, nowFare + nextFare));
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            if (distQueue[i].size() == k) {
                bw.write(distQueue[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}

class Node58 implements Comparable<Node58> {
    int city;
    int fare;

    public Node58(int city, int fare) {
        this.city = city;
        this.fare = fare;
    }

    @Override
    public int compareTo(Node58 o) {
        return this.fare > o.fare ? 1 : -1;
    }
}
