package com.kaisikk.java.springdatabase.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pingpong")
public class WebSocketController {

    @GetMapping
    public String pibgPong(){
        return "pingpong";
    }

}
