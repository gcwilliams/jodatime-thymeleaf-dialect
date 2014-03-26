/*
 * This file is part of Jodatime Thymeleaf Dialect.
 * 
 * Jodatime Thymeleaf Dialect is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Jodatime Thymeleaf Dialect is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Jodatime Thymeleaf Dialect.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package gwilliams.jodatime.thymeleaf.processors;

import gwilliams.jodatime.thymeleaf.AbstractJodaTimeDialectTest;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * The JodaTime format processor tests
 *
 */
public class JodaTimeFormatProcessorTest extends AbstractJodaTimeDialectTest {

    @Test
    public void test_full_date() {
        // arrange
        setTemplate("<span joda:fullDate=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>Saturday, 15 January 2011</span>"));
    }

    @Test
    public void test_full_date_time() {
        // arrange
        setTemplate("<span joda:fullDateTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>Saturday, 15 January 2011 10:30:00 o&#39;clock GMT</span>"));
    }

    @Test
    public void test_full_time() {
        // arrange
        setTemplate("<span joda:fullTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>10:30:00 o&#39;clock GMT</span>"));
    }

    @Test
    public void test_long_date() {
        // arrange
        setTemplate("<span joda:longDate=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15 January 2011</span>"));
    }

    @Test
    public void test_long_date_time() {
        // arrange
        setTemplate("<span joda:longDateTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15 January 2011 10:30:00 GMT</span>"));
    }

    @Test
    public void test_long_time() {
        // arrange
        setTemplate("<span joda:longTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>10:30:00 GMT</span>"));
    }

    @Test
    public void test_medium_date() {
        // arrange
        setTemplate("<span joda:mediumDate=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15-Jan-2011</span>"));
    }

    @Test
    public void test_medium_date_time() {
        // arrange
        setTemplate("<span joda:mediumDateTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15-Jan-2011 10:30:00</span>"));
    }

    @Test
    public void test_medium_time() {
        // arrange
        setTemplate("<span joda:mediumTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>10:30:00</span>"));
    }

    @Test
    public void test_short_date() {
        // arrange
        setTemplate("<span joda:shortDate=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15/01/11</span>"));
    }

    @Test
    public void test_short_date_time() {
        // arrange
        setTemplate("<span joda:shortDateTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15/01/11 10:30</span>"));
    }

    @Test
    public void test_short_time() {
        // arrange
        setTemplate("<span joda:shortDate=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>15/01/11</span>"));
    }

    @Test
    public void test_iso_date_time() {
        // arrange
        setTemplate("<span joda:isoDateTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables);

        // assert
        Assert.assertTrue(result.equals("<span>2011-01-15T10:30:00.000Z</span>"));
    }
    
    @Test
    public void test_full_date_time_french() {
        // arrange
        setTemplate("<span joda:fullDateTime=\"${date}\"></span>");
        Map<String, Object> variables = createVariables();

        // act
        String result = process(variables, Locale.FRANCE);

        // assert
        Assert.assertTrue(result.equals("<span>samedi 15 janvier 2011 10 h 30 GMT</span>"));
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
