package foo.bar;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FooTestAssertJ {

    public static final Bla LAGAVULIN = new Bla("Lagavulin", 16L);
    public static final Bla BOWMORE = new Bla("Bowmore", 15L);
    public static final Bla TALISKER = new Bla("Talisker", 10L);
    public static final Bla ARDBERG = new Bla("Ardberg", 12L);
    public static final Bla GLEN_GRANT = new Bla("Glen Grant", 18L);
    public static final Bla GLENMORANGIE = new Bla("Glenmorangie", 15L);
    public static final Bla GLENNFIDDICH = new Bla("Glennfiddich", 12L);
    private Foo cut;

    @Before
    public void setup() {
        this.cut = new Foo();
    }

    @Test
    public void testDivide() {
        assertEquals(3, cut.divide(6, 2));
        assertThat(cut.divide(6, 2)).isEqualTo(3L);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByNull() {
        cut.divide(5, 0);
    }

    @Test
    public void testReverse() {
        assertNotNull(cut.reverse("Foo"));
        assertTrue(cut.reverse("Foo").equals("ooF"));

        assertThat(cut.reverse("Foo"))
                .as("Reversing is cool")
                .isNotNull()
                .isNotBlank()
                .startsWith("o")
                .endsWith("ooF")
                .isEqualToIgnoringCase("oof");
    }

    @Test
    public void testList() {
        List<Bla> list = cut.asList(
                LAGAVULIN,
                BOWMORE,
                TALISKER,
                ARDBERG,
                GLEN_GRANT,
                GLENMORANGIE);

        assertThat(list).as("Everyone should have at least 6 whiskeys at home").hasSize(6);
        assertThat(list)
                .extracting("name")
                .contains("Lagavulin", "Bowmore", "Glenmorangie")
                .doesNotContain("Glenfiddich");

        assertThat(list)
                .extracting(Bla::getName)
                .contains("Talisker", "Ardberg", "Glen Grant")
                .doesNotContain("Glenfiddich");

        assertThat(list)
                .filteredOn(bla -> bla.getAge() >= 15L)
                .containsOnly(LAGAVULIN, BOWMORE, GLEN_GRANT, GLENMORANGIE)
                .doesNotContain(GLENNFIDDICH);

    }

    @Test
    public void moreList() {
        BlaAssert.assertThat(LAGAVULIN)
                .hasName("Lagavulin")
                .hasAge(16L);

        BlaAssert.assertThat(TALISKER)
                .hasName("Foo")
                .hasAge(42L);
    }

}