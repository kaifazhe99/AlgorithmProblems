import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public String solution(long[] cardArr, long[] findArr) {


        StringBuilder sb = new StringBuilder();
        Arrays.sort(cardArr);

        int low = 0;
        int high = cardArr.length;
        int mid = (low + high) / 2;


        for (int i = 0; i < findArr.length; i++) {
            low = 0;
            high = cardArr.length;

            while (low < high) {
                mid = (low + high) / 2;
                if (cardArr[mid] < findArr[i]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if (low > cardArr.length - 1) {
                sb.append("0" + "\n");
            } else if (cardArr[low] == findArr[i]) {
                sb.append("1" + "\n");
            } else {
                sb.append("0" + "\n");
            }


        }

        String result = sb.toString();

        return result;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long[] cardArr = new long[N];
        for (int i = 0; i < N; i++) cardArr[i] = Integer.parseInt(st.nextToken());


        int K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        long[] findArr = new long[K];
        for (int i = 0; i < K; i++) findArr[i] = Integer.parseInt(st.nextToken());


        System.out.println(T.solution(cardArr, findArr));


    }
}
