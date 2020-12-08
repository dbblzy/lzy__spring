package com.hou.lzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication(scanBasePackages = "com")

public class LzyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LzyApplication.class, args);
    }

}
