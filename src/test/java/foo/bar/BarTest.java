package foo.bar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BarTest {

    @Spy
    private Foo mockFoo;

    @InjectMocks
    private Bar cut;

    @Test
    public void test() {
        assertThat(cut.complicatedCalculation(10, 5), is(3L));
        verify(mockFoo, times(2)).divide(anyLong(), anyLong());
    }

    @Test
    public void testDivisionByZero() {
        try {
            cut.complicatedCalculation(10000000, 0);
            fail("Should have thrown ArthititmeticExcpetndf");
        }
        catch (ArithmeticException e) {
            // success
        }
        verify(mockFoo, times(2)).divide(anyLong(), anyLong());
    }

    @Test
    public void testDivisionByZero2() {
        try {
            cut.complicatedCalculation(0, 5);
            fail("Should have thrown ArthititmeticExcpetndf");
        }
        catch (ArithmeticException e) {
            // success
        }
        verify(mockFoo, times(2)).divide(anyLong(), anyLong());
    }

    @Test
    public void testDivisionByZero3() {
        try {
            cut.complicatedCalculation(0, 0);
            fail("Should have thrown ArthititmeticExcpetndf");
        }
        catch (ArithmeticException e) {
            // success
        }
        verify(mockFoo, times(1)).divide(anyLong(), anyLong());
    }

}