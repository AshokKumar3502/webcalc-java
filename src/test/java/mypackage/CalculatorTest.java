package mypackage;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void twoAndThreeIsFive() throws Exception {
        final long result = new Calculator().addFucn(2, 3);
        assertThat(result, is(5L));
       //assertThat(result, is(6L));
    }

    @Test
    public void threeMinusTwoIsOne() throws Exception {
        final long result = new Calculator().subFucn(3, 2);
        assertThat(result, is(1L));
        // assertThat(result, is(2L));
    }
    
    @Test
    public void threeXThreeIsNine() throws Exception {
        final long result = new Calculator().mulFucn(3, 3);
        assertThat(result, is(9L));
        //assertThat(result, is(8L));
    }
}

