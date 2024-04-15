

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public long count(int[] arr, int mid) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - mid < 0) {
                sum += 0;
            } else sum += arr[i] - mid;
        }
        return sum;
    }

    public int solution(int treeLen, int[] arr) {
        int low = 0;
        int high = Arrays.stream(arr).max().getAsInt();

        while (low <= high) {
            int mid = (low + high) / 2;
            if (count(arr, mid) < treeLen) {
                high = mid - 1;
            } else low = mid + 1;
        }

        return low - 1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int treeNum = kb.nextInt();
        int treeLen = kb.nextInt();
        int[] arr = new int[treeNum];

        for (int i = 0; i < treeNum; i++) arr[i] = kb.nextInt();
        if (arr.length == 1) {
            System.out.println(arr[0] - treeLen);
        } else {
            System.out.println(T.solution(treeLen, arr));
        }


    }
}
