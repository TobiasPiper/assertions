package foo.bar;

import static foo.bar.Assertions.assertThat;
import static foo.bar.FooTestAssertJ.GLENNFIDDICH;
import static foo.bar.FooTestAssertJ.LAGAVULIN;
import static foo.bar.FooTestAssertJ.TALISKER;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class GeneratedAssertions {

    static final Blubb BLUBB_1 = new Blubb("some string", 42L);

    @Test
    public void custom() {
        // Custom with Generated Assertions
        CustomSoftAssertions.assertSoftlyCustom(softly -> {
            softly.assertThat(LAGAVULIN)
                    .hasName("Lagavulin")
                    .hasAge(16L);

            softly.assertThat(TALISKER)
                    .hasName("Foo")
                    .hasAge(42L);

            softly.assertThat(GLENNFIDDICH)
                    .hasName("Glennfiddich")
                    .hasAge(12L);

            softly.assertThat(BLUBB_1)
                    .hasMyProperty("some string")
                    .hasAnotherProperty(4711L);
        });
    }

    @Test
    public void standardJava8() {
        // Standard Soft assertions
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(LAGAVULIN.getName()).isEqualTo("Lagavulin");
            softly.assertThat(LAGAVULIN.getAge()).isEqualTo(16L);

            softly.assertThat(TALISKER.getName()).isEqualTo("Foo");
            softly.assertThat(TALISKER.getAge()).isEqualTo(42L);

            softly.assertThat(GLENNFIDDICH.getName()).isEqualTo("Glennfiddich");
            softly.assertThat(GLENNFIDDICH.getAge()).isEqualTo(12L);

            softly.assertThat(BLUBB_1.getMyProperty()).isEqualTo("some string");
            softly.assertThat(BLUBB_1.getAnotherProperty()).isEqualTo(4711L);
        });
    }
}
