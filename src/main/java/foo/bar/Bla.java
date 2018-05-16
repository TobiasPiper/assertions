package foo.bar;

import java.util.Objects;

public class Bla {
    private final String name;
    private final Long age;

    public Bla(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bla bla = (Bla) o;
        return Objects.equals(name, bla.name) &&
                Objects.equals(age, bla.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}