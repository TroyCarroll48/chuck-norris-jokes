package com.troy.Random.Jokes.hello;

import com.troy.Random.Jokes.RandomJokesApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class Value {

    private static final Logger log = LoggerFactory.getLogger(Value.class);

    private Long id;

    private String joke;

    String categories[];

    public Value(Long id, String joke, String[] categories) {
        this.id = id;
        this.joke = joke;
        this.categories = categories;
    }

    public Value() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", joke='" + joke + '\'' +
                ", categories=" + Arrays.toString(categories) +
                '}';
    }


    @Scheduled(fixedRate = 2000)
    public void Time() {
        RestTemplate restTemplate = new RestTemplate();
        Type type = restTemplate.getForObject("http://api.icndb.com/jokes/random", Type.class);
        log.info(type.toString());


    }
}
