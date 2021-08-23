package com.jauyang.boot.websocket;

import cn.hutool.json.JSONUtil;
import com.jauyang.boot.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;

import javax.websocket.Session;
import java.util.Map;

/**
 * <p>
 * 后台的websocket统一推送
 * </p>
 *
 * @author Yann
 * @since 2020/10/13 1:33 下午
 */
@Slf4j
public class WSMsgConsumer {

    public static void notifyAllSession(MessageDto messageDto, Map<String, Session> sessionMap){
        log.info(">>>WebSocketNotify-ALL:{}", JSONUtil.toJsonStr(messageDto));
        sessionMap.forEach((k,v)->{
            try {
                notifyToSession(v,messageDto);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(">>> 推送ws异常,{}",e.getMessage());
            }
        });
    }

    public static void notifyToSession(Session session, MessageDto messageDto){
        log.info(">>>WebSocketNotify-SINGLE:{}", JSONUtil.toJsonStr(messageDto));
        WSEndpoint.sendMsg(session,JSONUtil.toJsonStr(messageDto));
    }

}
