package BOJ_JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ9252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array1 = br.readLine().toCharArray();
        char[] array2 = br.readLine().toCharArray();
        int[][] result = new int[array1.length + 1][array2.length + 1];
        String[][] resultArray = new String[array1.length + 1][array2.length + 1];
        for(int i = 0;i<=array1.length;i++){
            Arrays.fill(resultArray[i],0,resultArray[i].length,"");
        }
        for (int i = 1; i <= array1.length; i++) {
            for (int j = 1; j <= array2.length; j++) {
                if (result[i - 1][j] > result[i][j - 1]) {
                    result[i][j] = result[i - 1][j];
                    resultArray[i][j] = resultArray[i - 1][j];
                } else {
                    result[i][j] = result[i][j - 1];
                    resultArray[i][j] = resultArray[i][j - 1];
                }
                if (array1[i-1] == array2[j-1]) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                    resultArray[i][j] = resultArray[i-1][j-1] + array1[i-1];
                }
            }
        }
        System.out.println(result[array1.length][array2.length]);
        System.out.println(resultArray[array1.length][array2.length]);
    }
}
