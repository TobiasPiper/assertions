package foo.bar;

import java.util.function.Consumer;

import org.assertj.core.api.SoftAssertions;

public class CustomSoftAssertions extends SoftAssertions {

    public BlaAssert assertThat(Bla actual) {
        return proxy(BlaAssert.class, Bla.class, actual);
    }

    public BlubbAssert assertThat(Blubb actual) {
        return proxy(BlubbAssert.class, Blubb.class, actual);
    }

    public static void assertSoftlyCustom(Consumer<CustomSoftAssertions> softly) {
        CustomSoftAssertions assertions = new CustomSoftAssertions();
        softly.accept(assertions);
        assertions.assertAll();
    }

    // additional custom assertions as desired.
}
