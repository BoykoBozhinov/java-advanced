package vetClinic;

public class Pet {
    private String name;
    private int age;
    private String owner;

    public Pet(String name, int age, String owner) {
        setName(name);
        setAge(age);
        setOwner(owner);
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

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", getName(), getAge(), getOwner());
    }
}
