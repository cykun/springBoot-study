package com.cyquen.websocket.config;

import com.cyquen.websocket.dto.CommonRequest;
import com.cyquen.websocket.dto.CommonResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/websocket/{userId}")
@Component
public class WebSocketServer {

    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);
    private static final ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();

    private Session session;
    private String userId = "";

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        this.userId = userId;
        webSocketMap.put(userId, this);

        try {
            CommonResponse response = new CommonResponse();
            response.setFromUserId("system");
            response.setToUserId(this.userId);
            response.setContentText("connected successfully");
            sendMessage(new ObjectMapper().writeValueAsString(response));
        } catch (IOException e) {
            log.error("用户:" + userId + ",网络异常!!!!!!");
        }
    }

    @OnClose
    public void onClose() {
        webSocketMap.remove(userId);
    }

    @OnMessage
    public void onMessage(String message) {
        if (StringUtils.hasText(message)) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                CommonRequest request = mapper.readValue(message, CommonRequest.class);
                String toUserId = request.getToUserId();
                if (StringUtils.hasText(toUserId) && webSocketMap.containsKey(toUserId)) {
                    CommonResponse response = new CommonResponse();
                    response.setFromUserId(this.userId);
                    response.setToUserId(request.getToUserId());
                    response.setContentText(request.getContentText());
                    webSocketMap.get(toUserId).sendMessage(mapper.writeValueAsString(response));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    @OnError
    public void onError(Throwable error) {
        log.error("用户错误:" + this.userId + ",原因:" + error.getMessage());
        error.printStackTrace();
    }
}
