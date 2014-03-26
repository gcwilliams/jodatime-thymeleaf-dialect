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
     * Processes the current template using the variables specified in UK locale
     * 
     * @param variables The variables
     * @return The processed template
     */
    protected String process(Map<String, Object> variables) {
    	return process(variables, Locale.UK);
    }
    
    /**
     * Processes the current template using the variables specified
     * 
     * @param variables The variables
     * @param locale The locale to use
     * @return The processed template
     */
    protected String process(Map<String, Object> variables, Locale locale) {
        return engine.process("ignored", new Context(locale, variables));
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
