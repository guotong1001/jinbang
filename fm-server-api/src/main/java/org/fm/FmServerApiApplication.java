package org.fm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("org.fm.fm.dao")
@ComponentScan(basePackages = {"org.fm.**"})
public class FmServerApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FmServerApiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FmServerApiApplication.class);
    }
}
