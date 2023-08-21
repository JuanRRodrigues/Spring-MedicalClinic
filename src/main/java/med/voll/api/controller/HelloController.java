package med.voll.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // It's the one that intercepts the request; it's the API's entry point.
@RequestMapping("/hello") //Indicates that the controller will handle requests made to the URL.
public class HelloController {


    @GetMapping
    public String helloWorld(){
        return "hello World spring";
    }
}
