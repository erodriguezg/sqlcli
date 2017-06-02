package com.github.erodriguezg.sqlcli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class SqlcliApplication {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Logger log(InjectionPoint ip) {
        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SqlcliApplication.class);
        ConsoleComponent consoleComponent = context.getBean(ConsoleComponent.class);
        consoleComponent.procesar(args);
    }

}
