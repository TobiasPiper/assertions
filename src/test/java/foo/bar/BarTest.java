package foo.bar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        cut.complicatedCalculation(10000000, 0);
    }

}