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

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.thymeleaf.Arguments;
import org.thymeleaf.Configuration;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;

/**
 * The JodaTime format processor
 *
 */
public class JodaTimeFormatProcessor extends AbstractTextChildModifierAttrProcessor {

    private static final String EMPTY = "";

    private final DateTimeFormatter formatter;

    /**
     * Default constructor
     *
     * @param attrName The attribute name
     * @param formatter The date time formatter
     */
    public JodaTimeFormatProcessor(String attrName, DateTimeFormatter formatter) {
        super(attrName);
        this.formatter = formatter;
    }

    /*
     * (non-Javadoc)
     * @see org.thymeleaf.processor.AbstractProcessor#getPrecedence()
     */
    @Override
    public int getPrecedence() {
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor#getText(org.thymeleaf.Arguments, org.thymeleaf.dom.Element, java.lang.String)
     */
    @Override
    protected String getText(Arguments arguments, Element element, String attributeName) {

        final String attributeValue = element.getAttributeValue(attributeName);

        final Configuration configuration = arguments.getConfiguration();

        IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);
        final IStandardExpression expression = parser.parseExpression(configuration, arguments, attributeValue);

        Object result = expression.execute(configuration, arguments);
        
        DateTimeFormatter localFormatter = formatter.withLocale(arguments.getContext().getLocale());

        return result instanceof DateTime ? localFormatter.print((DateTime) result) : EMPTY;
    }
}