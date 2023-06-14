package FunctionalProgrammingLab;

public class Demo {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4};

        int[] newArray = new int[arr.length];
        for (int i = 0; i < arr.length / 2; i++) {
            int firstElement = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = firstElement;
            newArray = arr;
        }
        for (int num : newArray) {
            System.out.print(num + " ");
        }
    }
}
