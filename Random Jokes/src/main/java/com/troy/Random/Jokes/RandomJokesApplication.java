package com.troy.Random.Jokes;

import com.troy.Random.Jokes.hello.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class RandomJokesApplication{

    private static final Logger log = LoggerFactory.getLogger(RandomJokesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RandomJokesApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}



	@Bean
	public ApplicationRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Type type = restTemplate.getForObject("http://api.icndb.com/jokes/randomm", Type.class);
			log.info(type.toString());



		};
	}


//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//    @Scheduled(fixedRate = 5000)
//        public void reportCurrentTime(){
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }


















}
