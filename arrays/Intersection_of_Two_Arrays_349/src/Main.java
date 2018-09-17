import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        var solution = new Solution();

        var arr1 = new int[]{9,4,9,8,4};
        var arr2 = new int[]{4,9,5};

        var result = solution.intersection(arr1, arr2);

        for (int i = 0; i < result.length; i++){
            System.out.print(result[i]);

        }

    }
}
