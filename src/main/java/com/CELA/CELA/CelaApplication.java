package com.CELA.CELA;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CelaApplication {

    // Create a logger instance
    private static final Logger logger = LogManager.getLogger(CelaApplication.class);

    public static void main(String[] args) {
        logger.info("main method started");
        SpringApplication.run(CelaApplication.class, args);
        logger.debug("Thank you everything is all right");
    }
}
