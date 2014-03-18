package gwilliams.jodatime.thymeleaf.processors;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * The JodaTime expression object
 *
 */
public class JodaTimeExpressionObject {

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
        return formatter.print(dateTime);
    }
}
