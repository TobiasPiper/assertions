package foo.bar;

public class Foo {

    double divide(final double x, final double y) {
        return x / y;
    }

    String reverse(final String value) {
        byte[] bytes = value.getBytes();
        byte[] result = new byte[bytes.length];
        for (int i = bytes.length - 1, k = 0; i >= 0; i--, k++) {
            result[k] = bytes[i];
        }
        return new String(result);
    }

}
