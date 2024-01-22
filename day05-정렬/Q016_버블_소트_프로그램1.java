/* 백준 1377 - 버블 소트 */

import java.util.*;
import java.io.*;

public class Q016_버블_소트_프로그램1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Data[] A = new Data[N];
        for (int i = 0; i < N; i++) {
            A[i] = new Data(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(A);

        int max = 0;
        for (int i = 0; i < N; i++) {
            int move = A[i].index - i;
            if (max < move) {
                max = move;
            }
        }

        System.out.println(max + 1);
    }
}

class Data implements Comparable<Data>{

    int index;
    int value;

    public Data(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Data o) {
        return this.value - o.value; // 양수일 경우 swap
    }
}
