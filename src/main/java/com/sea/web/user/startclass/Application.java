package com.sea.web.sso.startclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Start Class.
 *
 * Created by chris on 17-2-25.
 */
@Configuration
@ComponentScan("com.sea.web.moon")
@EnableAutoConfiguration
public class Application {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
    System.out.println("Vip business started ... ... OK");
  }
}
