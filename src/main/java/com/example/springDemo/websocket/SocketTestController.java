package com.example.springDemo.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author 蒋明海 on 2019/6/3
 */


@RestController
@RequestMapping("socket")
public class SocketTestController {

    @Autowired
    private Socket socket;
    @GetMapping("/{message}")
    public void sendMessage(@PathVariable("message") String message) throws IOException {
        socket.sendMessage("这个是controller 发送的消息："+message);
    }


    @GetMapping("/test")
    public  String test(){
        return "12121212";
    }
}
