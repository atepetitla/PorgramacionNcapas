package com.digi01.ATepetitlaProgramacionNweb;

import java.lang.System.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import static org.springframework.boot.Banner.Mode.LOG;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ATepetitlaProgramacionNwebApplication implements CommandLineRunner{
//private static org.slf4j.Logger LOG = LoggerFactory.getLogger(SpringApplication.class);
protected final Log logger = LogFactory.getLog(getClass());
    public static void main(String[] args) {
		SpringApplication.run(ATepetitlaProgramacionNwebApplication.class, args);
	
        }

    @Override
    public void run(String... args) throws Exception {
        
        logger.info("Hola mundo");
    }
    
}
