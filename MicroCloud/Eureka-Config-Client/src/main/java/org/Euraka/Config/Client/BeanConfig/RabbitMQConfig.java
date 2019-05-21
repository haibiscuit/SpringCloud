package org.Euraka.Config.Client.BeanConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.AMQP.Queue;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue logOpQueue(){
        return new Queue();
    }
 
}
