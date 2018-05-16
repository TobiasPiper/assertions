package foo.bar;

public class Bar {

    private final Foo foo;

    public Bar(Foo foo) {
        this.foo = foo;
    }

    public long complicatedCalculation(final long x, final long y) {
        long result;

        result = foo.divide(x, x);

        result += foo.divide(x, y);

        return result;
    }
}