import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public String solution(long[] cardArr, long[] findArr) {


        StringBuilder sb = new StringBuilder();
        Arrays.sort(cardArr);
        int upperLow = 0;
        int upperHigh = 0;
        int lowerLow = 0;
        int lowerHigh = 0;



        for (int i = 0; i < findArr.length; i++) {
            upperLow = 0;
            upperHigh = cardArr.length;
            int upperMid = 0;


                while (upperLow < upperHigh) {
                    upperMid = (upperLow + upperHigh) / 2;
                    if (cardArr[upperMid] <= findArr[i])
                    // 현위치가 target보다 작음 -> 후보군도 아님 -> 왼쪽 원소들과 현위치는 검사할 필요도 없음
                    {
                        upperLow = upperMid + 1;
                    } else // arr[mid] > target (upper bound의 후보군이 되는 위치임)
                    {
                        upperHigh = upperMid;
                    }
                }
                lowerLow = 0;
                lowerHigh = cardArr.length ;
                int lowerMid = 0;
                while (lowerLow < lowerHigh) {
                    lowerMid = (lowerLow + lowerHigh) / 2;
                    if (cardArr[lowerMid] < findArr[i])
                    // 현위치가 target보다 작음 -> 왼쪽 원소들과 현위치는 검사할 필요도 없음
                    {
                        lowerLow = lowerMid + 1;
                    } else // arr[mid] >= target (lower bound의 후보군이 되는 위치임)
                    {
                        lowerHigh = lowerMid;
                    }

                }
                sb.append(upperLow - lowerLow + " ");



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
