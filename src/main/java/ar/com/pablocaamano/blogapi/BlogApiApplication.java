package ar.com.pablocaamano.blogapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApiApplication {

	private static final Logger logger = LoggerFactory.getLogger(BlogApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
		logger.info("[ blog-api ] - Application is now running...");
	}

}
