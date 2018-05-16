package foo.bar;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
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
        assertThat(cut.divide(6L, 2L), is(3L));
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

}