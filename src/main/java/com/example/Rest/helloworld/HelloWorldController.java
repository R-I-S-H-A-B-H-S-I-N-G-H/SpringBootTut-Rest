package com.example.Rest.helloworld;

import java.util.List;

import javax.print.DocFlavor.STRING;

import org.springframework.web.bind.annotation.*;

// REST API
@RestController
public class HelloWorldController {
    // /hello-world
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world2")
    public List<String> helloWorld2() {
        return List.of("Hello World2");
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldbean() {
        return new HelloWorldBean("HELLO WORLD BEAN");
    }

    @GetMapping(path = "/hello-world/pathvar/{name}")
    public HelloWorldBean helloWorldpathvar(@PathVariable String name) {
        return new HelloWorldBean("HELLO " + name);
    }
    // @GetMapping(path = "/error")
    // public HelloWorldBean error() {
    // return new HelloWorldBean("ERROR 404");
    // }
}
