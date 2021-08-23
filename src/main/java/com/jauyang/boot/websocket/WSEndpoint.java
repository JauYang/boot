package com.jauyang.boot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yann
 * @date 2021-08-20 16:52
 */

@Slf4j
@Component
@ServerEndpoint("/ws")
public class WSEndpoint {

    public static ConcurrentHashMap<String, Session> SESSION_MAP = new ConcurrentHashMap<>(1024);


    @OnOpen
    public void onOpen(Session session){
        log.info("【websocket】连接开始，ID:{}", session.getId());
        SESSION_MAP.put(session.getId(), session);
    }

    @OnClose
    public void onClose(Session session) {
        log.info("【websocket】关闭开始，ID:{}", session.getId());
        SESSION_MAP.remove(session.getId(), session);
    }

    @OnMessage
    public void onMessage(Session session, String msg) {
        log.info("【websocket】收到消息，{}", msg);
    }

    @OnError
    public void onError(Throwable e){
        log.info("【websocket】异常，{}", e.getMessage());
    }

    private void closeSession(Session session) {
        try {
            if (session != null&&session.isOpen()) {
                session.close();
            }
        } catch (Exception ee) {
            ee.printStackTrace();
            log.error("websocket: close session exception : {}", ee.getMessage());
        }
    }

    public static void sendMsg(Session session,String msg){
        if (session != null&&session.isOpen()) {
            session.getAsyncRemote().sendText(msg);
        }
    }
}
