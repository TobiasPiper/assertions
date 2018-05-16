package foo.bar;

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
}