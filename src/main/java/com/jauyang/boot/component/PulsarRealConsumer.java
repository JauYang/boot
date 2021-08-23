package com.jauyang.boot.component;

import com.jauyang.boot.dto.MessageDto;
import io.github.majusko.pulsar.annotation.PulsarConsumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.SubscriptionType;
import org.springframework.stereotype.Component;

/**
 * @author Yann
 * @date 2021-08-06 17:51
 */
@Component
@Slf4j
public class PulsarRealConsumer {

    @PulsarConsumer(topic = "bootTopic", clazz = MessageDto.class, subscriptionType = SubscriptionType.Shared)
    public void consume(MessageDto message) {
        log.info("PulsarRealConsumer consume id:{},content:{}", message.getId(), message.getContent());
    }

}
