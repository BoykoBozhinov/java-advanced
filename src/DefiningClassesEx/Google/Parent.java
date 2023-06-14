package DefiningClassesEx.Google;

public class Parent {
    private String parentName;
    private String birthday;

    public Parent(String parentName, String birthday) {
        this.parentName = parentName;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return parentName + " " + birthday;
    }
}
