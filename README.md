## JodaTime ThymeLeaf Dialect

#### Basic Usage

Expression syntax with standard dialect

    th:text="${#joda.mediumDate(date)}"

Via attributes

    joda:mediumDate="${date}"

### POM Dependency

    <dependency>
      <groupId>uk.co.gcwilliams</groupId>
      <artifactId>jodatime-thymeleaf-dialect</artifactId>
      <version>1.3</version>
    </dependency>

### Download

Avaliable from Maven Central

[Download](http://search.maven.org/#search%7Cga%7C1%7Cjodatime-thymeleaf-dialect)

### Configuration

#### Basic

    TemplateEngine engine = new TemplateEngine();
    engine.addDialect(new JodaTimeDialect());

    ...

    engine.process("templateName", context);

#### Spring MVC
    
    <bean id="templateEngine" class="org.thymeleaf.spring3.SpringTemplateEngine">
      ...
      <property name="dialects">
          <set>
              <bean class="org.thymeleaf.spring3.dialect.SpringStandardDialect"></bean>
              <bean class="uk.co.gcwilliams.jodatime.thymeleaf.JodaTimeDialect"></bean>
          </set>
      </property>
      ...
    </bean>

### Supported formats

Expression Syntax

    ${#joda.fullDate(date)}
    ${#joda.fullDateTime(date)}
    ${#joda.fullTime(date)}
    ${#joda.longDate(date)}
    ${#joda.longDateTime(date)}
    ${#joda.longTime(date)}
    ${#joda.mediumDate(date)}
    ${#joda.mediumDateTime(date)}
    ${#joda.mediumTime(date)}
    ${#joda.shortDate(date)}
    ${#joda.shortDateTime(date)}
    ${#joda.shortTime(date)}
    ${#joda.isoDateTime(date)}

plus any valid JodaTime format with 

    ${#joda.format(date, ...)}

Attributes

    joda:fullDate="${date}"
    joda:fullDateTime="${date}"
    joda:fullTime="${date}"
    joda:longDate="${date}"
    joda:longDateTime="${date}"
    joda:longTime="${date}"
    joda:mediumDate="${date}"
    joda:mediumDateTime="${date}"
    joda:mediumTime="${date}"
    joda:shortDate="${date}"
    joda:shortDateTime="${date}"
    joda:shortTime="${date}"
    joda:isoDateTime="${date}"

### License

GPL Licence - http://www.gnu.org/licenses/gpl-3.0.txt