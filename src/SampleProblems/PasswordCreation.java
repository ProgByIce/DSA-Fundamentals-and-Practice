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


class PasswordCreation {

    /*
     * Complete the 'newPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static String newPassword(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            sb.append(a.charAt(i++));
            sb.append(b.charAt(j++));
        }

        if (i < a.length()) {
            sb.append(a.substring(i));
        }
        if (j < b.length()) {
            sb.append(b.substring(j));
        }

        return sb.toString();
    }

}

class PasswordCreationSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        String result = PasswordCreation.newPassword(a, b);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
