package DefiningClassesEx.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Parent> parent;
    private List<Child> child;
    private List<Pokemon> pokemon;

    public Person() {
        this.pokemon = new ArrayList<>();
        this.parent = new ArrayList<>();
        this.child = new ArrayList<>();
    }


    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemon() {
        return this.pokemon;
    }

    public List<Parent> getParent() {
        return this.parent;
    }

    public List<Child> getChild() {
        return this.child;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Company:").append(System.lineSeparator());
        if (company != null) {
            builder.append(company.toString()).append(System.lineSeparator());
        }

        builder.append("Car:").append(System.lineSeparator());
        if (car != null) {
            builder.append(car.toString()).append(System.lineSeparator());
        }

        builder.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemon) {
            builder.append(pokemon.toString()).append(System.lineSeparator());
        }
        builder.append("Parents:").append(System.lineSeparator());
        for (Parent parent : parent) {
            builder.append(parent.toString()).append(System.lineSeparator());
        }

        builder.append("Children:").append(System.lineSeparator());
        for (Child child : child) {
            builder.append(child.toString()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
