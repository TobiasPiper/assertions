package foo.bar;

import java.util.Arrays;
import java.util.List;

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

    List<Bla> asList(Bla... strings) {
        return Arrays.asList(strings);
    }

}
