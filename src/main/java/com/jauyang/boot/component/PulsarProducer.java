package com.jauyang.boot.component;

import com.jauyang.boot.dto.MessageDto;
import io.github.majusko.pulsar.producer.PulsarTemplate;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.stereotype.Component;

/**
 * @author Yann
 * @date 2021-08-06 17:50
 */
@Component
public class PulsarProducer {

    private final PulsarTemplate<MessageDto> template;

    public PulsarProducer(PulsarTemplate<MessageDto> template) {
        this.template = template;
    }

    public void send(MessageDto message){
        try {
            template.send("bootTopic",message);
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
    }

}
