// 백준 1546 - 평균
import java.util.Scanner;

public class Q02_평균구하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = 0;
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(sc.next());
            if (M < num) {
                M = num;
            }
            sum += num;
        }

        System.out.println(sum*100.0/M/N);
    }
}
