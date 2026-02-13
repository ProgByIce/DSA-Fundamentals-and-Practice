package SampleProblems;

import java.util.List;

public class CountElementsGreaterThanPreviousAvg {
    /*
     * Complete the 'countResponseTimeRegressions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY responseTimes as parameter.
     */

    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        int count = 0;
        int sum = 0;

        for (int i = 0; i<responseTimes.size(); i++) {
            if(i>0){
                sum+=responseTimes.get(i-1);
                double avg = (double)sum/i;
                if(responseTimes.get(i) > avg){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> responseTimes = List.of(100, 200, 150, 300);
        int result = countResponseTimeRegressions(responseTimes);
        System.out.println("Number of response time regressions: " + result);
    }
}
