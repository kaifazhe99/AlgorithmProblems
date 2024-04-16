

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public long count(long[] arr, long mid) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] / mid;
        }
        return sum;
    }

    public long solution(int nLineNum, long[] arr, long high) {
        long low = 1;
        long mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (count(arr, mid) < nLineNum) {
                high = mid - 1;
            } else low = mid + 1;
        }

        return low - 1;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int hLineNum = Integer.parseInt(st.nextToken());
        int nLineNum = Integer.parseInt(st.nextToken());
        long[] arr = new long[hLineNum];

        for (int i = 0; i < hLineNum; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        long high = arr[hLineNum-1]+1;


        System.out.println(T.solution(nLineNum, arr, high));


          }
}

