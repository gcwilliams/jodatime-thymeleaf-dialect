package gwilliams.jodatime.thymeleaf;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.TemplateProcessingParameters;
import org.thymeleaf.context.Context;
import org.thymeleaf.resourceresolver.IResourceResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * The abstract Joda Time dialect test
 *
 */
public abstract class AbstractJodaTimeDialectTest {

    private final TemplateEngine engine = new TemplateEngine();

    /**
     * Default constructor
     * 
     */
    protected AbstractJodaTimeDialectTest() {
        engine.addDialect(new JodaTimeDialect());
    }

    /**
     * Processes the current template using the variables specified
     * 
     * @param variables The varables
     * @return The processed template
     */
    protected String process(Map<String, Object> variables) {
        return engine.process("ignored", new Context(Locale.getDefault(), variables));
    }

    /**
     * Sets the current template
     * 
     * @param template The template
     */
    protected void setTemplate(String template) {
        TemplateResolver resolver = new TemplateResolver();
        resolver.setResourceResolver(new StringResourceResolver(template));
        engine.setTemplateResolver(resolver);
    }

    /**
     * The string resource resolver
     *
     */
    private static class StringResourceResolver implements IResourceResolver {

        private final String resource;

        /**
         * Default constructor
         * 
         * @param resource The resource
         */
        StringResourceResolver(String resource) {
            this.resource = resource;
        }

        /*
         * (non-Javadoc)
         * @see org.thymeleaf.resourceresolver.IResourceResolver#getName()
         */
        @Override
        public String getName() {
            return StringResourceResolver.class.getName();
        }

        /*
         * (non-Javadoc)
         * @see org.thymeleaf.resourceresolver.IResourceResolver#getResourceAsStream(org.thymeleaf.TemplateProcessingParameters, java.lang.String)
         */
        @Override
        public InputStream getResourceAsStream(TemplateProcessingParameters templateProcessingParameters, String resourceName) {

            byte[] bytes;

            try {
                bytes = resource.getBytes("utf-8");
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex);
            }

            return new ByteArrayInputStream(bytes);
        }
    }
}
