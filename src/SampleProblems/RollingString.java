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



class RollingString {

    /*
     * Complete the 'rollingString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING_ARRAY operations
     */

    public static String rollingString(String s, List<String> operations) {
        // Write your code here

        char[] chars = s.toCharArray();

        for (String op : operations) {

            String[] opComponents = op.split(" ");
            int i = Integer.parseInt(opComponents[0]);
            int j = Integer.parseInt(opComponents[1]);
            char direction = opComponents[2].charAt(0);

            for (int k = i; k <= j; k++) {
                if (direction == 'R') {
                    chars[k] = (chars[k] == 'z') ? 'a' : (char)(chars[k] + 1);
                } else {
                    chars[k] = (chars[k] == 'a') ? 'z' : (char)(chars[k] - 1);
                }
            }
        }

        return new String(chars);
    }

}

class RollingStringSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        int operationsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> operations = IntStream.range(0, operationsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        String result = RollingString.rollingString(s, operations);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
