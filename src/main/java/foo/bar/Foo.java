package foo.bar;

public class Foo {

    long divide(final long x, final long y) {
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
