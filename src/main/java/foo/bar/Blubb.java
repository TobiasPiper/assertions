package foo.bar;

import java.util.Objects;

public class Blubb {
    private final String myProperty;
    private final long anotherProperty;

    public Blubb(final String myProperty, final long anotherProperty) {
        this.myProperty = myProperty;
        this.anotherProperty = anotherProperty;
    }

    public String getMyProperty() {
        return myProperty;
    }

    public long getAnotherProperty() {
        return anotherProperty;
    }

    @Override
    public String toString() {
        return "Blubb{" +
                "myProperty='" + myProperty + '\'' +
                ", anotherProperty=" + anotherProperty +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final Blubb blubb = (Blubb)o;
        return anotherProperty == blubb.anotherProperty &&
                Objects.equals(myProperty, blubb.myProperty);
    }

    @Override
    public int hashCode() {

        return Objects.hash(myProperty, anotherProperty);
    }
}
