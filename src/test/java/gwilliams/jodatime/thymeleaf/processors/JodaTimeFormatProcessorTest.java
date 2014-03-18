package gwilliams.jodatime.thymeleaf.processors;

import gwilliams.jodatime.thymeleaf.AbstractJodaTimeDialectTest;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * The JodaTime format processor tests
 *
 */
public class JodaTimeFormatProcessorTest extends AbstractJodaTimeDialectTest {

    @Test
    public void test_full_date() {
        // arrange
        setTemplate("<span jt:fullDate=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>Saturday, 15 January 2011</span>"));
    }

    @Test
    public void test_full_date_time() {
        // arrange
        setTemplate("<span jt:fullDateTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>Saturday, 15 January 2011 10:30:00 o&#39;clock GMT</span>"));
    }

    @Test
    public void test_full_time() {
        // arrange
        setTemplate("<span jt:fullTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>10:30:00 o&#39;clock GMT</span>"));
    }

    @Test
    public void test_long_date() {
        // arrange
        setTemplate("<span jt:longDate=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15 January 2011</span>"));
    }

    @Test
    public void test_long_date_time() {
        // arrange
        setTemplate("<span jt:longDateTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15 January 2011 10:30:00 GMT</span>"));
    }

    @Test
    public void test_long_time() {
        // arrange
        setTemplate("<span jt:longTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>10:30:00 GMT</span>"));
    }

    @Test
    public void test_medium_date() {
        // arrange
        setTemplate("<span jt:mediumDate=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15-Jan-2011</span>"));
    }

    @Test
    public void test_medium_date_time() {
        // arrange
        setTemplate("<span jt:mediumDateTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15-Jan-2011 10:30:00</span>"));
    }

    @Test
    public void test_medium_time() {
        // arrange
        setTemplate("<span jt:mediumTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>10:30:00</span>"));
    }

    @Test
    public void test_short_date() {
        // arrange
        setTemplate("<span jt:shortDate=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15/01/11</span>"));
    }

    @Test
    public void test_short_date_time() {
        // arrange
        setTemplate("<span jt:shortDateTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15/01/11 10:30</span>"));
    }

    @Test
    public void test_short_time() {
        // arrange
        setTemplate("<span jt:shortDate=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15/01/11</span>"));
    }

    @Test
    public void test_iso_date_time() {
        // arrange
        setTemplate("<span jt:isoDateTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>2011-01-15T10:30:00.000Z</span>"));
    }

    /**
     * Create a variables map
     *
     * @return The map of variables
     */
    private static Map<String, Object> createVariables() {
        DateTime dateTime = new DateTime(2011, 1, 15, 10, 30);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("date", dateTime);
        return  variables;
    }
}