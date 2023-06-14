package GenericsLab.GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(5,7);
        System.out.println(scale.getHeavier());

        Scale<String> stringScale = new Scale<>("A", "C");
        System.out.println(stringScale.getHeavier());
    }
}
