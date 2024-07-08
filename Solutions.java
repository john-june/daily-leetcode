import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solutions {

    public static void main(String[] args) {
        new Solutions().test();
    }

    private void test() {
//        int[] nums = {2, 0, 0};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        int[][] inputArr = formatArrFromString("[[0, 0, 3, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]");
        String resArr = Arrays.deepToString(inputArr);
        System.out.println(resArr);

    }

    private int[][] formatArrFromString(String s) {
        Pattern compile = Pattern.compile("\\d{1,}");
        Matcher matcher = compile.matcher(s);
        int idxNums2Len = s.indexOf("]");
        int divArrLen = -1;
        ArrayList<Integer> all = new ArrayList<>();
        while (matcher.find()) {
            String group = matcher.group();
            if (matcher.start() > idxNums2Len && divArrLen == -1) {
                divArrLen = all.size();
            }
            all.add(Integer.parseInt(group));
        }

        if (divArrLen == -1) {
            throw new RuntimeException("Invalid len of num2");
        }
        int[][] res = new int[all.size() / divArrLen][divArrLen];
        int allIndex = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < divArrLen; j++) {
                res[i][j] = all.get(allIndex++);
            }
        }
        System.out.println("Input: " + Arrays.deepToString(res));
        return res;
    }

}
