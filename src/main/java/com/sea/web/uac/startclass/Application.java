package com.sea.web.uac.startclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Start Class.
 *
 * Created by chris on 17-2-25.
 */
@Configuration
@ComponentScan("com.sea.web.uac")
@MapperScan("com.sea.web.uac.dao")
@EnableAutoConfiguration
public class Application {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
    System.out.println("UAC started ... ... OK");
  }
}
