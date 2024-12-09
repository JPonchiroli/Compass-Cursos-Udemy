package com.pbcompass.mscreditassessor.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.emission-card}")
    private String emissionCardQueue;

    @Bean
    public Queue queueEmissionCards(){
        return new Queue(emissionCardQueue, true);
    }
}
