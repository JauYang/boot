package com.jauyang.boot.config;

import com.jauyang.boot.dto.MessageDto;
import io.github.majusko.pulsar.producer.ProducerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yann
 * @date 2021-08-06 17:45
 */
@Configuration
public class PulsarConfig {

    @Bean
    public ProducerFactory producerFactory() {
        return new ProducerFactory()
                .addProducer("bootTopic", MessageDto.class)
                .addProducer("stringTopic", String.class);
    }

}
