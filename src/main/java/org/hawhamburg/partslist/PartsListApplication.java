package org.hawhamburg.partslist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PartsListApplication {

    static Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        log.info("Old Log4J is dangerous!");
        SpringApplication.run(PartsListApplication.class, args);
    }

}
