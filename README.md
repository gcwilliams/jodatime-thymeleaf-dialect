## JodaTime ThymeLeaf Dialect

#### Usage

Expression syntax with standard dialect

`th:text="${#joda.mediumDate(date)}"`

Via attributes

`joda:mediumDate="${date}"`

#### Example configuration for Spring MVC
    
`<bean id="templateEngine" class="org.thymeleaf.spring3.SpringTemplateEngine">
  ...
  <property name="dialects">
      <set>
          <bean class="org.thymeleaf.spring3.dialect.SpringStandardDialect"></bean>
          <bean class="gwilliams.jodatime.thymeleaf.JodaTimeDialect"></bean>
      </set>
  </property>
  ...
</bean>`