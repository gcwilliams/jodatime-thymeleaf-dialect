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

package uk.co.gwilliams.jodatime.thymeleaf.processors;

import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * The JodaTime expression object
 *
 */
public class JodaTimeExpressionObject {

	private final Locale locale;
	
	/**
	 * Default constructor
	 * 
	 * @param locale The current locale
	 */
	public JodaTimeExpressionObject(Locale locale) {
		this.locale = locale;
	}
	
    /**
     * Formats the datetime with a JodaTime full date format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String fullDate(DateTime dateTime) {
        return format(dateTime, DateTimeFormat.fullDate());
    }

    /**
     * Formats the datetime with a JodaTime full date time format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String fullDateTime(DateTime dateTime) {
        return format(dateTime, DateTimeFormat.fullDateTime());
    }

    /**
     * Formats the datetime with a JodaTime full time format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String fullTime(DateTime dateTime) {
        return format(dateTime, DateTimeFormat.fullTime());
    }

    /**
     * Formats the datetime with a JodaTime long date format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String longDate(DateTime dateTime) {
        return format(dateTime, DateTimeFormat.longDate());
    }

    /**
     * Formats the datetime with a JodaTime long date time format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String longDateTime(DateTime dateTime) {
        return format(dateTime, DateTimeFormat.longDateTime());
    }

    /**
     * Formats the datetime with a JodaTime long time format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String longTime(DateTime dateTime) {
        return format(dateTime, DateTimeFormat.longTime());
    }

    /**
     * Formats the datetime with a JodaTime medium date format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String mediumDate(DateTime dateTime) {
        return format(dateTime, DateTimeFormat.mediumDate());
    }

    /**
     * Formats the datetime with a JodaTime medium date time format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String mediumDateTime(DateTime dateTime) {
        return format(dateTime, DateTimeFormat.mediumDateTime());
    }

    /**
     * Formats the datetime with a JodaTime medium time format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String mediumTime(DateTime dateTime) {
        return format(dateTime, DateTimeFormat.mediumTime());
    }

    /**
     * Formats the datetime with a JodaTime short date format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String shortDate(DateTime dateTime) {
        return format(dateTime, DateTimeFormat.shortDate());
    }

    /**
     * Formats the datetime with a JodaTime short date time format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String shortDateTime(DateTime dateTime) {
        return format(dateTime, DateTimeFormat.shortDateTime());
    }

    /**
     * Formats the datetime with a JodaTime short time format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String shortTime(DateTime dateTime) {
        return format(dateTime, DateTimeFormat.shortTime());
    }

    /**
     * Formats the datetime with a JodaTime date time format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String isoDateTime(DateTime dateTime) {
        return format(dateTime, ISODateTimeFormat.dateTime());
    }

    /**
     * Formats the datetime with the specified format
     *
     * @param dateTime The datetime
     * @return The formatted date
     */
    public String format(DateTime dateTime, String format) {
        return format(dateTime, DateTimeFormat.forPattern(format));
    }

    /**
     * Formats the datetime with a JodaTime using the specified date time formatter
     *
     * @param dateTime The datetime
     * @param formatter The formatter
     * @return The formatted date
     */
    private String format(DateTime dateTime, DateTimeFormatter formatter) {
        return formatter.withLocale(locale).print(dateTime);
    }
}
