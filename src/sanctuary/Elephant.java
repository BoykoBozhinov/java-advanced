package sanctuary;

public class Elephant {
    private String name;
    private int age;
    private String retiredFrom;

    public Elephant(String name, int age, String retiredFrom) {
        setName(name);
        setAge(age);
        setRetiredFrom(retiredFrom);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setRetiredFrom(String retiredFrom) {
        this.retiredFrom = retiredFrom;
    }

    public String getRetiredFrom() {
        return retiredFrom;
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s", getName(), getAge(), getRetiredFrom());
    }
}
