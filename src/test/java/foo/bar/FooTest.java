package foo.bar;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;

public class FooTest {

    private Foo cut;

    @Before
    public void setup() {
        this.cut = new Foo();
    }

    @Test
    public void testDivide() {
        assertEquals(3, cut.divide(6, 2));
        assertThat(cut.divide(6, 2), is(3));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByNull() {
        cut.divide(5, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByAnotherNull() {
        cut.divide(5, 7);
        cut.divide(5, 3);
        cut.divide(5, 2);
    }

    @Test
    public void testReverse() {
        assertNotNull(cut.reverse("Foo"));
        assertTrue(cut.reverse("Foo").equals("ooF"));

        assertThat(cut.reverse("Foo"), is(not(nullValue())));
        assertThat(cut.reverse("Foo"), is("ooF"));
    }

    @Test
    public void testList() {
        List<Bla> list = cut.asList(
                new Bla("Lagavulin", 16L),
                new Bla("Bowmore", 15L),
                new Bla("Talisker", 10L),
                new Bla("Ardberg", 12L),
                new Bla("Glen Grant", 18L),
                new Bla("Glenmorangie", 15L));

        assertThat(list, not(empty()));
        assertThat(list, hasSize(6));
        assertThat(list, contains(
                hasProperty("name", is("Lagavulin")),
                hasProperty("name", is("Bowmore")),
                hasProperty("name", is("Talisker")),
                hasProperty("age", is(12L)),
                hasProperty("name", is("Glen Grant")),
                hasProperty("name", is("Glenmorangie"))
        ));
        assertThat(list, containsInAnyOrder(
                hasProperty("name", is("Bowmore")),
                hasProperty("name", is("Lagavulin")),
                hasProperty("name", is("Talisker")),
                hasProperty("name", is("Glen Grant")),
                hasProperty("name", is("Glenmorangie")),
                hasProperty("age", is(12L))
        ));
    }


}