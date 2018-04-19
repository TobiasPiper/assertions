package foo.bar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FooTest {

    private Foo cut;

    @Before
    public void setup() {
        this.cut = new Foo();
    }

    @Test
    public void testDivide() {
        assertEquals(3d, cut.divide(6d, 2d), 0d);
    }

    @Test
    public void testReverse() {
        assertNotNull(cut.reverse("Foo"));
        assertTrue(cut.reverse("Foo").equals("ooF"));
    }

}