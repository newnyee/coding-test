/* 백준 10986 - 나머지 합
* 모든 수에 % 연산이 들어가야하므로
* 미리 합배열 S에 % 연산을 하여 문제를 풀어낸다.
* 원본 배열   -> 1 2 3 1 2
* 합 배열     -> 1 3 6 7 9
* 합 배열 % 3 -> 1 0 0 1 0
*
* 먼저 합배열에서 mod 연산의 결과가 0인 원소들은 구간합이 M으로 나누어 떨어진다는 의미이므로
* 위의 예제에서는 총 구간의 개수중 3개의 구간을 도출해낼 수 있다.
*
* 또한 나머지 구간의 개수는 아래와 같이 도출해낼 수 있다.
* 나머지가 0인것이 3개, 1인것이 2개 이며
* 0인것들 중 2개를 선택하여 빼기 연산을 하게될 경우 그 나머지는 '0이 된다'
* 1인것들 중 2개를 선택하여 빼기 연산을 하게될 경우 그 나머지는 '0이 된다'
* ...
* 여기서 '0이 된다'의 의미는 % 연산 시 나머지가 0으로 떨어진다는 의미이다.
*
* 나머지가 같은수인 원소들을 2개를 선택하는 경우의 수를 구하여 답을 도출할 수 있다.
* 나머지가 같은 수들만 빼기연산을 했을경우 나머지가 0으로 떨어지기 때문이다.
*
* 경우의 수 공식
* nCr = n! / r! / (n-r)!
*
* 이 문제의 경우 r이 2로 고정되어있기 때문에 다음과 같은 공식이 도출된다.
* n * (n-1) / 2
* */
import java.util.*;
import java.io.*;
public class Q05_나머지합구하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long sum = 0;
        long[] modS = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum += Long.parseLong(st.nextToken());
            modS[(int) (sum % M)]++;
        }

        long result = modS[0];

        for (int i = 0; i < M; i++) {
            if (modS[i] >= 2) {
                result += modS[i] * (modS[i] - 1) / 2;
            }
        }

        System.out.println(result);
    }
}
