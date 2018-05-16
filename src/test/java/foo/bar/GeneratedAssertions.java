package foo.bar;

import static foo.bar.Assertions.assertThat;
import static foo.bar.FooTestAssertJ.GLENNFIDDICH;
import static foo.bar.FooTestAssertJ.LAGAVULIN;
import static foo.bar.FooTestAssertJ.TALISKER;

import org.junit.Test;

public class GeneratedAssertions {

    static final Blubb BLUBB_1 = new Blubb("some string", 42L);

    @Test
    public void test() {
        BlaAssert.assertThat(LAGAVULIN)
                .hasName("Lagavulin")
                .hasAge(16L);

        BlaAssert.assertThat(TALISKER)
                .hasName("Foo")
                .hasAge(42L);


        assertThat(GLENNFIDDICH)
                .hasName("Glennfiddich")
                .hasAge(12L);

        assertThat(BLUBB_1)
                .hasMyProperty("some string")
                .hasAnotherProperty(4711L);
    }
}
