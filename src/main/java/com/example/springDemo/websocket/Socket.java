package com.example.springDemo.websocket;

import org.springframework.stereotype.Controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author 蒋明海 on 2019/6/3
 */


@Controller
@ServerEndpoint("/websocket")
public class Socket {

    /*websocket 客户端会话 通过Session 向客户端发送数据*/
    private Session session;
    /*线程安全set 存放每个客户端处理消息的对象*/
    private static CopyOnWriteArraySet<Socket> webSocketSet = new CopyOnWriteArraySet();
    /*websocket 连接建立成功后进行调用*/
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        System.out.println("websocket 有新的链接"+webSocketSet.size());
    }
    /*websocket 链接关闭调用的方法*/
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        System.out.println("链接关闭");
    }
    /*收到客户端消息后调用的方法*/
    @OnMessage
    public void onMessage(String message) throws IOException {
        for (Socket socket : webSocketSet) {
            socket.session.getBasicRemote().sendText("自己嘎给自己嘎发的消息："+message);
        }
    }
    /*websocket 发生错误时进行调用*/
    @OnError
    public void onError(Session session,Throwable error){
        error.printStackTrace();
    }
    public void sendMessage(String message) throws IOException {
        for (Socket socket : webSocketSet) {
            socket.session.getBasicRemote().sendText(message);
        }
    }
    public Session getSession() {
        return session;
    }
    public void setSession(Session session) {
        this.session = session;
    }
}
