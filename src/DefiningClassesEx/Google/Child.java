package DefiningClassesEx.Google;

public class Child {
    private String childName;
    private String birthday;

    public Child(String childName, String birthday) {
        this.childName = childName;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return childName + " " + birthday;
    }
}
