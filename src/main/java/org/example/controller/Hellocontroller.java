package org.example.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {
    @GetMapping("/welcome")
    public String displayMessage(){
        return "Congratulation you successfully deployed your application to kubernetes !!";
    }
}
