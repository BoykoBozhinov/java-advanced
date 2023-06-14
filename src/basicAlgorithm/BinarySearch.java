package basicAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static void binarySearch(int v[], int To_Find) {
        int lo = 0, hi = v.length - 1;
        // This below check covers all cases , so need to check
        // for mid=lo-(hi-lo)/2
        while (hi - lo > 1) {
            int mid = (hi + lo) / 2;
            if (v[mid] < To_Find) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (v[lo] == To_Find) {
            System.out.println(lo);
        } else if (v[hi] == To_Find) {
            System.out.println(hi);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] v = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

      /* List<ArrayList<Integer>> v = new ArrayList<>();
      v.add(new ArrayList<Integer>(Arrays.asList( 1, 3, 4, 5, 6 )));*/
        int To_Find = 1;
        binarySearch(v, To_Find);
        To_Find = 6;
        binarySearch(v, To_Find);
        To_Find = 10;
        binarySearch(v, To_Find);
    }
}