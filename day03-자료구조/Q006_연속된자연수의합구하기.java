/* 백준 2018 - 수들의 합 5

count는 1로 초기화 -> 자기 자신의 수(N)

 sum > N : sum -= start, start++
 sum < N : end++, sum += end
 sum == N : end++, sum += end, count++
 */
import java.util.*;

public class Q006_연속된자연수의합구하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 1;
        int count = 1;
        int start = 1;
        int end = 1;

        while (end < N) {

            if (sum > N) {
                sum -= start;
                start++;
            } else if (sum < N) {
                end++;
                sum += end;
            } else {
                end++;
                sum += end;
                count++;
            }
        }

        System.out.println(count);
    }
}
