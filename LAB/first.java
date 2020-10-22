import java.util.*;

public class first {
    public static void main(String[] args) throws Exception {
        int[] original_arr = { 0, 2, 5, 0, 2, 0, 0, 2, 3, 5, 8, 0, 5, 0 };
        int i = 0;
        System.out.print("\nArray Before: \n");
        for (int n : original_arr)
            System.out.print(n + " ");

        for (int j = 0, l = original_arr.length; j < l;) {
            if (original_arr[j] == 0)
                j++;
            else {
                int temp = original_arr[i];
                original_arr[i] = original_arr[j];
                original_arr[j] = temp;
                i++;
                j++;
            }
        }
        while (i < original_arr.length)
            original_arr[i++] = 0;
        System.out.print("\n\nArray After: \n");
        for (int n : original_arr)
            System.out.print(n + " ");
        System.out.print("\n");
    }
}
