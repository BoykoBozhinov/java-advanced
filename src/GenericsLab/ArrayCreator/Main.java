package GenericsLab.ArrayCreator;

public class Main {
    public static void main(String[] args) {
        String[] random = ArrayCreator.create(5,"Boxing");
        Integer[] number = ArrayCreator.create(Integer.class,7,7);

        for (String r:random) {
            System.out.print(r + " ");
        }

        System.out.println();

        for (Integer n:number) {
            System.out.print(n + " ");
        }
    }
}
