## JodaTime ThymeLeaf Dialect

#### Basic usage

Expression syntax with standard dialect

    th:text="${#joda.mediumDate(date)}"

Via attributes

    joda:mediumDate="${date}"

#### Example configuration for Spring MVC
    
    <bean id="templateEngine" class="org.thymeleaf.spring3.SpringTemplateEngine">
      ...
      <property name="dialects">
          <set>
              <bean class="org.thymeleaf.spring3.dialect.SpringStandardDialect"></bean>
              <bean class="gwilliams.jodatime.thymeleaf.JodaTimeDialect"></bean>
          </set>
      </property>
      ...
    </bean>

#### Supported formats

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

Attribute

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