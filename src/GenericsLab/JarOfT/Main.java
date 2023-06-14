package GenericsLab.JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<String> myJar = new Jar<>();

        myJar.add("Manchester United");
        myJar.add("Barcelona");
        System.out.println(myJar.remove());
    }
}
