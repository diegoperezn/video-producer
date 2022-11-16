package com.ar.jorge.newbery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@EnableAutoConfiguration
public class App {
    // public static void main( String[] args ) throws Exception
    // {
    // JettyServer server = new JettyServer();

    // server.start();
    // }

    Logger logger = LoggerFactory.getLogger(App.class);

    @RequestMapping("/")
    String home() {

        logger.info("log");

        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
