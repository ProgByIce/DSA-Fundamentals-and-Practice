package SampleProblems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class StockPrices {

    /*
     * Complete the 'getTripletCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER d
     */

    public static int getTripletCount(List<Integer> arr, int d) {
        // Write your code here

        int n = arr.size();
        int count = 0;

        for (int j = 1; j < n - 1; j++) {

            // Build frequency map of remainders to the right of j
            Map<Integer, Integer> rightMap = new HashMap<>();
            for (int k = j + 1; k < n; k++) {
                int rem = (arr.get(k) % d);
                rightMap.put(rem, rightMap.getOrDefault(rem, 0) + 1);
            }

            // For each i left of j, check how many k's on the right complete the triplet
            for (int i = 0; i < j; i++) {
                int pairRem = (arr.get(i) + arr.get(j)) % d;
                int need = ((d - pairRem) % d);
                count += rightMap.getOrDefault(need, 0);
            }
        }

        return count;
    }

}

class StockPricesSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int d = Integer.parseInt(bufferedReader.readLine().trim());

        int result = StockPrices.getTripletCount(arr, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
