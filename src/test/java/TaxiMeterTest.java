import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaxiMeterTest {

    private TaxiMeter taxiMeter;

    @Before
    public void setUp() throws Exception {
        taxiMeter = new TaxiMeter();
    }

    @Test
    public void should_charge_6_for_distance_within_2() throws Exception {

        double price = taxiMeter.calculatePrice(2.0, 0);

        assertThat(price,is(6.0));
    }

    @Test
    public void should_charge_more_than_6_with_distance_more_than_2() throws Exception {
        double price = taxiMeter.calculatePrice(3, 0);

        assertThat(price,is(7.0));
    }

    @Test
    public void should_charge_more_than_12_with_distance_9() throws Exception {
        double price = taxiMeter.calculatePrice(9.0, 0);

        assertThat(price,is(12.0));
    }

    @Test
    public void should_charge_7_when_distance_1_stopping_time_4_min() throws Exception {
        double price = taxiMeter.calculatePrice(1.0, 4);

        assertThat(price,is(7.0));
    }

    @Test
    public void should_charge_7_point_8_with_distance_3_stopping_time_4() throws Exception {
        double price = taxiMeter.calculatePrice(3.0, 4);

        assertThat(price,is(8.0));
    }

    @Test
    public void should_charge_more_than_12_with_distance_9_stopping_time_4() throws Exception {
        double price = taxiMeter.calculatePrice(9.0, 4);

        assertThat(price,is(13.0));
    }

    @Test
    public void should_return_8_given_input_of_7_point_8() throws Exception {
        double roundedNum= taxiMeter.round(7.8);
        assertThat(roundedNum,is(8.0));
    }

    @Test
    public void should_return_7_given_input_of_7_point_2() throws Exception {
        double round = taxiMeter.round(7.2);

        assertThat(round,is(7.0));
    }

    @Test
    public void should_return_8_with_distance_4() throws Exception {
        double price = taxiMeter.calculatePrice(4, 0);

        assertThat(price,is(8.0));
    }
}

