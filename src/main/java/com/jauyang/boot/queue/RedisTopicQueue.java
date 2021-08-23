package com.jauyang.boot.queue;

import com.jauyang.boot.dto.MessageDto;
import com.jauyang.boot.websocket.WSEndpoint;
import com.jauyang.boot.websocket.WSMsgConsumer;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Yann
 * @date 2021-08-20 16:35
 */
@Component
@Slf4j
public class RedisTopicQueue {

    private final RedissonClient redissonClient;

    private static RTopic WS_TOPIC = null;

    public RedisTopicQueue(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @PostConstruct
    public void initDelayQueue() {
        WS_TOPIC = redissonClient.getTopic("WS_TOPIC");
        log.info(">>>Start RedisTopicQueue<<<");
        WS_TOPIC.addListener(MessageDto.class, (charSequence, messageDto) -> {
            log.info(messageDto.getContent());
            log.info("^^^messageDto^^^");
            WSMsgConsumer.notifyAllSession(messageDto, WSEndpoint.SESSION_MAP);
        });
        log.info(">>>>>>>>>>>><<<<<<<<<<<<<<<");
    }

    /**
     * 添加队列
     */
    public <T> void publish(MessageDto messageDto) {
        if(WS_TOPIC ==null){
            WS_TOPIC = redissonClient.getTopic("WS_TOPIC");
        }
        WS_TOPIC.publish(messageDto);
    }

}
