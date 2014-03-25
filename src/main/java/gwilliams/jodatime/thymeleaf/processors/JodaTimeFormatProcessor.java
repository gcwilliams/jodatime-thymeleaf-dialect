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