import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long low = 1;

    	long high = (long) times[times.length-1]*n;
    	long mid = 0;
    	long sum;
    	long answer = high;

    	while(low <= high) {
    		sum = 0;
    		mid = (low + high) / 2;

    		for(int time : times) {
    			sum += mid / time;
    		}

    		if(sum >= n) {
				answer = mid;
				high = mid - 1;
    		}
    		else {
    			low = mid + 1;
    		}
    	}


        return answer;
    }
}